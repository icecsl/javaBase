package com.hbj.java8.date;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by huangbingjing on 18/5/15.
 */
public class LocalTimeTest {
	public static void main(String[] args) {
		//获取当前时间,不包含日期-> 13:45:02.966
		LocalTime localTime = LocalTime.now();
		System.out.println("time = " + localTime);

		//获取特定时间-> 14:45:20
		LocalTime ofTime = LocalTime.of(14,45,10);
		System.out.println("ofTime = " + ofTime);

		//增加小时数 -> 15:45:02.966
		LocalTime aftTwo = localTime.plusHours(2);
		System.out.println("aftTwo = " + aftTwo);

		//增加小时数 -> 11:45:02.966
		LocalTime bfeTwo = localTime.minusHours(2);
		System.out.println("bfeTwo = " + bfeTwo);

		DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		System.out.println(LocalDateTime.parse("2018-01-12 18:00:00", df));



	}
}
