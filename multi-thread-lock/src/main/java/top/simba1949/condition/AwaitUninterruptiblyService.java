package top.simba1949.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author SIMBA1949
 * @date 2019/8/10 9:07
 */
public class AwaitUninterruptiblyService {

	private Lock lock = new ReentrantLock();
	private Condition condition = lock.newCondition();

	public void awaitMethod(){
		try {
			lock.lock();
			System.out.println("condition await uninterruptilbly begin");
			condition.await();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	public void awaitUninterruptiblyMethod(){
		try {
			lock.lock();
			System.out.println("condition await uninterruptilbly begin");
			condition.awaitUninterruptibly();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	public void signal(){
		try {
			lock.lock();
			condition.signal();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}

	}
}
