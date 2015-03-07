package com.zhangbz.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.zhangbz.domain.User;
import com.zhangbz.util.DaoUtils;

public class UserDaoImpl implements UserDao {

	public void addUser(User user) {
		String sql = "insert into users values(null,?, ?, ?, ?, ?, ?, ?, null)";
		try {
			QueryRunner runner = new QueryRunner(DaoUtils.getSource());
			runner.update(sql,user.getUsername(),user.getPassword(),user.getNickname(),user.getEmail(), user.getRole(), user.getState(), user.getActivecode());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
	}

	public User findUserByName(String username) {
		String sql = "select * from users where username = ?";
		try {
			QueryRunner runner = new QueryRunner(DaoUtils.getSource());
			runner.query(sql, new BeanHandler<User>(User.class),username);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return null;
	}

}
