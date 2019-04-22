package thinkingInJava.concurrency;

/**
 * @Description:
 * @author: huangbingjing
 * @date: 19/2/12
 */
public class VolatileTest2 implements Runnable {
	private static  boolean flag = true;

	public static void main(String[] args) {
		for (int j = 0; j < 10000; j++) {
			Thread t = new Thread(new VolatileTest2());
			t.start();
		}
	}

	public void run() {
		// 这里设置一个Flag，如果有线程执行，那么更改flag阻止其他线程打印。
		if (flag) {
			flag = false;
			System.out.println("我成功了！");
		}
	}
}
