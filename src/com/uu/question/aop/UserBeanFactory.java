package com.uu.question.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class UserBeanFactory {

	/**
	 * jdk动态代理实现的增强
	 * 
	 * @return
	 */
	public static UserService createServiceByJdkProxy() {
		// 1. 目标类
		final UserService userService = new UserServiceImpl();
		// 2. 切面类
		final UserAspect userAspect = new UserAspect();

		UserService proxyService = (UserService) Proxy.newProxyInstance(UserBeanFactory.class.getClassLoader(),
				userService.getClass().getInterfaces(), new InvocationHandler() {

					@Override
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						String methodName = method.getName();
						if (methodName.equals("addUser")) {
							userAspect.before();
							Object object = method.invoke(userService, args);
							userAspect.after();
							return object;
						} else {
							return method.invoke(userService, args);
						}

					}
				});
		return proxyService;
	}

	public static UserServiceImpl createServiceByCglib() {
		final UserServiceImpl userService = new UserServiceImpl();
		final UserAspect userAspect = new UserAspect();

		// 采用cglib ,底层创建目标类的子类
		Enhancer enhancer = new Enhancer();
		// 确定父类
		enhancer.setSuperclass(userService.getClass());
		/*
		 * 3.3 设置回调函数 , MethodInterceptor接口 等效 jdk InvocationHandler接口
		 * intercept() 等效 jdk invoke() 参数1、参数2、参数3：以invoke一样 参数4：methodProxy
		 * 方法的代理
		 * 
		 */
		enhancer.setCallback(new MethodInterceptor() {

			@Override
			public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy)
					throws Throwable {
				String methodName = method.getName();
				Object object = null;
				if (methodName.equals("addUser")) {
					userAspect.before();
					object = method.invoke(userService, args);
					userAspect.after();

					// TODO Auto-generated method stub
				} else {
					// * 执行代理类的父类 ，执行目标类 （目标类和代理类 父子关系）
					object = methodProxy.invokeSuper(proxy, args);
				}
				return object;
			}
		});
		// 3.4 创建代理
		UserServiceImpl proxService = (UserServiceImpl) enhancer.create();
		return proxService;

	}

	public static void main(String[] args) {
		// UserService userService = createServiceByJdkProxy();
		UserService userService = createServiceByCglib();
		userService.addUser();
		userService.deleteUser();

	}
}
