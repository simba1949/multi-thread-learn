package top.simba1949.readreadlock;

/**
 * @author SIMBA1949
 * @date 2019/8/10 10:20
 */
public class Application {
	public static void main(String[] args) {
		final ReadAndReadLockService service = new ReadAndReadLockService();

		for (int i = 0; i < 10; i++){
			new Thread(new Runnable() {
				public void run() {
					service.read();
				}
			}).start();
		}
	}
}
