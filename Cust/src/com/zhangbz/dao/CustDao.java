package com.zhangbz.dao;

import java.util.List;

import com.zhangbz.domain.Cust;

public interface CustDao {
	/**
	 * �����û��������û�
	 * @param name �û���
	 * @return �ҵ����û�������Ҳ�������null
	 */
	Cust findUserByName(String name);

	/**
	 * ��ӿͻ�
	 * @param cust
	 */
	void addCust(Cust cust);
	/**
	 * ��ѯ�����û���Ϣ��ɵļ���
	 * @return ��װ�����пͻ���Ϣ�ļ��ϣ����û���κ��û������صļ���������Ϊ��
	 */
	List<Cust> getAllCust();

}
