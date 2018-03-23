package com.uu.question.StringBuffer;

public class SubString {
	public static void main(String[] args) {
		String str = "http://127.0.0.1:8088/upload/2018/03/01/djkdjsld.jpg";
		str.indexOf("/upload");
		System.out.println(str.substring(str.indexOf("/upload"), str.length()));
	}
}
