package top.simba1949;

import org.junit.Test;

/**
 * @author SIMBA1949
 * @date 2019/8/4 11:24
 */
public class ExtendThreadTest {

	@Test
	public void test01(){
		StringBuilder sb = new StringBuilder();
		sb.append("Thread's ID is ");
		sb.append(Thread.currentThread().getId());
		sb.append("\t Thread's name is ");
		sb.append(Thread.currentThread().getName());

		System.out.println(sb.toString());

		for (int i = 0; i < 10; i++){
			ExtendThread et = new ExtendThread();
			et.start();
		}
	}
}
