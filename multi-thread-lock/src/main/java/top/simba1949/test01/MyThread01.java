package top.simba1949.test01;

/**
 * @author SIMBA1949
 * @date 2019/8/8 15:59
 */
public class MyThread01 extends Thread {

	private ReentrantLock01 lock01;


	public MyThread01(ReentrantLock01 lock01) {
		this.lock01 = lock01;
	}

	@Override
	public void run() {
		lock01.testReentrantLock();
	}
}
