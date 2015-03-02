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
	 * ����û�
	 * @param user
	 * @throws MsgException 
	 */
	public void registUser(User user) throws MsgException {
		//1.����û����Ƿ��Ѿ����ڣ�����Ѿ���������ʾ
		if(dao.findUserByUserName(user.getUsername()) != null) {
			//Ϊ�˲�ռ�÷���ֵ�����Զ����쳣����ʽ������Ϣ
			throw new MsgException();
		}
		//2.��������������dao�еķ�������û�
		dao.addUser(user);
	}
	/**
	 * ����û��������Ƿ���ȷ
	 * @param username
	 * @param password
	 * @return
	 */
	public User isUser(String username, String password) {
		return dao.findUserByUNandPSW(username, password);
	}
}
