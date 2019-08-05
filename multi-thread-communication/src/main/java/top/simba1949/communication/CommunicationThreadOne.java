package top.simba1949.communication;

/**
 * @author SIMBA1949
 * @date 2019/8/5 21:22
 */
public class CommunicationThreadOne extends Thread{
	private User user;

	public CommunicationThreadOne(User user) {
		this.user = user;
	}

	@Override
	public void run() {
		super.run();
		try {
			for (int i = 0; i < 10; i++){
				user.add();
				System.out.println("添加了 " + (i + 1) + " 个元素");
				Thread.sleep(1000);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
