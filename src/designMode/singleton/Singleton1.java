package designMode.singleton;

/**
 * @Description:饿汉式
 * @author: huangbingjing
 * @date: 19/2/14
 */
public class Singleton1 {

	public static void main(String[] args) {
		Singleton11 a = Singleton11.getInstance();
	}
}


class Singleton11{
	private static Singleton11 singleton11 = new Singleton11();

	private Singleton11() { }
	public static Singleton11 getInstance(){
		return singleton11;
	}
}
