package thinkingInJava.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Description:
 * @author: huangbingjing
 * @date: 19/1/23
 */
public class CachedThreadPool {
	public static void main(String[] args) {
//		ExecutorService executorService = Executors.newCachedThreadPool();
//		ExecutorService executorService = Executors.newFixedThreadPool(2);
		ExecutorService executorService = Executors.newSingleThreadExecutor();
		for (int i = 0; i<5; i++){
			executorService.execute(new LightOff());
		}
		executorService.shutdown();
		System.out.println("Waiting for lightoff"); // 证明main线程已执行完毕

	}
}
