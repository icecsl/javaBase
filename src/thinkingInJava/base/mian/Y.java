package thinkingInJava.base.mian;

/**
 * @Description:
 * @author: huangbingjing
 * @date: 19/3/4
 */
public class Y extends X{
	public Y() {
		super(6);
		System.out.println(3);
	}
	public Y(int i) {
		this();
		System.out.println(4);
	}

	public static void main(String[] args) {
//		new Y(5);
		System.out.println(3%5);
		System.out.println(3/5);
		System.out.println(3/5.0);
		Y y = new Y();
		y.Y();
	}

	public void Y(){
		System.out.println("Y");
	}

}
class X{
	public X() {
		System.out.println(1);
	}
	public X(int i) {
		this();
		System.out.println(2);
	}
}

