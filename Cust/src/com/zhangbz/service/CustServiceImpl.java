package com.zhangbz.service;

import java.util.List;

import com.zhangbz.dao.CustDao;
import com.zhangbz.domain.Cust;
import com.zhangbz.factory.BasicFactory;

public class CustServiceImpl implements CustService {
	CustDao dao = BasicFactory.getFactory().getInstance(CustDao.class);

	public void addCust(Cust cust) {
		//1.����û����Ƿ��Ѿ�����
		if (dao.findUserByName(cust.getName())!=null) {
				throw new RuntimeException("�û����Ѿ����ڣ���");
		}
		//2.����dao�еķ��������û�
		dao.addCust(cust);
	}

	public List<Cust> getAllCust() {
		return dao.getAllCust();
	}

	
}
