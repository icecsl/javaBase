package thinkingInJava.concurrency;

/**
 * @Description:
 * @author: huangbingjing
 * @date: 19/1/23
 */
public class LightOff implements Runnable{

	private int countDown = 10;

	private static int taskCount = 0;
	private final  int id = taskCount++;


	public String status(){
		return "id = " + id +"{" + (countDown>0?countDown :"liftoff" ) +
				"}";
	}

	@Override
	public void run() {
		while (countDown-- > 0){
			System.out.println(status());
//			Thread.yield();
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
