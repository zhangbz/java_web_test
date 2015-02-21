package com.zhangbz.cookie;

import java.util.LinkedHashMap;
import java.util.Map;

import com.zhangbz.domain.Book;

public class BookDao {
	private static Map<String, Book> bookMap = new LinkedHashMap<String,Book>();
	private BookDao(){
	}
	
	static {
		bookMap.put("1", new Book("1", "����1", "�۸�1", "����1", "������1", "������Ϣ1"));
		bookMap.put("2", new Book("2", "����2", "�۸�2", "����2", "������2", "������Ϣ2"));
		bookMap.put("3", new Book("3", "����3", "�۸�3", "����3", "������3", "������Ϣ3"));
		bookMap.put("4", new Book("4", "����4", "�۸�4", "����4", "������4", "������Ϣ4"));
	}
	
	public static Map<String, Book> getBooks() {
		return bookMap;
	}
	
	public static Book getBook(String id) {
		return bookMap.get(id);
	}
}
