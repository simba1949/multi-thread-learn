package top.simba1949.multiconditionawaitandsignal;

/**
 * @author SIMBA1949
 * @date 2019/8/8 17:16
 */
public class ThreadA extends Thread {
	private MyService service;

	public ThreadA(String name, MyService service) {
		super(name);
		this.service = service;
	}

	@Override
	public void run() {
		service.awaitA();
	}
}
