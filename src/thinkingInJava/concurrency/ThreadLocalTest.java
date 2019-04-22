package thinkingInJava.concurrency;

/**
 * @Description:
 * @author: huangbingjing
 * @date: 19/2/14
 */
public class ThreadLocalTest {
	ThreadLocal<Long> longLocal = new ThreadLocal<Long>();
	ThreadLocal<String> stringLocal = new ThreadLocal<String>();


	public void set() {
		longLocal.set(Thread.currentThread().getId());
		stringLocal.set(Thread.currentThread().getName());
	}

	public Long getLong() {
		return longLocal.get();
	}

	public String getString() {
		return stringLocal.get();
	}

	public static void main(String[] args) throws InterruptedException {
		ThreadLocalTest test = new ThreadLocalTest();
		test.set();
		System.out.println(test.getLong());
		System.out.println(test.getString());

		Thread thread1 = new Thread(){
			public void run() {
				test.set();
				System.out.println(test.getLong());
				System.out.println(test.getString());
			};
		};

		Thread thread2 = new Thread(){
			public void run() {
				test.set();
				System.out.println(test.getLong());
				System.out.println(test.getString());
			};
		};
		thread1.start();
		thread2.start();
		thread1.join();
		thread2.join();

		System.out.println(test.getLong());
		System.out.println(test.getString());

	}

}
