package com.uu.question.StringBuffer;

public class StringBufferDemo {
	
	public static void main(String[] args) {
		
		/*
		         瀵逛簬 sb.length()  
		    		sb鐨勫疄闄呴暱搴�
		 	瀵逛簬sb.capacity()
		 		1. 褰� 10 > 濉厖涓暟
		 		 	鍊间负10 
		 		浠ヤ笅鎯呭喌锛岄渶瑕佸鍣ㄦ墿瀹�
		 		2. 褰� 10 < sb鐨勫疄闄呴暱搴� < 2*10+2 ,鍊间负  2*10+2
		 		3. 褰搒b鐨勫疄闄呴暱搴� > 2*10 + 2 ,鍊间负 sb鐨勫疄闄呴暱搴�
		 */
		
		StringBuffer sb = new StringBuffer(10);
		sb.append("12345678901234567890");
		
		sop(sb);
	}
	
	public static void sop(StringBuffer sb){
		System.out.println("sb.length()  = " + sb.length());
		System.out.println("db.capacity() = " + sb.capacity());
		
		
	}
}
