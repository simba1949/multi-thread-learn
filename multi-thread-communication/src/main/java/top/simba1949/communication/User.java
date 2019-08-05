package top.simba1949.communication;

import java.util.ArrayList;
import java.util.List;

/**
 * @author SIMBA1949
 * @date 2019/8/5 21:22
 */
public class User {
	private List list = new ArrayList(10);

	public void  add(){
		list.add("李白");
	}

	public int size(){
		return list.size();
	}
}
