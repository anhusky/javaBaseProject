package com.uu.question.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class UserBeanFactory {
	
	public static UserService createService(){
		// 1. 目标类
		UserService userService = new UserServiceImpl();
		// 2. 切面类
		UserAspect userAspect = new UserAspect();
		
		Proxy.newProxyInstance(UserBeanFactory.class.getClassLoader(), 
				userService.getClass().getInterfaces(), 
				new InvocationHandler() {
					
					@Override
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						return null;
					}
				});
		return userService;
	}
}
