package mkt.biz.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * 数据格式转换类
 */
public class DataFormat {

    private static final Logger logger = LoggerFactory.getLogger(DataFormat.class);


    private static final String DATE_PATTERN = "yyyy-MM-dd";

    private static final String TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";

    /**
     * 由yyyy-MM-dd格式的字符串返回日期
     *
     * @param string
     * @return
     */
    public static Date stringToDate(String string) throws Exception {
        if (string == null)
            return null;

        if (string.trim().length() == 0)
            return null;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
                DataFormat.DATE_PATTERN);
        try {
            return simpleDateFormat.parse(string);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 由yyyy-MM-dd HH:mm:ss格式的字符串返回日期时间
     *
     * @param string 时间
     * @return
     */
    public static Date stringToTime(String string) throws Exception {
        if (string == null)
            return null;

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
                DataFormat.TIME_PATTERN);
        try {
            return simpleDateFormat.parse(string);
        } catch (ParseException e) {
            return stringToDate(string);
        }
    }


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
            logger.info("[DataFormat.strToLocalTime][时间转化失败]");
            return null;
        }
    }
}