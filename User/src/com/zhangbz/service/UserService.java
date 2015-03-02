package com.zhangbz.service;

import com.zhangbz.dao.MySqlUserDao;
import com.zhangbz.dao.UserDao;
import com.zhangbz.dao.XmlUserDao;
import com.zhangbz.domain.User;
import com.zhangbz.exception.MsgException;
import com.zhangbz.factory.DaoFactory;

public class UserService {
//	private XmlUserDao dao = new XmlUserDao();
//	private MySqlUserDao dao = new MySqlUserDao();
	private UserDao dao = DaoFactory.getFactory().getDao();
	/**
	 * 添加用户
	 * @param user
	 * @throws MsgException 
	 */
	public void registUser(User user) throws MsgException {
		//1.检查用户名是否已经存在，如果已经存在则提示
		if(dao.findUserByUserName(user.getUsername()) != null) {
			//为了不占用返回值，以自定义异常的形式返回信息
			throw new MsgException();
		}
		//2.如果不存在则调用dao中的方法添加用户
		dao.addUser(user);
	}
	/**
	 * 检查用户名密码是否正确
	 * @param username
	 * @param password
	 * @return
	 */
	public User isUser(String username, String password) {
		return dao.findUserByUNandPSW(username, password);
	}
}
