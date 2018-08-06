package com.test.bigDecimal;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by huangbingjing on 18/6/25.
 */
public class SetScaleTest {
	public static void main(String[] args) {

//		BigDecimal a = new BigDecimal("12.792702");
//		a.setScale(1);

//		BigDecimal a = new BigDecimal("99-222");
//		System.out.println(a);

//		Random random = new Random();
//		long a = random.nextLong();
//		System.out.println(a);

		Long a = Long.valueOf("0");
		System.out.println(a);

		Map<String, Object> map = new HashMap<>();
		map.put("a",new A("ice", "12"));
		map.put("b","d");
		map.put("c","df");

		System.out.println(map.toString());

//		String s = generateMktNo(2013472239L,"participate_Act", "REDPACKET_MGM_FOR_9ANNIV");
//		System.out.println(s);


	}

	public static String generateMktNo(Long userId, String operate, String activity){

		StringBuilder builder = new StringBuilder();
		Random random = new Random();
		if (userId != null){
			builder.append(String.valueOf(userId));
		}
		builder.append(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddhhmmss")))
				.append(String.format("%0"+6+"d",random.nextInt(999999)));

		return builder.toString();
	}
}

class A{
	private String name;
	private String age;

	public A(String name, String age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		final StringBuffer sb = new StringBuffer("A{");
		sb.append("name='").append(name).append('\'');
		sb.append(", age='").append(age).append('\'');
		sb.append('}');
		return sb.toString();
	}
}
