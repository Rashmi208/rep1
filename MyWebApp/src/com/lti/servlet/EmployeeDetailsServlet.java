package com.lti.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lti.service.DatabaseEmployeeService;
import com.lti.service.DatabaseLoginService;
import com.lti.service.Employee;

@WebServlet("/employee")
public class EmployeeDetailsServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int empId = Integer.parseInt(request.getParameter("empid"));
			
		
		DatabaseEmployeeService empService = new DatabaseEmployeeService();
		Employee emp =  empService.getEmployeeDetails(empId);
		
		HttpSession session = request.getSession();
		session.setAttribute("employeeData", emp);
		
		response.sendRedirect("details.jsp");
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
	}

}
