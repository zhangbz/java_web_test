package com.zhangbz.dao;

import java.util.List;

import com.zhangbz.domain.Cust;

public interface CustDao {
	/**
	 * 根据用户名查找用户
	 * @param name 用户名
	 * @return 找到的用户，如果找不到返回null
	 */
	Cust findUserByName(String name);

	/**
	 * 添加客户
	 * @param cust
	 */
	void addCust(Cust cust);
	/**
	 * 查询所有用户信息组成的集合
	 * @return 封装了所有客户信息的集合，如果没有任何用户，返回的集合中内容为空
	 */
	List<Cust> getAllCust();

}
