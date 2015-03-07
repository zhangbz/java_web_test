package com.zhangbz.service;

import java.util.UUID;

import com.zhangbz.dao.UserDao;
import com.zhangbz.domain.User;
import com.zhangbz.factory.BasicFactory;

public class UserServiceImpl implements UserService{
	private UserDao dao = BasicFactory.getFactory().getInstance(UserDao.class);
	public void regist(User user) {
		//1.校验用户名是否已经存在
		if(dao.findUserByName(user.getUsername()) != null) {
			throw new RuntimeException("用户名已经存在！！");
		}
		//2.调用dao中的方法添加用户到数据库
		user.setRole("user");
		user.setState(0);
		user.setActivecode(UUID.randomUUID().toString());
		dao.addUser(user);
	}

}
