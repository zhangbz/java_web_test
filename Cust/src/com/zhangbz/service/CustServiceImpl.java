package com.zhangbz.service;

import java.util.List;

import com.zhangbz.dao.CustDao;
import com.zhangbz.domain.Cust;
import com.zhangbz.factory.BasicFactory;

public class CustServiceImpl implements CustService {
	CustDao dao = BasicFactory.getFactory().getInstance(CustDao.class);

	public void addCust(Cust cust) {
		//1.检查用户名是否已经存在
		if (dao.findUserByName(cust.getName())!=null) {
				throw new RuntimeException("用户名已经存在！！");
		}
		//2.调用dao中的方法增加用户
		dao.addCust(cust);
	}

	public List<Cust> getAllCust() {
		return dao.getAllCust();
	}

	
}
