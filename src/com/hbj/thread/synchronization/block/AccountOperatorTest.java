package com.hbj.thread.synchronization.block;

/**
 * Created by huangbingjing on 18/1/29.
 */
public class AccountOperatorTest {
	public static void main(String[] args) {

		Account account = new Account("zhang san", 10000.0f);
		AccountOperator accountOperator = new AccountOperator(account);

		final int THREAD_NUM = 5;
		Thread threads[] = new Thread[THREAD_NUM];
		for (int i = 0; i < THREAD_NUM; i ++) {
			threads[i] = new Thread(accountOperator, "Thread" + i);
			threads[i].start();
		}
		//起了5个线程,第一个抢到account锁的先执行,直到synchronized(account)全部执行完.释放后下一个线程抢锁
	}
}
