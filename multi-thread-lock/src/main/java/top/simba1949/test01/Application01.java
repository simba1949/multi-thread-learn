package top.simba1949.test01;

/**
 * @author SIMBA1949
 * @date 2019/8/8 16:01
 */
public class Application01 {
	public static void main(String[] args) {
		ReentrantLock01 lock = new ReentrantLock01();

		new MyThread01(lock).start();
		new MyThread01(lock).start();
		new MyThread01(lock).start();
		new MyThread01(lock).start();
		new MyThread01(lock).start();
	}
}
