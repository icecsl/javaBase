package thinkingInJava.operators;

import java.util.Random;

/**
 * @Description:
 * @author: huangbingjing
 * @date: 18/12/26
 */
public class OperatorTest {

	public OperatorTest() {
	}

	public static void main(String[] args) {

		//短路现象: 一旦能够明确整个表达式的值，就不会计算剩余部分。
//		boolean b = test1() || test2() || test3();
//		System.out.println("result b = "+b);


		int i = -1;
		i >>>= 10;
		System.out.println(Integer.toBinaryString(i));
		String s ="jfal";

		switch (s){
			case "qqq":
				System.out.println("yes"); break;
			case "ssss":
				System.out.println("yes"); break;
		}

	}



	public static boolean test1(){
		System.out.println("test1.execute.....");
		return true;
	}

	public static boolean test2(){
		System.out.println("test2.execute.....");
		return false;
	}

	public static boolean test3(){
		System.out.println("test3.execute.....");
		return true;
	}


	/**
	 * 对于同一个种子，每次生成的都一样。如果不指定种子，会将当前时间作为种子，所以每次执行结果都不一样。
	 */
	public static void randomTest(){

		Random rand = new Random(47); //相同的种子，每次next会一样
//		Random rand = new Random(); //不传种子，每次都不一样
		System.out.println(rand.nextInt(100));
		System.out.println(rand.nextInt(100));
		System.out.println(rand.nextInt(100));
	}
}
