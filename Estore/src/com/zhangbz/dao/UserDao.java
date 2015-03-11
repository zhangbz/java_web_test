package com.zhangbz.dao;

import java.sql.Connection;

import com.zhangbz.domain.User;

public interface UserDao {
	/**
	 * 根据用户名查找用户
	 * @param username 用户名
	 * @param conn 
	 * @return 查找到的用户，如果找不到返回null
	 */
	User findUserByName(String username, Connection conn);
	/**
	 * 添加用户
	 * @param user 封装了用户信息的bean
	 * @param conn 
	 */
	void addUser(User user, Connection conn);

}
