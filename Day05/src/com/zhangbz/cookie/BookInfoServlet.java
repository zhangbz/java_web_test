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
		//1.��ȡҪ�������ID����ѯ���ݿ��ҳ��飬��������ϸ��Ϣ
		String id = request.getParameter("id");
		Book book = BookDao.getBook(id);
		if (book == null) {
			response.getWriter().write("�Ҳ����Ȿ�飡");
		} else {
			response.getWriter().write("<h1>������" + book.getName()+ "</h1>");
			response.getWriter().write("<h3>���ߣ�" + book.getAuth()+ "</h3>");
			response.getWriter().write("<h3>�ۼۣ�" + book.getPrice()+ "</h3>");
			response.getWriter().write("<h3>�����磺" + book.getPublish()+ "</h3>");
			response.getWriter().write("<h3>������Ϣ��" + book.getDescription()+ "</h3>");
		}
		
		//2.����cookie������󿴹�����
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
			//˵��֮ǰû�п�����ļ�¼
			ids += book.getId();
		} else {
			//˵��֮ǰ�п�����ļ�¼����Ҫ������ʷ��¼�����һ���µļ�¼
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
