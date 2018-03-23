package com.uu.question.反转;

import org.junit.Test;

public class dd {
	
	/**
	 * @param originStr
	 * @return
	 * 
	 * 
	 * 过程 ：
	 * 		234567  			+  1
	 * 		34567 			+ 2
	 * 		4567		+3
	 * 		567		+4
	 * 		
	 */
	public static String reverse(String originStr) {
        if(originStr == null || originStr.length() <= 1) 
            return originStr;
        return reverse(originStr.substring(1)) + originStr.charAt(0);
    }

	public static void main(String[] args) {
		String test = "1234567";
		System.out.println(reverse(test));
	}
}
