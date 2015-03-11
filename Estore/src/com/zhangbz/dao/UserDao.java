package com.zhangbz.dao;

import java.sql.Connection;

import com.zhangbz.domain.User;

public interface UserDao {
	/**
	 * �����û��������û�
	 * @param username �û���
	 * @param conn 
	 * @return ���ҵ����û�������Ҳ�������null
	 */
	User findUserByName(String username, Connection conn);
	/**
	 * ����û�
	 * @param user ��װ���û���Ϣ��bean
	 * @param conn 
	 */
	void addUser(User user, Connection conn);

}
