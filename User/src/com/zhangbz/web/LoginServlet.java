package com.zhangbz.web;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhangbz.domain.User;
import com.zhangbz.service.UserService;

public class LoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=urf-8");
		UserService service = new UserService();
		//1.��ȡ�ͻ����ύ���û���������
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		//2.����service�еķ�������û�������
		User user = service.isUser(username, password);
		if (user == null) {
			//3.�������ȷ����ʾ
			request.setAttribute("msg", "�û������벻��ȷ");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			return;
		} else {
			//4.��ȷ���¼�û��ض�����ҳ
			request.getSession().setAttribute("user", user);
			if ("ok".equals(request.getParameter("remname"))) {
				//����û���ѡ����ס�û�����cookie������������û���
				Cookie remNameC = new Cookie("remname", URLEncoder.encode(user.getUsername(),"utf-8"));
				remNameC.setPath(request.getContextPath());
				remNameC.setMaxAge(3600*24*30);
				response.addCookie(remNameC);
			} else {
				//����û�û�й�ѡ��ס�û�����ɾ����ס�û�����cookie
				Cookie remNameC = new Cookie("remname","");
				remNameC.setPath(request.getContextPath());
				remNameC.setMaxAge(0);
				response.addCookie(remNameC);
			}
			response.sendRedirect(request.getContextPath() + "/index.jsp");
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
