package top.simba1949;

/**
 * @author SIMBA1949
 * @date 2019/8/4 16:59
 */
public class ThreadSafety extends Thread{
	private int count = 5;

	@Override
	public void run() {
		super.run();
		while (count > 0){
			System.out.println("线程名称：" + Thread.currentThread().getName() + "；count 值为：" + count);
			count--;
		}
	}
}
