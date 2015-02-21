package com.zhangbz.cookie;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhangbz.domain.Book;

public class BookListServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");

		// 1.��ѯ���ݿ��е����е��鲢չʾ
		Map<String, Book> map = BookDao.getBooks();
		for (Map.Entry<String, Book> entry : map.entrySet()) {
			Book book = entry.getValue();
			response.getWriter().write(
					"<a href='" + request.getContextPath()
							+ "/servlet/BookInfoServlet?id=" + book.getId()
							+ "'>" + book.getName() + "</a><br>");
		}
		response.getWriter().write("<hr>");
		
		//2.��ʾ֮ǰ��������
		Cookie[] cs = request.getCookies();
		Cookie findC = null;
		if (cs != null) {
			for(Cookie c : cs) {
				if ("last".equals(c.getName())) {
					findC = c;
				}
			}
		}
		
		if(findC == null) {
			response.getWriter().write("û�п����κ���");
		} else {
			response.getWriter().write("��������������飺<br>");
			String[] ids = findC.getValue().split(",");
			for(String id : ids) {
				Book book = BookDao.getBook(id);
				response.getWriter().write(book.getName() + "<br>");
			}
		}
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
