package com.uu.question.io处理;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public  class Test1 {

	/**
	 * 1. 输入一个文件名和一个字符串， 统计这个字符串在这个文件中出现的次数。
	 * 
	 * @throws IOException
	 */
	public static int testHowMuch(String fileName, String target) {
		int count = 0;
		FileReader isr;
		BufferedReader br;
		try {
			isr = new FileReader(fileName);
			br = new BufferedReader(isr);
			String line = null;
			while ((line = br.readLine()) != null) {
				int index = -1; // 记录每行出现目标字符串位置，方便统计每行数目
				while(line.length() >= target.length() && (index = line.indexOf(target)) > -1) {
					count++;
					line = line.substring(index + target.length());
				}
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return count;
	}
	
	
	/**
	 * 2. 如何用Java代码列出一个目录下所有的文件？ 
	 */
	public static void displayFile(String fileName){
		File f = new File(fileName);
		System.out.println(fileName + "..........目录下的文件....................");
		for(File temp :f.listFiles()){
			if(temp.isFile()){  // 是文件直接打印文件名称
				System.out.println(temp.getName());
			}else{ // 是目录递归打印文件名称
				displayFile(temp.getAbsolutePath());
			}
		}
	}
	
	
	
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
//		int count = testHowMuch("e:/howmuch.txt", "hello");
//		System.out.println("hello 的数目是： "+ count);
//	displayFile("E:/API");
	
		
		
		
	}
}
