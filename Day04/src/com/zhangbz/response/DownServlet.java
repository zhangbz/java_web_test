package com.zhangbz.response;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DownServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setHeader("Content-Disposition", "attachment;filename="+URLEncoder.encode("��.jpg", "utf-8"));
		
		InputStream in = new FileInputStream(this.getServletContext().getRealPath("ln.jpg"));
		OutputStream out = response.getOutputStream();
		
		byte[] bs = new byte[1024];
		int i = 0;
		while((i = in.read(bs)) != -1){
			out.write(bs, 0, i);
		}
		
		in.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
