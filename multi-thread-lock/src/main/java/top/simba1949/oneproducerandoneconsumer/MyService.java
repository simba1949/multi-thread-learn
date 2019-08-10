package top.simba1949.oneproducerandoneconsumer;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author SIMBA1949
 * @date 2019/8/10 7:40
 */
public class MyService {
	private Lock lock = new ReentrantLock();
	private Condition condition = lock.newCondition();

	private boolean hasValue = false;

	public void set(){
		try {
			lock.lock();
			while (hasValue){
				condition.await();
			}
			System.out.println("print SET");
			hasValue = true;
			condition.signal();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	public void get(){
		try {
			lock.lock();
			while (hasValue == false){
				condition.await();
			}
			System.out.println("print GET");
			hasValue = false;
			condition.signal();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}
}
