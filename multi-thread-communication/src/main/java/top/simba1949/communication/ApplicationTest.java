package top.simba1949.communication;

/**
 * @author SIMBA1949
 * @date 2019/8/5 21:28
 */
public class ApplicationTest {
	public static void main(String[] args) {
		User user = new User();
		new CommunicationThreadOne(user).start();
		new CommunicationThreadTwo(user).start();
	}
}
