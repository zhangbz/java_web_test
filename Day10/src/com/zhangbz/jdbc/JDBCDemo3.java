package com.zhangbz.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.zhangbz.util.JDBCUtils;

public class JDBCDemo3 {
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtils.getConn();
			ps = conn.prepareStatement("select * from users where username=? and password=?");
			ps.setString(1, "admin");
			ps.setString(2, "admin");
			
			rs = ps.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getString("email"));
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.close(rs, ps, conn);
		}
	}
}
