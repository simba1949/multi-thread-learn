package top.simba1949.oneproducerandoneconsumer;

/**
 * @author SIMBA1949
 * @date 2019/8/10 8:08
 */
public class ThreadA extends Thread {
	private MyService myService;

	public ThreadA(MyService myService) {
		this.myService = myService;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10 ; i++){
			myService.set();
		}
	}
}
