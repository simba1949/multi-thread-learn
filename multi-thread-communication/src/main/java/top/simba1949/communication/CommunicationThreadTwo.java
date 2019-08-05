package top.simba1949.communication;

/**
 * @author SIMBA1949
 * @date 2019/8/5 21:22
 */
public class CommunicationThreadTwo extends Thread{
	private User user;

	public CommunicationThreadTwo(User user) {
		this.user = user;
	}

	@Override
	public void run() {
		super.run();
		try {
			while (true){
				if (user.size() == 5){
					System.out.println("== 5 了，线程 CommunicationThreadTwo 要退出啦！");
					throw new InterruptedException();
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
