package com.rjgc.cjh.Logic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rjgc.cjh.dao.CustomerDao;
import com.rjgc.cjh.domain.Customer;


public class Register extends HttpServlet {

	/**
		 * Constructor of the object.
		 */
	public Register() {
		super();
	}

	/**
		 * Destruction of the servlet. <br>
		 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
		 * The doGet method of the servlet. <br>
		 *
		 * This method is called when a form has its tag value method equals to get.
		 * 
		 * @param request the request send by the client to the server
		 * @param response the response send by the server to the client
		 * @throws ServletException if an error occurred
		 * @throws IOException if an error occurred
		 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
	}

	/**
		 * The doPost method of the servlet. <br>
		 *
		 * This method is called when a form has its tag value method equals to post.
		 * 
		 * @param request the request send by the client to the server
		 * @param response the response send by the server to the client
		 * @throws ServletException if an error occurred
		 * @throws IOException if an error occurred
		 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		int ID = Integer.parseInt(request.getParameter("ID"));
		String pw=request.getParameter("password");
		String name=request.getParameter("customername");
		String repeatPWD = request.getParameter("repeatpassword");
		if (repeatPWD.equals(pw))
		{
			if (CustomerDao.CheckCustomerID(ID))
			{
				request.setAttribute("message", "ID已存在");
				request.getRequestDispatcher("Customer/RegisterConsequence.jsp").forward(request, response);
			}
			else {
				Customer customer = new Customer();
				customer.setCustomername(name);
				customer.setID(ID);
				customer.setPassword(pw);
				CustomerDao.insert(customer);
				request.setAttribute("message", "注册成功");
				
				request.getRequestDispatcher("Customer/RegisterConsequence.jsp").forward(request, response);
			}
		}
		else {
			request.setAttribute("message", "两次密码不一样");
			
			request.getRequestDispatcher("Customer/RegisterConsequence.jsp").forward(request, response);
		}
		
	}

	/**
		 * Initialization of the servlet. <br>
		 *
		 * @throws ServletException if an error occurs
		 */
	public void init() throws ServletException {
		// Put your code here
	}

}
