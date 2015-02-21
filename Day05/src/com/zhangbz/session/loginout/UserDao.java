package com.zhangbz.session.loginout;

import java.util.HashMap;
import java.util.Map;

public class UserDao {
	private UserDao() {
	}
	private static Map<String, String> map = new HashMap<String, String> ();
	static {
		map.put("张三", "111");
		map.put("李四", "222");
	}
	
	public static boolean valiNamePsw(String username, String password) {
		return map.containsKey(username) && map.get(username).equals(password);
	}
}
