package thinkingInJava.concurrency;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @Description:
 * @author: huangbingjing
 * @date: 19/1/23
 */
public class TaskWithResultTest {
	public static void main(String[] args) {
		ExecutorService executorService = Executors.newCachedThreadPool();
//		ExecutorService executorService = Executors.newFixedThreadPool(2);
//		ExecutorService executorService = Executors.newSingleThreadExecutor();
		for (int i = 0; i<5; i++){
			Future<String> f = executorService.submit(new TaskWithResult(i));
			try {
				System.out.println(f.get());
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}

		}
		executorService.shutdown();
		System.out.println("Waiting for lightoff"); // 证明main线程已执行完毕

	}
}
