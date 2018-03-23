package com.uu.question.注解;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.net.Authenticator.RequestorType;

@Documented	// javadoc 中包含
@Inherited  // 可以被集成
@Retention(RetentionPolicy.RUNTIME)	// 作用于运行时期
@Target({ ElementType.TYPE, ElementType.FIELD,ElementType.METHOD }) // 次注解作用于类和字段上
public @interface FieldTypeAnnotation {
	String type() default "ignore";

	int age() default 27;

	String[] hobby() default { "hehe", "nicai" }; // 没有指定defalut的，需要在注解的时候显式指明
}