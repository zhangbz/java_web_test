package com.zhangbz.dao;

import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import com.zhangbz.domain.User;
import com.zhangbz.util.XmlDaoUtils;

public class XmlUserDao implements UserDao{

 	public User findUserByUserName(String username) {
 		Document dom = XmlDaoUtils.getDom();
 		Element root = dom.getRootElement();
 		//��xml�в��Ҿ���username����ֵ���ڴ�����û�����Ԫ��
 		List<Element> list = root.selectNodes("//user[@username='"+username+"']");
 		if (list.size() > 0) {//����0˵���ҵ�������û�
 			Element userEle = list.get(0);
 			//���ҵ����û�����Ϣ��װ��bean������
 			User user = new User();
 			user.setUsername(userEle.attributeValue("username"));
 			user.setPassword(userEle.attributeValue("password"));
 			user.setNickname(userEle.attributeValue("nickname"));
 			user.setEmail(userEle.attributeValue("email"));
 			return user;
 		} else {//˵��û���ҵ�����û�
 	 		return null;
 		}
 	}

 	public void addUser(User user) {
 		Document dom = XmlDaoUtils.getDom();
 		Element root = dom.getRootElement();
 		//ƾ�մ�����һ��userԪ�أ����ݴ����user����Ϣ�����ô�Ԫ�ص�����
 		Element userEle = DocumentHelper.createElement("user");
 		userEle.setAttributeValue("username", user.getUsername());
 		userEle.setAttributeValue("password", user.getPassword());
 		userEle.setAttributeValue("nickname", user.getNickname());
 		userEle.setAttributeValue("email", user.getEmail());
 		//���ص�usersԪ����
 		root.add(userEle);
 		//��д��xml�ļ���
 		XmlDaoUtils.refXml();
 	}

 	public User findUserByUNandPSW(String username, String password) {
 		Document dom = XmlDaoUtils.getDom();
 		Element root = dom.getRootElement();
 		//��xml�в��Ҿ���username����ֵ���ڴ�����û�������password���ڴ���������Ԫ��
 		List<Element> list = root.selectNodes("//user[@username='"+username+"' and @password='" +password+"']");
 		if (list.size() > 0) {//����0˵���ҵ�������û�
 			Element userEle = list.get(0);
 			//���ҵ����û�����Ϣ��װ��bean������
 			User user = new User();
 			user.setUsername(userEle.attributeValue("username"));
 			user.setPassword(userEle.attributeValue("password"));
 			user.setNickname(userEle.attributeValue("nickname"));
 			user.setEmail(userEle.attributeValue("email"));
 			return user;
 		} else {//˵��û���ҵ�����û�
 	 		return null;
 		}
 	}
}