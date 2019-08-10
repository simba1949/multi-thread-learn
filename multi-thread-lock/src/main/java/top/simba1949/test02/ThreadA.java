package top.simba1949.test02;

/**
 * @author SIMBA1949
 * @date 2019/8/8 16:08
 */
public class ThreadA extends Thread {

	private ReentrantLock02 lock02;

	public ThreadA(String name, ReentrantLock02 lock02) {
		super(name);
		this.lock02 = lock02;
	}

	@Override
	public void run() {
		super.run();
		lock02.method01();
	}
}
