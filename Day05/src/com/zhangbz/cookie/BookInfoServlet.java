package com.zhangbz.cookie;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhangbz.domain.Book;

public class BookInfoServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		//1.获取要看的书的ID，查询数据库找出书，输出书的详细信息
		String id = request.getParameter("id");
		Book book = BookDao.getBook(id);
		if (book == null) {
			response.getWriter().write("找不到这本书！");
		} else {
			response.getWriter().write("<h1>书名：" + book.getName()+ "</h1>");
			response.getWriter().write("<h3>作者：" + book.getAuth()+ "</h3>");
			response.getWriter().write("<h3>售价：" + book.getPrice()+ "</h3>");
			response.getWriter().write("<h3>出版社：" + book.getPublish()+ "</h3>");
			response.getWriter().write("<h3>描述信息：" + book.getDescription()+ "</h3>");
		}
		
		//2.发送cookie保存最后看过的书
		String ids = "";
		
		Cookie[] cs = request.getCookies();
		Cookie findC = null;
		if (cs != null) {
			for(Cookie c : cs){
				if("last".equals(c.getName())) {
					findC = c;
				}
			}
		}
		
		if (findC == null) {
			//说明之前没有看过书的记录
			ids += book.getId();
		} else {
			//说明之前有看过书的记录，需要根据历史记录计算出一个新的记录
			String [] olds = findC.getValue().split(",");
			StringBuffer buffer = new StringBuffer();
			buffer.append(book.getId() + ",");
			for(int i = 0; i < olds.length && buffer.toString().split(",").length < 3; i++) {
				String old = olds[i];
				if(!old.equals(book.getId())) {
					buffer.append(old + ",");
				}
			}
			//System.out.println(buffer.length());
			ids = buffer.substring(0,buffer.length()-1);
			//ids = buffer.toString();
			//System.out.println(ids);
		}
		
		Cookie lastC = new Cookie("last", ids);
		lastC.setMaxAge(3600*24*30);
		lastC.setPath(request.getContextPath());
		response.addCookie(lastC);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
