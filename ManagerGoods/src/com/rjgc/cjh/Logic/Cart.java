package com.rjgc.cjh.Logic;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rjgc.cjh.dao.GoodsDao;
import com.rjgc.cjh.dao.OrderDao;
import com.rjgc.cjh.domain.CartInfo;
import com.sun.xml.xsom.impl.scd.Iterators.Map;

public class Cart extends HttpServlet {

	/**
		 * Constructor of the object.
		 */
	public Cart() {
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
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the GET method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
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
		ArrayList<CartInfo> list = new ArrayList<CartInfo>();
		ArrayList<CartInfo> success = new ArrayList<CartInfo>();
		HttpSession session = request.getSession();
		String[] check = request.getParameterValues("shop");
		HashMap<CartInfo, Integer> cart  = (HashMap<CartInfo, Integer>)session.getAttribute("cartInfo");
		Random random = new Random();
		int max = 999999999;
		int min = 111111111;
		
		for (String id : check) {
			int goodsID = Integer.parseInt(id);
			int num = Integer.parseInt(request.getParameter(id));
			if (num <= GoodsDao.BackGoodsNumWithID(goodsID) && num > 0)
			{
				String name = GoodsDao.BackGoodsNameWithID(goodsID);
				CartInfo cartInfo = new CartInfo();
				cartInfo.setCustomerID(Integer.parseInt(session.getAttribute("CustomerID").toString()));
				cartInfo.setGoodsname(name);
				cartInfo.setGoodsID(goodsID);
				cartInfo.setPieces(num);
				int i = random.nextInt(max)%(max-min) + min;
				cartInfo.setOrderID(i);
				Iterator<Entry<CartInfo, Integer>> it = cart.entrySet().iterator(); 
				while (it.hasNext()) {
					Entry<CartInfo, Integer> entry=it.next();
					CartInfo key=entry.getKey();
					if (key.getGoodsID() == goodsID)
					{
						System.out.print(key.getGoodsID());
						it.remove();
						list.add(cartInfo);
					}
					//delete appointed goods in session map
				}
			}
			
		}
		session.setAttribute("cartInfo", cart);
		for (CartInfo cartInfo : list) {
			if (OrderDao.insert(cartInfo))
			{
				success.add(cartInfo);
			}
		}
			request.setAttribute("success", success);
			request.getRequestDispatcher("Customer/CartResult.jsp").forward(request, response);
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
