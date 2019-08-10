package top.simba1949.test02;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author SIMBA1949
 * @date 2019/8/8 16:03
 */
public class ReentrantLock02 {

	private Lock lock = new ReentrantLock();

	public void method01(){
		try {
			lock.lock();

			System.out.println("Method01 ThreadName is " + Thread.currentThread().getName() + "; Time is " + System.currentTimeMillis());
			Thread.sleep(5000);
			System.out.println("Method01 ThreadName is " + Thread.currentThread().getName() + "; Time is " + System.currentTimeMillis());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	public void method02(){
		try {
			lock.lock();

			System.out.println("Method02 ThreadName is " + Thread.currentThread().getName() + "; Time is " + System.currentTimeMillis());
			Thread.sleep(5000);
			System.out.println("Method02 ThreadName is " + Thread.currentThread().getName() + "; Time is " + System.currentTimeMillis());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}

	}
}
