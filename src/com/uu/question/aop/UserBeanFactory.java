package com.uu.question.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class UserBeanFactory {

	public static UserService createService() {
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

	public static void main(String[] args) {
		UserService userService = createService();
		userService.addUser();
		userService.deleteUser();

	}
}
