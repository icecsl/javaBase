package com.test;

import java.math.BigDecimal;
import java.util.Random;

/**
 * Created by huangbingjing on 18/6/25.
 */
public class Test {

	public static void main(String[] args) {

		boolean rs = isWinning(new BigDecimal(20));
		System.out.println(rs);
	}

	private static boolean isWinning(BigDecimal cbOdds){
		BigDecimal winningNum=cbOdds.multiply(new BigDecimal(100));
		Random random = new Random();
		double value = random.nextDouble()*(10000);
		if(new BigDecimal(String.valueOf(value)) .compareTo(winningNum) < 0){
			return true;
		}

		return false;
	}

}
