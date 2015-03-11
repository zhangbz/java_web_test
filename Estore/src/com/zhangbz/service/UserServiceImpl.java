package com.zhangbz.service;

import java.sql.Connection;
import java.util.Properties;
import java.util.UUID;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

import org.apache.commons.dbutils.DbUtils;

import com.zhangbz.dao.UserDao;
import com.zhangbz.domain.User;
import com.zhangbz.factory.BasicFactory;
import com.zhangbz.util.DaoUtils;

public class UserServiceImpl implements UserService {
	private UserDao dao = BasicFactory.getFactory().getInstance(UserDao.class);
	Connection conn = null;
	public void regist(User user) {
		try {
			conn = DaoUtils.getConn();
			conn.setAutoCommit(false);
			// 1.У���û����Ƿ��Ѿ�����
			if (dao.findUserByName(user.getUsername(), conn) != null) {
				throw new RuntimeException("�û����Ѿ����ڣ���");
			}
			// 2.����dao�еķ�������û������ݿ�
			user.setRole("user");
			user.setState(0);
			user.setActivecode(UUID.randomUUID().toString());
			dao.addUser(user, conn);

			// 3.���ͼ����ʼ�
			Properties prop = new Properties();
			prop.setProperty("mail.transport.protocol", "smtp");
			prop.setProperty("mail.smtp.host", "localhost");
			prop.setProperty("mail.smtp.auth", "true");
			prop.setProperty("mail.debug", "true");
			Session session = Session.getInstance(prop);

			MimeMessage msg = new MimeMessage(session);

			msg.setFrom(new InternetAddress("aaa@zhangbz.com"));
			msg.setRecipient(RecipientType.TO, new InternetAddress(user.getEmail()));
			msg.setSubject(user.getUsername() + ",����estore�ļ����ʼ�");
			msg.setText(user.getUsername() + ",����������Ӽ����˻���������ܵ���븴�Ƶ��������ַ�����ʣ�http://www.estore.com/ActiveServlet?activecode=" + user.getActivecode());
			
			Transport trans = session.getTransport();
			trans.connect("aaa", "aaa");
			trans.sendMessage(msg, msg.getAllRecipients());
			
			DbUtils.commitAndCloseQuietly(conn);
		} catch (Exception e) {
			DbUtils.rollbackAndCloseQuietly(conn);
			e.printStackTrace();
			throw new RuntimeException(e);
		}

	}

}
