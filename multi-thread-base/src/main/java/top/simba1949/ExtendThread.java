package top.simba1949;

/**
 * 1. 继承 Thread 类
 * 2. 重写 run 方法
 *
 * @author SIMBA1949
 * @date 2019/8/4 11:23
 */
public class ExtendThread extends Thread {

	@Override
	public void run() {
		StringBuilder sb = new StringBuilder();
		sb.append("Thread's ID is ");
		sb.append(Thread.currentThread().getId());
		sb.append("\t Thread's name is ");
		sb.append(Thread.currentThread().getName());

		System.out.println(sb.toString());
	}
}
