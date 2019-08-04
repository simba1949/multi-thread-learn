package top.simba1949;

/**
 * 1. 实现 Runnable 接口
 * 2. 重写 run 方法
 * @author SIMBA1949
 * @date 2019/8/4 14:27
 */
public class ImplRunnable implements Runnable {
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
