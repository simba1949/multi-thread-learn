package top.simba1949.waitandnofity;

/**
 * @author SIMBA1949
 * @date 2019/8/8 16:43
 */
public class Application {
	public static void main(String[] args) throws InterruptedException {
		ReentrantLock03 service = new ReentrantLock03();
		new Thread03(service).start();
		Thread.sleep(3000);
		service.signalMethod();
	}
}
