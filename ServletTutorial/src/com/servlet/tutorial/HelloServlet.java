package com.servlet.tutorial;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public HelloServlet() {
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//Luồng Đầu ra (Output Stream)
		//Gửi dữ liệu về trình duyệt của User
		ServletOutputStream out = resp.getOutputStream();
		
			out.println("<html>");
			out.println("<head><title>Hello Servlet</title></head>");
			out.println("<body>");
			out.println("<h3>Hello World</h3>");
			out.println("This is my first Servlet");
			out.println("</body>");
			out.println("<html>");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
}
