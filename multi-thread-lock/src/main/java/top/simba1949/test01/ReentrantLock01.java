package top.simba1949.test01;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author SIMBA1949
 * @date 2019/8/8 15:54
 */
public class ReentrantLock01 {
	private Lock lock = new ReentrantLock();

	public void testReentrantLock(){
		// 调用 ReentrantLock 对象中的 lock() 方法获取锁对象
		lock.lock();
		for (int i = 0; i < 5; i++){
			System.out.println("ThreadName is " + Thread.currentThread().getName() + "( " + (i + 1));
		}
		// 调用 ReentrantLock 对象中的 unlock() 方法释放锁
		lock.unlock();
	}
}
