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
		
		//1.��ȡ�û�������
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		//2.��ѯ���ݿ����û�������
		if(UserDao.valiNamePsw(username, password)) {
			//3.�����ȷ��¼���ض�����ҳ
			request.getSession().setAttribute("user", username);
			response.sendRedirect(request.getContextPath()+"/loginout/index.jsp");
			return;
		} else {
			//�����������ʾ
			response.getWriter().write("�û������벻��ȷ��");
		}
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}



}
