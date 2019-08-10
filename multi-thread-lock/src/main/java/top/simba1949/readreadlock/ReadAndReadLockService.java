package top.simba1949.readreadlock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author SIMBA1949
 * @date 2019/8/10 10:17
 */
public class ReadAndReadLockService {
	private ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();

	public void read(){
		try {
			// 获取读锁
			reentrantReadWriteLock.readLock().lock();
			System.out.println("BEGIN : the thread  what get read lock name is " + Thread.currentThread().getName() + "\tnow " + System.currentTimeMillis());
			Thread.sleep(30000);
			System.out.println("END : the thread  what get read lock name is " + Thread.currentThread().getName() + "\tnow " + System.currentTimeMillis());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			// 释放读锁
			reentrantReadWriteLock.readLock().unlock();
		}
	}
}
