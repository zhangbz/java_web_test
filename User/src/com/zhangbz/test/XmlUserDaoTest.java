package com.zhangbz.test;

import org.junit.Test;

import com.zhangbz.dao.XmlUserDao;
import com.zhangbz.domain.User;

public class XmlUserDaoTest {
	@Test
	public void testFindUserByUserName() {
		XmlUserDao dao = new XmlUserDao();
		User user = dao.findUserByUserName("admin");
		System.out.println(user);
	}
	
	@Test
	public void testFindUserByUNandPSW() {
		XmlUserDao dao = new XmlUserDao();
		User user = dao.findUserByUNandPSW("admin", "admin");
		System.out.println(user);
	}
	
	@Test
	public void testAddUser() {
		XmlUserDao dao = new XmlUserDao();
		User user = new User();
		user.setUsername("±¦ÖÇ");
		user.setPassword("111");
		user.setNickname("zhangbz");
		user.setEmail("zhangbz@qq.com");
		dao.addUser(user);
	}
}
