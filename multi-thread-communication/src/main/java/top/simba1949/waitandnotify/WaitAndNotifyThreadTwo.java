package top.simba1949.waitandnotify;

/**
 * @author SIMBA1949
 * @date 2019/8/5 22:26
 */
public class WaitAndNotifyThreadTwo extends Thread {
	private Object lock;

	public WaitAndNotifyThreadTwo(Object lock) {
		this.lock = lock;
	}

	@Override
	public void run() {

		synchronized (lock){
			System.out.println("开始 notify time = " + System.currentTimeMillis());
			lock.notify();
			System.out.println("结束 notify time = " + System.currentTimeMillis());
		}
	}
}
