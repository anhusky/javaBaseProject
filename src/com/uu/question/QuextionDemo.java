package com.uu.question;

import org.junit.Test;

public class QuextionDemo {
	
	public final QuextionDemo qd = new QuextionDemo();
	/**
	 * 方法区
	 * 
	 * @param args
	 */
	public void testPool(String[] args) {
		String s1 = new StringBuilder("go").append("od").toString();
		System.out.println(s1.intern() == s1);

		String s2 = new StringBuilder("ja").append("va").toString();
		System.out.println(s2.intern() == s2);

	}

	/**
	 * Switch(expr) 中 expr 的数据类型的测试
	 */
	public static void testSwitch() {
		String uu = "1";
		switch (uu) {
		case "1":

			System.out.println("海真蓝");
			break;
		case "2":
			System.out.println("天不错");
			break;

		}
	}

	/**
	 * 位运算，快速计算 2 * 8
	 */
	private static void testWeiCompute() {
		System.out.println(2 << 3);
	}

	public static void main(String[] args) {
		// testSwitch();
//		testWeiCompute();
//		testString();
		System.out.println("hello xiaoming".indexOf("xiaoming"));
	}

	private static void testString() {
		String s1 = "Programming";         // 常量池中的
		String s2 = new String("Programming");  // 堆内存中
		String s3 = "Program";
		String s4 = "ming";
		String s5 = "Program" + "ming";	  // 常量池中已经存在 ，不会常见新的 
		String s6 = s3 + s4;		// 堆中
		
		System.out.println(s1 == s2); // false
		System.out.println(s1 == s5); //...true
		System.out.println(s1 == s6); // false
		System.out.println(s1 == s6.intern());// true
		
		System.out.println(s2 == s2.intern()); // false
		// String intern() 
		//返回字符串对象的规范化表示形式。
		
	}
	
	@Test
	public void testFinal(){
		//qd = new QuextionDemo();
		System.out.println("我的机器可用Processor 数量" + Runtime.getRuntime().availableProcessors());
	}
	
}
