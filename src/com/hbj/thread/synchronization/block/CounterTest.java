package com.hbj.thread.synchronization.block;

/**
 * Created by huangbingjing on 18/1/29.
 */
public class CounterTest {
	public static void main(String[] args) {

		//一个线程访问一个对象的synchronized代码块时，别的线程可以访问该对象的非synchronized代码块而不受阻塞

		Counter counter = new Counter();
		Thread thread1 = new Thread(counter, "A");
		Thread thread2 = new Thread(counter, "B");
		thread1.start();
		thread2.start();
	}
}
