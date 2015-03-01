package com.zhangbz.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.junit.Test;

import com.zhangbz.util.JDBCUtils;

public class JDBCDemo2 {
	
	@Test
	public void delete() {
		Connection conn = null;
		Statement stat = null;
	
		try {
			conn = JDBCUtils.getConn();
			stat = conn.createStatement();
			stat.executeUpdate("delete from user where name = 'zhaoliu'");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.close(null, stat, conn);
		}
	}
	
	@Test
	public void find() {
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
	
		try {
			conn = JDBCUtils.getConn();
			stat = conn.createStatement();
			rs = stat.executeQuery("select* from user where name = 'zhaoliu'");
			while(rs.next()) {
				String name = rs.getString("name");
				String password = rs.getString("password");
				System.out.println(name + ":" + password);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.close(rs, stat, conn);
		}
	}
	@Test
	public void update() {
		Connection conn = null;
		Statement stat = null;
	
		try {
			conn = JDBCUtils.getConn();
			stat = conn.createStatement();
			stat.executeUpdate("update user set password=999 where name = 'zhaoliu'");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.close(null, stat, conn);
		}
	}
	
	@Test
	public void add() {
		Connection conn = null;
		Statement stat = null;
	
		try {
			//1.ע�����ݿ�����
			//2.��ȡ����
			conn = JDBCUtils.getConn();
			//3.��ȡ����������
			stat = conn.createStatement();
			//4.ִ��sql���
			int count = stat.executeUpdate("insert into user values(null, 'zhaoliu', '123456', 'zhaoli@sina.com', '1999-09-09')");
			//5.������
			if (count > 0) {
				System.out.println("ִ�гɹ���Ӱ�������Ϊ" + count);
			} else {
				System.out.println("ִ��ʧ�ܣ���");
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			//6.�ر���Դ
			JDBCUtils.close(null, stat, conn);
		}
	}
}
