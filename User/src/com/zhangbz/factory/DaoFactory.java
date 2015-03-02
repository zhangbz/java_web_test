package com.zhangbz.factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.zhangbz.dao.UserDao;

public class DaoFactory {
	private static DaoFactory factory = new DaoFactory(); 
	private static Properties prop;
	static {
		try {
			prop = new Properties();
			prop.load(new FileInputStream(DaoFactory.class.getClassLoader().getResource("config.properties").getPath()));
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	private DaoFactory() {
	}
	public static DaoFactory getFactory() {
		return factory;
	}
	public UserDao getDao() {
		try {
			String clazz = prop.getProperty("UserDao");
			return (UserDao) Class.forName(clazz).newInstance();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
	}
}
