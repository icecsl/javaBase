package com.hbj.proTest;

/**
 * @Description:
 * @author: huangbingjing
 * @date: 18/8/10
 */
public class DateTest {

	private static String firstTime = "10:00:00";
	private static String secondTime = "18:00:00";

	public static void main(String[] args) {
		/*LocalTime nowTime = LocalTime.now();
		LocalTime firstNoticeTime = DataFormat.strToLocalTime(firstTime);
		LocalTime secondNoticeTime = DataFormat.strToLocalTime(secondTime);
		// TODO: 18/8/10 时间判空
		String fromTime = null;
		String toTime = null;
		if (nowTime.isAfter(secondNoticeTime)){
			//起始时间9-6
			fromTime= LocalDate.now()+" "+firstTime;
			toTime= LocalDate.now()+" "+secondTime;
		}else if (nowTime.isAfter(firstNoticeTime)){
			//起始时间前一天的6-今天的9
			fromTime= LocalDate.now().minusDays(1)+" "+secondTime;
			toTime= LocalDate.now()+" "+firstTime;
		}

		System.out.println(fromTime);
		System.out.println(toTime);
*/

//		LocalDate localDate = DataFormat.parseBirthday("1223");
//		System.out.println(localDate);
//

//		LocalDate beginOfYear = LocalDate.of(LocalDate.now().getYear(), 1,1);
//		System.out.println(beginOfYear.format(DateTimeFormatter.ISO_DATE));

/*		Date date = DataFormat.LDtoDate(LocalDate.now().plusDays(2));
		System.out.println(date);*/

//		Date date = DataFormat.getDayEnd(LocalDate.now());
//		System.out.println(date);

//		LocalDateTime localDateTime = DataFormat.strToLDT("2017-01-01 19:00:00");
//		System.out.println(localDateTime);

//		String dateStr = DataFormat.dateToStr(new Date());
//		System.out.println(dateStr);


		String dateStr = DataFormat.getTodayDate();
		System.out.println(dateStr);


	}


}
