package com.hbj.thread.synchronization.staticMethod;

/**
 * Created by huangbingjing on 18/1/26.
 */
public class SyncThread implements Runnable{

	private static int count;

	public SyncThread() {
		count = 0;
	}

	public synchronized static void method(){
		for (int i = 0; i < 5; i++) {
			try {
				System.out.println(Thread.currentThread().getName() + ":" + (count++));
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void run() {
		method();
	}


	public int getCount() {
		return count;
	}
}


