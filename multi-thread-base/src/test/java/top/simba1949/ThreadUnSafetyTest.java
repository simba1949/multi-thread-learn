package top.simba1949;

import org.junit.Test;

/**
 * @author SIMBA1949
 * @date 2019/8/4 17:00
 */
public class ThreadUnSafetyTest {

	@Test
	public void test(){
		Thread unSafety = new ThreadUnSafety();

		new Thread(unSafety).start();
		new Thread(unSafety).start();
		new Thread(unSafety).start();
		new Thread(unSafety).start();
	}
}
