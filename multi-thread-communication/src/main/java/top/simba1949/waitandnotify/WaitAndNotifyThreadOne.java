package top.simba1949.waitandnotify;

/**
 * @author SIMBA1949
 * @date 2019/8/5 22:24
 */
public class WaitAndNotifyThreadOne extends Thread {
	private Object lock;

	public WaitAndNotifyThreadOne(Object lock) {
		this.lock = lock;
	}

	@Override
	public void run() {
		try {
			synchronized (lock){
				System.out.println("开始 wait time = " + System.currentTimeMillis());
				lock.wait();
				System.out.println("结束 wait time = " + System.currentTimeMillis());
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
