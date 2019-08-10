package top.simba1949.waitandnofity;

/**
 * @author SIMBA1949
 * @date 2019/8/8 16:42
 */
public class Thread03 extends Thread {
	private ReentrantLock03 service;

	public Thread03(ReentrantLock03 service) {
		this.service = service;
	}

	@Override
	public void run() {
		service.waitMethod();
	}
}
