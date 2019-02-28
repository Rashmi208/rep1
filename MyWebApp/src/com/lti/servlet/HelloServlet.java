package com.lti.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloServlet
 */

@WebServlet("/HelloServlet.exe") // write this in url to run the servlet and this url can be changed eg.
									// hello.php , hello.exe
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html"); //MIME if we dont write this line browser will diplay the html plain text
		PrintWriter out = response.getWriter();

		out.println("<html><body>");
		out.println("<h1>Hello from Servlet</h1>");
		out.println("</body></html>");
	}

}
