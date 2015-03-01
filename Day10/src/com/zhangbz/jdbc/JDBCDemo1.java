package com.zhangbz.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCDemo1 {

	public static void main(String[] args) {
		Connection conn = null;  //�ֲ�����û��Ĭ�ϵĳ�ʼ������ĳ�Ա��������
		Statement stat = null;
		ResultSet rs = null;

		try {
			//1.ע�����ݿ�����
			//--����mysql��Driver���ʵ�����Լ�ע����һ�Σ���������ע����һ�Σ����ǻᵼ��mysql������ע������
			//--����mysqldeDriver����ʱ�������˳���;����mysql������������һ�����л����ݿ�ʱ��Ҫ�޸Ĵ���
			//DriverManager.registerDriver(new Driver());
			//����
			//Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/day10", "root", "root");
			stat = conn.createStatement();
			rs = stat.executeQuery("select * from user");
			//5.�����������ȡ��ѯ����
			while(rs.next()){
				String name = rs.getString("name");
				System.out.println(name);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			//6.�ر���Դ//�쳣����
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					rs = null;
				}
			}
			if (rs != null) {
				try {
					stat.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					rs = null;
				}
			}
			if (rs != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					rs = null;
				}
			}
		}
	}
}
