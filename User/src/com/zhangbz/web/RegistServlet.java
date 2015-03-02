package com.zhangbz.web;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.zhangbz.domain.User;
import com.zhangbz.exception.MsgException;
import com.zhangbz.service.UserService;

public class RegistServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		try {
			UserService service = new UserService();
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8");
			//1.����У����
			String valistr = request.getParameter("valistr");
			Object valistr2 = request.getSession().getAttribute("valistr");
			if (valistr == null || valistr2 == null || !valistr.equals(valistr2)) {
				request.setAttribute("msg", "��֤�벻��ȷ��");
				request.getRequestDispatcher("/regist.jsp").forward(request, response);
				return;
			}
			//2.��װ����У������
			User user = new User();
			BeanUtils.populate(user, request.getParameterMap());	//BeanUtls��apache�İ�
			user.checkValue();
			//3.����service�еķ�������û�
			service.registUser(user);
			//4.��¼�û�
			request.getSession().setAttribute("user", user);
			//5.��ʾע��ɹ�3��ص���ҳ
			response.getWriter().write("��ϲ��ע��ɹ���3��ص���ҳ...");
			response.setHeader("refresh", "3;url="+request.getContextPath()+"/index.jsp");
		} catch (MsgException e) {
			request.setAttribute("msg", e.getMessage());
			request.getRequestDispatcher("/regist.jsp").forward(request, response);
			return;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
