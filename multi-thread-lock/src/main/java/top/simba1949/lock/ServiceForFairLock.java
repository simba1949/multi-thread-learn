package top.simba1949.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author SIMBA1949
 * @date 2019/8/10 8:24
 */
public class ServiceForFairLock {
	private Lock lock;

	public ServiceForFairLock(boolean ifFair) {
		lock = new ReentrantLock(ifFair);
	}

	public void print(){
		lock.lock();
		Thread currentThread = Thread.currentThread();
		System.out.println("current thread name is " + currentThread.getName() + ", this get lock");
		lock.unlock();
	}
}
