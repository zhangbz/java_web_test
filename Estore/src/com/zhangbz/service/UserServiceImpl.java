package com.zhangbz.service;

import java.util.UUID;

import com.zhangbz.dao.UserDao;
import com.zhangbz.domain.User;
import com.zhangbz.factory.BasicFactory;

public class UserServiceImpl implements UserService{
	private UserDao dao = BasicFactory.getFactory().getInstance(UserDao.class);
	public void regist(User user) {
		//1.У���û����Ƿ��Ѿ�����
		if(dao.findUserByName(user.getUsername()) != null) {
			throw new RuntimeException("�û����Ѿ����ڣ���");
		}
		//2.����dao�еķ�������û������ݿ�
		user.setRole("user");
		user.setState(0);
		user.setActivecode(UUID.randomUUID().toString());
		dao.addUser(user);
	}

}
