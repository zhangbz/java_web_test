package com.zhangbz.dao;

import com.zhangbz.domain.User;

public interface UserDao {
	/**
	 * �����û��������û�
	 * @param username �û���
	 * @return ���ҵ����û�������Ҳ�������null
	 */
	User findUserByName(String username);
	/**
	 * ����û�
	 * @param user ��װ���û���Ϣ��bean
	 */
	void addUser(User user);

}
