package top.simba1949.waitandnofity;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author SIMBA1949
 * @date 2019/8/8 16:39
 */
public class ReentrantLock03 {
	private Lock lock = new ReentrantLock();
	private Condition condition = lock.newCondition();

	public void waitMethod(){
		try {
			lock.lock();
			System.out.println("wait time is " + System.currentTimeMillis());
			// 线程阻塞等待
			condition.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	public void signalMethod(){
		try {
			lock.lock();
			System.out.println("signal time is " + System.currentTimeMillis());
			// 线程通知/唤醒
			condition.signal();
		} finally {
			lock.unlock();
		}
	}
}
