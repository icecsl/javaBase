package com.hbj.thread.synchronization.block;

/**
 * Created by huangbingjing on 18/1/29.
 */
public class AccountOperator implements Runnable{
	private Account account;

	public AccountOperator(Account account) {
		this.account = account;
	}

	//当一个线程访问account对象时，其他试图访问account对象的线程将会阻塞，直到该线程访问account对象结束
	@Override
	public void run() {
		synchronized (account) {
			account.deposit(500);
			account.withdraw(500);
			System.out.println(Thread.currentThread().getName() + " :" + account.getBalance());
		}
	}

	//System.out.println(Thread.currentThread().getName() + "withdraw :" + account.getBalance());
	//System.out.println(Thread.currentThread().getName() + "deposit :" + account.getBalance());


}
