package designMode.Factory.impl;

import designMode.Factory.Logger;

/**
 * Created by huangbingjing on 18/2/6.
 */
public class FileLogger implements Logger {
	@Override
	public void writeLog() {
		System.out.println("文件日志记录。");
	}
}
