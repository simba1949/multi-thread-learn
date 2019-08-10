package top.simba1949.test02;

/**
 * @author SIMBA1949
 * @date 2019/8/8 16:11
 */
public class Application {
	public static void main(String[] args) throws InterruptedException {
		ReentrantLock02 lock02 = new ReentrantLock02();
		new ThreadA("A", lock02).start();
		new ThreadAA("AA" ,lock02).start();
		Thread.sleep(1000);
		new ThreadB("B", lock02).start();
		new ThreadBB("BB", lock02).start();
	}
}
