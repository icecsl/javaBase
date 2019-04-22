package designMode.singleton;

/**
 * @Description:懒汉式
 * @author: huangbingjing
 * @date: 19/2/14
 */
public class Singleton2 {
}

//获取对象时候，如果是空才创建，但是线程不安全
class Singleton21{
	private static Singleton21 singleton21 = null;

	private Singleton21() { }
	public static Singleton21 getInstance(){
		if (singleton21 == null){
			singleton21=new Singleton21();
		}
		return singleton21;
	}
}

//线程安全，但是每次获取对象都要加锁。
class Singleton22{
	private static Singleton22 singleton22 = null;

	private Singleton22() { }
	public static Singleton22 getInstance(){
		synchronized(Singleton22.class){
			if (singleton22 == null){
				singleton22=new Singleton22();
			}
		}
		return singleton22;
	}
}

class Singleton23{
	private static volatile Singleton23 singleton23 = null;

	private Singleton23() { }
	public static Singleton23 getInstance(){
		if (singleton23 == null){
			synchronized(Singleton23.class){
				if (singleton23 == null){
					singleton23=new Singleton23();
				}
			}
		}

		return singleton23;
	}
}


