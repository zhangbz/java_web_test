package com.zhangbz.service;

import java.util.List;

import com.zhangbz.domain.Cust;

public interface CustService {
	/**
	 * ��ӿͻ�
	 * @param cust ��װ���û���Ϣ��bean
	 */
	void addCust(Cust cust);
	/**
	 * ��ѯ���пͻ�����Ϣ
	 * @return
	 */
	List<Cust> getAllCust();

}
