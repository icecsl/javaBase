package thinkingInJava.base;

import java.util.Random;

/**
 * @Description:
 * @author: huangbingjing
 * @date: 18/12/26
 */
public class RandomTest {

	//
	public static void main(String[] args) {
		randomSeed(47);
		randomSeed2();
	}

	//对于同一个种子，每次生成的都一样。如果不指定种子，会将当前时间作为种子
	public static void randomSeed(int seed){
		Random random = new Random(seed);
		int i = random.nextInt(100);
		System.out.println(i);
	}
	public static void randomSeed2(){
		Random random = new Random();
		int i = random.nextInt(100);
		System.out.println(i);
	}

}
