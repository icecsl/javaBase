package com.hbj.proTest;


import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * 数据格式转换类
 */
public class DataFormat {



    private static final String DATE_PATTERN = "yyyy-MM-dd";

    private static final String TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";


    /* ==================  新增 ====================== */
    public static String getNow(String format) {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern(format));
    }

    public static String getTodayDate() {
        return LocalDate.now().format(DateTimeFormatter.ISO_DATE);
    }
    /**
     * 获取n天后的日期
     * @return
     */
    public static String getDateAfterOffset(int days) {
        return LocalDate.now().plusDays(days).format(DateTimeFormatter.ISO_DATE);
    }

    //string转时间，string格式为"18:00:00"
    public static LocalTime strToLocalTime(String localDateTime){
        String[] item = localDateTime.split(":");
        try {
            return LocalTime.of(Integer.valueOf(item[0]),Integer.valueOf(item[1]),Integer.valueOf(item[2]));
        }catch (Exception e){
            return null;
        }
    }

    public static LocalDate parseBirthday(String birthday) {
        if (birthday == null || birthday.length() != 4){
            return null;
        }

        try {
            int year = LocalDate.now().getYear();
            int month = Integer.valueOf(birthday.substring(0,2));
            int day = Integer.valueOf(birthday.substring(2,4));
            return LocalDate.of(year, month, day);
        }catch (Exception e){
            System.out.println("[parseBirthday][NumberFormatException][生日格式有误]");
            return null;
        }

    }

	public static Date LDtoDate(LocalDate localDate) {
		return Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
	}

	public static Date getDayEnd(LocalDate localDate) {
		LocalDateTime today_end = LocalDateTime.of(localDate, LocalTime.MAX);
		return Date.from(today_end.atZone(ZoneId.systemDefault()).toInstant());
	}


	//string 转 LocalDateTime  "2017-01-01 19:00:00"
	public static LocalDateTime strToLDT(String localDateTime){
		DateTimeFormatter df = DateTimeFormatter.ofPattern(DataFormat.TIME_PATTERN);
		return LocalDateTime.parse(localDateTime, df);
	}

	public static String dateToStr(Date d){
		if (d == null){
			return null;
		}
		SimpleDateFormat sdf = new SimpleDateFormat(TIME_PATTERN);
		return sdf.format(d);
	}
}