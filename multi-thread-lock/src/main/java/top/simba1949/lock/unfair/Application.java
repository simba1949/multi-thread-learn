package top.simba1949.lock.unfair;

import top.simba1949.lock.ServiceForFairLock;

/**
 * 非公平锁测试
 *
 * @author SIMBA1949
 * @date 2019/8/10 8:33
 */
public class Application {
	public static void main(String[] args) {
		final ServiceForFairLock service = new ServiceForFairLock(false);
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
