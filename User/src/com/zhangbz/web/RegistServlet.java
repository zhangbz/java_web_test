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
			//1.检验校验码
			String valistr = request.getParameter("valistr");
			Object valistr2 = request.getSession().getAttribute("valistr");
			if (valistr == null || valistr2 == null || !valistr.equals(valistr2)) {
				request.setAttribute("msg", "验证码不正确！");
				request.getRequestDispatcher("/regist.jsp").forward(request, response);
				return;
			}
			//2.封装数据校验数据
			User user = new User();
			BeanUtils.populate(user, request.getParameterMap());	//BeanUtls用apache的包
			user.checkValue();
			//3.调用service中的方法添加用户
			service.registUser(user);
			//4.登录用户
			request.getSession().setAttribute("user", user);
			//5.提示注册成功3秒回到主页
			response.getWriter().write("恭喜您注册成功！3秒回到主页...");
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
