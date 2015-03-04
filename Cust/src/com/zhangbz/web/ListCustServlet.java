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
		//1.����Service�в�ѯ���пͻ��ķ��������ҵ����пͻ�
		List<Cust> list = service.getAllCust();
		//2.���鵽����Ϣ����request������ת����listCust.jspҳ�����չʾ
		request.setAttribute("list", list);
		request.getRequestDispatcher("/listCust.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
