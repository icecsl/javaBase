package designMode.Factory.impl;

import designMode.Factory.Logger;

/**
 * Created by huangbingjing on 18/2/6.
 */
public class DatabaseLogger implements Logger {
	@Override
	public void writeLog() {
		System.out.println("数据库日志记录。");
	}
}
