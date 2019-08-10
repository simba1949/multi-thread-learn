package top.simba1949.lock.fair;

import top.simba1949.lock.ServiceForFairLock;

/**
 * 公平锁测试
 *
 * @author SIMBA1949
 * @date 2019/8/10 8:29
 */
public class Application {
	public static void main(String[] args) {
		// 创建公平锁的service
		final ServiceForFairLock service = new ServiceForFairLock(true);
		Runnable runnable = new Runnable() {
			public void run() {
				System.out.println("Runnable current thread name is " + Thread.currentThread().getName());
				service.print();
			}
		};
		for (int i = 0; i < 10; i++){
			new Thread(runnable).start();
		}

	}
}
