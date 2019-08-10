package top.simba1949.oneproducerandoneconsumer;

/**
 * 生产者/消费者模型，一对一交换打印
 *
 * @author SIMBA1949
 * @date 2019/8/10 7:59
 */
public class Application {
	public static void main(String[] args) {
		MyService service = new MyService();
		new ThreadA(service).start();
		new ThreadB(service).start();
	}
}
