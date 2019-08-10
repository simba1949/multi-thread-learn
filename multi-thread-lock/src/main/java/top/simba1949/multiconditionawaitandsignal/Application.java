package top.simba1949.multiconditionawaitandsignal;

/**
 * 使用多个 condition 实现通知部分线程
 *
 * @author SIMBA1949
 * @date 2019/8/8 17:03
 */
public class Application {
	public static void main(String[] args) throws InterruptedException {
		MyService service = new MyService();
		new ThreadA("A", service).start();
		new ThreadB("B", service).start();

		Thread.sleep(3000);
		service.signalAllA();
	}
}
