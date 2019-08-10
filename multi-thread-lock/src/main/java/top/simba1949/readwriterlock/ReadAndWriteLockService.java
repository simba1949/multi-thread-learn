package top.simba1949.readwriterlock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author SIMBA1949
 * @date 2019/8/10 10:27
 */
public class ReadAndWriteLockService {
	private ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();

	public void read(){
		try {
			reentrantReadWriteLock.readLock().lock();
			System.out.println("READ : the current thread name is " + Thread.currentThread().getName());
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			reentrantReadWriteLock.readLock().unlock();
		}
	}

	public void write(){
		try {
			reentrantReadWriteLock.writeLock().lock();
			System.out.println("WRITE : the current thread name is " + Thread.currentThread().getName());
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			reentrantReadWriteLock.writeLock().unlock();
		}
	}
}
