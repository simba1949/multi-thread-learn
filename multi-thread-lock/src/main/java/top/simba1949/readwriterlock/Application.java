package top.simba1949.readwriterlock;

/**
 * @author SIMBA1949
 * @date 2019/8/10 10:31
 */
public class Application {
	public static void main(String[] args) {
		final ReadAndWriteLockService service = new ReadAndWriteLockService();
		for (int i = 0; i < 10; i++){
			if(i % 2 == 0){
				new Thread(new Runnable() {
					public void run() {
						service.read();
					}
				}).start();
			}else {
				new Thread(new Runnable() {
					public void run() {
						service.write();
					}
				}).start();
			}
		}
	}
}
