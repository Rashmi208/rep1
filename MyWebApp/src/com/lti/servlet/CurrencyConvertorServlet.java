package com.lti.servlet;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CurrencyConvertorServlet
 */
@WebServlet("/currency.converter")
public class CurrencyConvertorServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Reading request parameters
		String from=request.getParameter("fromCurrency");
		String to=request.getParameter("toCurrency");
		double amount=Double.parseDouble(request.getParameter("amount"));
		double result=0;
		if(from.equals("USD")&&to.equals("INR"))
		result=amount*72.72;
		else if(from.equals("INR")&&to.equals("USD"))
		result=amount/72;
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		out.println("<html><body>");
		out.print("<h1>Result of conversion is" +result+"</h1>");
		out.println("</body></html>");
		
	}
}
