package com.zhangbz.service;

import java.util.List;

import com.zhangbz.domain.Cust;

public interface CustService {
	/**
	 * 添加客户
	 * @param cust 封装了用户信息的bean
	 */
	void addCust(Cust cust);
	/**
	 * 查询所有客户的信息
	 * @return
	 */
	List<Cust> getAllCust();

}
