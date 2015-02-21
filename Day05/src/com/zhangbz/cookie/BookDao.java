package com.zhangbz.cookie;

import java.util.LinkedHashMap;
import java.util.Map;

import com.zhangbz.domain.Book;

public class BookDao {
	private static Map<String, Book> bookMap = new LinkedHashMap<String,Book>();
	private BookDao(){
	}
	
	static {
		bookMap.put("1", new Book("1", "书名1", "价格1", "作者1", "出版社1", "描述信息1"));
		bookMap.put("2", new Book("2", "书名2", "价格2", "作者2", "出版社2", "描述信息2"));
		bookMap.put("3", new Book("3", "书名3", "价格3", "作者3", "出版社3", "描述信息3"));
		bookMap.put("4", new Book("4", "书名4", "价格4", "作者4", "出版社4", "描述信息4"));
	}
	
	public static Map<String, Book> getBooks() {
		return bookMap;
	}
	
	public static Book getBook(String id) {
		return bookMap.get(id);
	}
}
