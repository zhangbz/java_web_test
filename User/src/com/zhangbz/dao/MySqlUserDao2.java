package com.zhangbz.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.zhangbz.domain.User;
import com.zhangbz.util.JDBCUtils;

public class MySqlUserDao2 implements UserDao{

	public void addUser(User user) {
		String sql = "insert into users values(null,?,?,?,?)";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtils.getConn();
			ps = conn.prepareStatement(sql);
			ps.setString(1,user.getUsername());
			ps.setString(2,user.getPassword());
			ps.setString(3,user.getNickname());
			ps.setString(4,user.getEmail());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			JDBCUtils.close(rs, ps, conn);
		}
	}

	public User findUserByUNandPSW(String username, String password) {
		String sql = "select * from users where username=? and password=?";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtils.getConn();
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			rs = ps.executeQuery();
			if (rs.next()) {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setNickname(rs.getString("nickname"));
				user.setEmail(rs.getString("email"));
				return user;
			} else {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			JDBCUtils.close(rs, ps, conn);
		}
	}

	public User findUserByUserName(String username) {
		String sql = "select * from users where username=?";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtils.getConn();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			if (rs.next()) {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setNickname(rs.getString("nickname"));
				user.setEmail(rs.getString("email"));
				return user;
			} else {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			JDBCUtils.close(rs, ps, conn);
		}
	}

}
