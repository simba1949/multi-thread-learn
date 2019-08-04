package top.simba1949;

import org.junit.Test;

/**
 * @author SIMBA1949
 * @date 2019/8/4 17:00
 */
public class ThreadSafetyTest {

	@Test
	public void test(){
		Thread t1 = new ThreadSafety();
		Thread t2 = new ThreadSafety();
		Thread t3 = new ThreadSafety();
		Thread t4 = new ThreadSafety();
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}
}
