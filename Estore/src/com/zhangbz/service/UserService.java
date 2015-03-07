package com.zhangbz.service;

import com.zhangbz.domain.User;

public interface UserService {
	/**
	 * 注册用户
	 * @param user 封装了用户数据的userbean
	 */
	void regist(User user);

}
