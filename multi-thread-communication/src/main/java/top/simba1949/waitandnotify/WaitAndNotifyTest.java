package top.simba1949.waitandnotify;

/**
 * @author SIMBA1949
 * @date 2019/8/5 22:27
 */
public class WaitAndNotifyTest {
	public static void main(String[] args) {
		try {
			Object lock = new Object();
			new WaitAndNotifyThreadOne(lock).start();
			Thread.sleep(2000);
			new WaitAndNotifyThreadTwo(lock).start();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
