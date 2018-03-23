package com.uu.question.日期时间;

import java.time.LocalDateTime;
import java.util.Calendar;

import org.junit.Test;

public class DataTimeTest {
	public static void main(String[] args) {

		// java 7
		Calendar cal = Calendar.getInstance();
		System.out.println(cal.get(Calendar.YEAR));
		System.out.println(cal.get(Calendar.MONTH)); // 0 - 11
		System.out.println(cal.get(Calendar.DATE));
		System.out.println(cal.get(Calendar.HOUR_OF_DAY));
		System.out.println(cal.get(Calendar.MINUTE));
		System.out.println(cal.get(Calendar.SECOND));

		System.out.println("-----------------------------------");
		// Java 8
		LocalDateTime dt = LocalDateTime.now();
		System.out.println(dt.getYear());
		System.out.println(dt.getMonthValue()); // 1 - 12
		System.out.println(dt.getDayOfMonth());
		System.out.println(dt.getHour());
		System.out.println(dt.getMinute());
		System.out.println(dt.getSecond());
	}

	/**
	 * 打印昨天的 当前时刻
	 */
	@Test
	public void test1() {

		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -1);
		System.out.println(cal.getTime());
		
		System.out.println("......................"); 
		//java 8
		LocalDateTime today = LocalDateTime.now();
        LocalDateTime yesterday = today.minusDays(1);

        System.out.println(yesterday);

		
	}

}
