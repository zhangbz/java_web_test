package com.zhangbz.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhangbz.domain.Cust;
import com.zhangbz.factory.BasicFactory;
import com.zhangbz.service.CustService;

public class ListCustServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CustService service = BasicFactory.getFactory().getInstance(CustService.class);
		//1.调用Service中查询所有客户的方法，查找到所有客户
		List<Cust> list = service.getAllCust();
		//2.将查到的信息存入request域，请求转发到listCust.jsp页面进行展示
		request.setAttribute("list", list);
		request.getRequestDispatcher("/listCust.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
