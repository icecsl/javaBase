package thinkingInJava.base_1.mian;

/**
 * @Description:
 * @author: huangbingjing
 * @date: 19/3/4
 */
public class FishMan {
	public static void main(String[] args) {
		Fish f = new Walleye();
		Walleye w = new Walleye();
		Bluegill b = new Bluegill();

		if (f instanceof Perch){
			System.out.println("f-p");
		}
		if (w instanceof Fish){
			System.out.println("w-f");
		}if (b instanceof Fish){
			System.out.println("b-p");
		}

	}
}
class Perch implements Fish{}
class Walleye extends Perch{}
class Bluegill{}
