package com.apress.j2ee;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class SimpleServlet extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse 
	response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<h1>  </h1>");
		out.println("</html>");
	
	}

}
