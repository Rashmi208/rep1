package com.lti.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EmpServlet
 */
@WebServlet("/emp.xls")
public class EmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/vnd.ms-excel"); // vnd is vendor. application/ is standard to indicate that it need third party application to run the program.   Server is sending response in excel sheet format
		PrintWriter out = response.getWriter();

		out.println("Empno\tName\tSalary");
		out.println("1001\tRashmi\t1000");
		out.println("1002\tKomal\t2000");
		out.println("1003\tArati\t3000");
	}

}
