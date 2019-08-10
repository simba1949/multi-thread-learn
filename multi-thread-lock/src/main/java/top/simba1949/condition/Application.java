package top.simba1949.condition;

/**
 * @author SIMBA1949
 * @date 2019/8/10 9:09
 */
public class Application {
	public static void main(String[] args) throws InterruptedException {
		final AwaitUninterruptiblyService service = new AwaitUninterruptiblyService();

		Thread thread = new Thread(new Runnable() {
			public void run() {
//				service.awaitMethod();
				service.awaitUninterruptiblyMethod();

				service.signal();
			}
		});
		thread.start();
		Thread.sleep(3000);
		thread.interrupt();
	}
}
