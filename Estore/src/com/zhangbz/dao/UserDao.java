package com.zhangbz.dao;

import com.zhangbz.domain.User;

public interface UserDao {
	/**
	 * 根据用户名查找用户
	 * @param username 用户名
	 * @return 查找到的用户，如果找不到返回null
	 */
	User findUserByName(String username);
	/**
	 * 添加用户
	 * @param user 封装了用户信息的bean
	 */
	void addUser(User user);

}
