package top.simba1949;

import org.junit.Test;

/**
 * @author SIMBA1949
 * @date 2019/8/4 14:29
 */
public class ImplRunnableTest {

	@Test
	public void test(){
		StringBuilder sb = new StringBuilder();
		sb.append("Thread's ID is ");
		sb.append(Thread.currentThread().getId());
		sb.append("\t Thread's name is ");
		sb.append(Thread.currentThread().getName());

		System.out.println(sb.toString());

		for (int i = 0; i < 10; i++){
			ImplRunnable ir = new ImplRunnable();
			new Thread(ir).start();
		}
	}
}
