package thinkingInJava.concurrency;

/**
 * @Description:
 * @author: huangbingjing
 * @date: 19/1/23
 */
public class BasicThread {
	public static void main(String[] args) {

		for (int i = 0; i<5; i++){
			Thread thread = new Thread(new LightOff());
			thread.start();
		}

		System.out.println("Waiting for lightoff"); // 证明main线程已执行完毕
	}
}
