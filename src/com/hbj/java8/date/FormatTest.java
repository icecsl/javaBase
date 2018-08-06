package com.hbj.java8.date;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by huangbingjing on 18/5/15.
 */
public class FormatTest {
	public static void main(String[] args) {


		/* ==================== 字符串转日期 ================ */
		//BASIC_ISO_DATE:20180101 ISO_DATE:2018-01-01
		LocalDate date = LocalDate.parse("20160101", DateTimeFormatter.BASIC_ISO_DATE);
		System.out.println("date:" + date);

		//自定义格式
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM dd yyyy");
		LocalDate myday = LocalDate.parse("03 23 2017", formatter);
		System.out.println("myday:" + myday);

		/* ==================== 日期转字符串 ================ */
		DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("MM dd yyyy HH:mm");
		LocalDateTime time = LocalDateTime.now();
		String timeStr = time.format(formatter1);
		System.out.println("timeStr:" + timeStr);
	}
}
