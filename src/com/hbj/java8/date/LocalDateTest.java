package com.hbj.java8.date;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * Created by huangbingjing on 18/5/15.
 */
public class LocalDateTest {
	public static void main(String[] args) {
		//获取当前日期-> 2018-05-15
		LocalDate today = LocalDate.now();
		System.out.println("today = " + today);

		//获取年月日-> 年:2018 月:5 day:15
		int year = today.getYear();
		int month = today.getMonthValue();
		int day = today.getDayOfMonth();
		System.out.println("年:"+year+" \n月:"+month+" \nday:"+day);

		//获取特定日期-> 2017-05-09
		LocalDate dateOfBirth = LocalDate.of(2017,5,9);
		System.out.println("dateOfBirth = " + dateOfBirth);

		//一周后日期
		LocalDate aftWeek = today.plus(1, ChronoUnit.WEEKS);
		System.out.println("aftWeek = " + aftWeek);
	}
}
