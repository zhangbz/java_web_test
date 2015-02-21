package com.zhangbz.cookie;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieDemo1 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		
		Cookie[] cs = request.getCookies();
		Cookie findC = null;
		if(cs != null) {
			for(Cookie c : cs) {
				if("lastTime".equals(c.getName())) {
					findC = c;
				}
			}
		}
		
		if(findC == null) {
			response.getWriter().write("���ǵ�һ�η��ʱ���վ!");
		} else {
		    long lastTime = Long.parseLong(findC.getValue());
			response.getWriter().write("���ϴεķ���ʱ���ǣ�" + new Date(lastTime).toLocaleString());
		}
		
		Date date = new Date();
		Cookie c = new Cookie("lastTime", date.getTime()+"");
		c.setMaxAge(3600*24*30);
		c.setPath(request.getContextPath());
		//c.setDomain(".baidu.com");
		response.addCookie(c);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
