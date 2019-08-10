package top.simba1949.multiconditionawaitandsignal;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author SIMBA1949
 * @date 2019/8/8 17:05
 */
public class MyService {
	private Lock lock = new ReentrantLock();
	private Condition conditionA = lock.newCondition();
	private Condition conditionB = lock.newCondition();

	public void awaitA(){
		try {
			lock.lock();
			System.out.println("await A begin time is " + System.currentTimeMillis());
			conditionA.await();
			System.out.println("await A end time is " + System.currentTimeMillis());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	public void awaitB(){
		try {
			lock.lock();
			System.out.println("await B begin time is " + System.currentTimeMillis());
			conditionB.await();
			System.out.println("await B end time is " + System.currentTimeMillis());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	public void signalAllA(){
		try {
			lock.lock();
			System.out.println("signalAll A time is " + System.currentTimeMillis() + "ThreadName is " + Thread.currentThread().getName());
			conditionA.signalAll();
		} finally {
			lock.unlock();
		}
	}

	public void signalAllB(){
		try {
			lock.lock();
			System.out.println("signalAll B time is " + System.currentTimeMillis() + "ThreadName is " + Thread.currentThread().getName());
			conditionB.signalAll();
		} finally {
			lock.unlock();
		}
	}
}
