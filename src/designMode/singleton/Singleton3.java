package designMode.singleton;

/**
 * @Description:静态内部类
 * @author: huangbingjing
 * @date: 19/2/14
 */
public class Singleton3 {

	private Singleton3 (){}
	public static final Singleton3 getInstance() {
		return SingletonHolder.INSTANCE;
	}

	private static class SingletonHolder {
		private static final Singleton3 INSTANCE = new Singleton3();
	}
}
