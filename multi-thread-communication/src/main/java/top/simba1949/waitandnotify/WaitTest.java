package top.simba1949.waitandnotify;

/**
 * wait 方法必须在同步方法或者同步代码块中调用
 *
 * @author SIMBA1949
 * @date 2019/8/5 22:16
 */
public class WaitTest {
	public static void main(String[] args) {
//		aSyncTest();

		WaitTest test = new WaitTest();
		test.syncTest();
	}

	public static void aSyncTest(){
		try {
			String str = new String();
			str.wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}


	public void syncTest(){
		try {
			String lock = new String();
			System.out.println("sync 上面");
			synchronized (lock){
				System.out.println("sync 第一行");
				lock.wait();
				System.out.println("wait 下面一行代码");
			}
			System.out.println("sync 下面");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
