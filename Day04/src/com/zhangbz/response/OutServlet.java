package com.zhangbz.response;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class OutServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		response.getOutputStream().write("�й�".getBytes("utf-8"));
//		response.setHeader("Content-Type", "text/html;charset=utf-8");
		
//		response.setCharacterEncoding("utf-8");
//		response.setHeader("Content-Type", "text/html;charset=utf-8");
		
		response.setCharacterEncoding("uft-8");
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().write("�й�");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
