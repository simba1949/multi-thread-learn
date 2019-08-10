package top.simba1949.multiconditionawaitandsignal;

/**
 * @author SIMBA1949
 * @date 2019/8/8 17:17
 */
public class ThreadB extends Thread {
	private MyService service;

	public ThreadB(String name, MyService service) {
		super(name);
		this.service = service;
	}

	@Override
	public void run() {
		service.awaitB();
	}
}
