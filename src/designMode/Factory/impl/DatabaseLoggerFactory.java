package designMode.Factory.impl;

import designMode.Factory.Logger;
import designMode.Factory.LoggerFactory;

/**
 * Created by huangbingjing on 18/2/6.
 */
public class DatabaseLoggerFactory implements LoggerFactory{

	@Override
	public Logger createLogger() {
		return new DatabaseLogger();
	}
}
