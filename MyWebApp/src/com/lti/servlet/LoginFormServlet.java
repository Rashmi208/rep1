package com.lti.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lti.service.DatabaseLoginService;

@WebServlet("/login.form")
public class LoginFormServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		DatabaseLoginService loginService = new DatabaseLoginService();

		// InMemoryLoginService loginService = new InMemoryLoginService(); // wants to
		// keep data in another class for reusability
		boolean isValid = loginService.isValidUser(username, password);

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		/*
		 * without JSP
		 *  if (isValid == true) response.sendRedirect("welcome.html"); else
		 * response.sendRedirect("loginform.html");
		 */

		//USING JSP
		HttpSession session = request.getSession();
		
		if (isValid) {
			
			String fullname = loginService.getFullName(username, password);
			
			session.setAttribute("loggedInUser", fullname);
			response.sendRedirect("welcome.jsp");
			
		} else {
		
			response.sendRedirect("loginform.jsp");
			session.setAttribute("invalidUser", "Invalid username or password");
		}
		/*
		 * if (username.equals("kora") && password.equals("123"))
		 * //out.println("Welcome Back"); response.sendRedirect("welcome.html");
		 * //redirecting on welcome.html page else //
		 * out.println("Sorry, login failed"); response.sendRedirect("loginform.html");
		 * //redirecting on same page
		 */
	}

}
