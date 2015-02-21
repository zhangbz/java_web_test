package com.zhangbz.session.loginout;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;chatset=utf-8");
		
		//1.获取用户名密码
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		//2.查询数据库检查用户名密码
		if(UserDao.valiNamePsw(username, password)) {
			//3.如果正确登录后重定向到主页
			request.getSession().setAttribute("user", username);
			response.sendRedirect(request.getContextPath()+"/loginout/index.jsp");
			return;
		} else {
			//如果错误则提示
			response.getWriter().write("用户名密码不正确！");
		}
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}



}
