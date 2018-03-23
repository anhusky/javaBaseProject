package com.uu.question.集合;

import java.util.TreeSet;

class uu implements Comparable{
	public String s ;

	public uu(String s) {
		this.s = s;
	}

	@Override
	public int compareTo(Object o) {
		return 0;
	}
	
}

public class TreeMapDemo {
//	cannot be cast to java.lang.Comparable
	public static void main(String[] args) {
		TreeSet<uu> uus = new TreeSet<uu>();
		uus.add(new uu("1"));
		uus.add(new uu("2"));
		uus.add(new uu("3"));
		System.out.println(uus.size());
	}
}
