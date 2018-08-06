package designMode.Factory;

import designMode.Factory.impl.DatabaseLoggerFactory;

/**
 * 工厂模式
 * Created by huangbingjing on 18/2/6.
 */
public class FactoryTest {
	public static void main(String[] args) {

		LoggerFactory factory = new DatabaseLoggerFactory(); //可引入配置文件实现
//		LoggerFactory factory = new FileLoggerFactory();
		Logger logger = factory.createLogger();
		logger.writeLog();
	}
}
