package com.zhangbz.dao;

import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.zhangbz.domain.Cust;
import com.zhangbz.util.DaoUtils;

public class CustDaoImpl implements CustDao {

	public void addCust(Cust cust) {
		String sql = "insert into customer values(null,?,?,?,?,?,?,?,?)";
		try {
			QueryRunner runner = new QueryRunner(DaoUtils.getSource());
			runner.update(sql, cust.getName(), cust.getGender(), cust.getBirthday(), cust.getCellphone(), cust.getEmail(), cust.getPreference(), cust.getType(), cust.getDescription());
		} catch(Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	public Cust findUserByName(String name) {
		String sql = "select * from customer where name = ?";
		try {
			QueryRunner runner = new QueryRunner(DaoUtils.getSource());
			return runner.query(sql, new BeanHandler<Cust>(Cust.class), name);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		} 
	}

	public List<Cust> getAllCust() {
		String sql = "select * from customer";
		try {
			QueryRunner runner = new QueryRunner(DaoUtils.getSource());
			runner.query(sql, new BeanListHandler<Cust>(Cust.class));
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		return null;
	}

}
