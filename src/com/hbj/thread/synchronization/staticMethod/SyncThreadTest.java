package com.hbj.thread.synchronization.staticMethod;



/**
 * Created by huangbingjing on 18/1/26.
 */
public class SyncThreadTest {
	public static void main(String[] args) {

		//thread1和thread2同时访问同一个对象(syncThread),在同一个时刻只有一个线程执行,另一个阻塞,直到1执行完释放锁
//		SyncThread syncThread = new SyncThread();
//		Thread thread1 = new Thread(syncThread, "SyncThread1");
//		Thread thread2 = new Thread(syncThread, "SyncThread2");
//		thread1.start();
//		thread2.start();

		//thread1和thread2访问两个对象(syncThread),synchronized锁定的是各自的对象,互不干扰...thread1执行1的run,thread2执行的是2的run
		SyncThread syncThread = new SyncThread();
		Thread thread1 = new Thread(new SyncThread(), "SyncThread1");
		Thread thread2 = new Thread(new SyncThread(), "SyncThread2");
		thread1.start();
		thread2.start();

	}
}
