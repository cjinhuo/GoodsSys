package com.rjgc.cjh.Logic;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;

import javax.mail.Session;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rjgc.cjh.dao.GoodsDao;
import com.rjgc.cjh.domain.CartInfo;
import com.rjgc.cjh.domain.Customer;
import com.rjgc.cjh.domain.Goods;
import java.util.Map;
import java.util.Map.Entry;

public class Shopping extends HttpServlet {

	/**
		 * Constructor of the object.
		 */
	public Shopping() {
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
//		response.setContentType("text/html");
//		request.setCharacterEncoding("UTF-8");
//		String argu = "";
//		
//		if (request.getParameter("searchContent") != null && !request.getParameter("searchContent").equals(" "))
//		{
//			argu = request.getParameter("searchContent");
//		}
//		String sql = "select * from userInfo.goodsInfo where (id like '%"
//					+ argu + "%'  or name like '%"
//					+ argu + "%' or type like '%"
//					+ argu + "%' or stock like '%"
//					+ argu + "%' or manufacturer like '%"
//					+ argu + "%' or supplier like '%"
//					+ argu + "%' or managername like '%"
//					+ argu + "%')";
//
// 		if (request.getParameter("screeningStock") != null && !request.getParameter("screeningStock").equals("null"))
//		{
//			sql = sql + " and stock <" + Integer.parseInt(request.getParameter("screeningStock"));
//		} 
//		if (request.getParameter("screeningType") != null &&  !request.getParameter("screeningType").equals("null"))
//		{
//			sql = sql + " and type='" + request.getParameter("screeningType") + "'";
//		}
//		if (request.getParameter("screeningManufacturer") != null && !request.getParameter("screeningManufacturer").equals("null"))
//		{
//			sql = sql + " and supplier='" + request.getParameter("screeningManufacturer") + "'";
//		}
//		if (request.getParameter("screeningSort") != null && !request.getParameter("screeningSort").equals("null")
//			&& request.getParameter("screeningSortType") != null && !request.getParameter("screeningSortType").equals("null"))
//		{
//			if (Integer.parseInt(request.getParameter("screeningSort")) == 1)
//			{
//				sql = sql + "order by " + request.getParameter("screeningSortType") + " asc";
//			}
//			else
//			{
//				sql = sql + "order by " + request.getParameter("screeningSortType") + " desc";
//			}
//		}
//        ArrayList<Goods> allGoods = GoodsDao.stringSqlQuery(sql);
//        if (allGoods != null)
//        {
//        	request.setAttribute("allGoods", allGoods);
//        }
//        PrintWriter out = response.getWriter();
//		out.println("1");
//        request.getRequestDispatcher("Customer/Shopping.jsp").forward(request, response);
//		
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
//		HttpSession session = request.getSession();
//		if (session.getAttribute("login") != null)
//		{
//			String argu = "";
//			if (request.getParameter("searchContent") != null && !request.getParameter("searchContent").equals(" "))
//			{
//				argu = request.getParameter("searchContent");
//			}
//			String sql = "select * from userInfo.goodsInfo where (id like '%"
//						+ argu + "%'  or name like '%"
//						+ argu + "%' or type like '%"
//						+ argu + "%' or stock like '%"
//						+ argu + "%' or manufacturer like '%"
//						+ argu + "%' or supplier like '%"
//						+ argu + "%' or managername like '%"
//						+ argu + "%')";
//
//	 		if (request.getParameter("screeningStock") != null && !request.getParameter("screeningStock").equals("null"))
//			{
//				sql = sql + " and stock <" + Integer.parseInt(request.getParameter("screeningStock"));
//			} 
//			if (request.getParameter("screeningType") != null &&  !request.getParameter("screeningType").equals("null"))
//			{
//				sql = sql + " and type='" + request.getParameter("screeningType") + "'";
//			}
//			if (request.getParameter("screeningManufacturer") != null && !request.getParameter("screeningManufacturer").equals("null"))
//			{
//				sql = sql + " and supplier='" + request.getParameter("screeningManufacturer") + "'";
//			}
//			if (request.getParameter("screeningSort") != null && !request.getParameter("screeningSort").equals("null")
//				&& request.getParameter("screeningSortType") != null && !request.getParameter("screeningSortType").equals("null"))
//			{
//				if (Integer.parseInt(request.getParameter("screeningSort")) == 1)
//				{
//					sql = sql + "order by " + request.getParameter("screeningSortType") + " asc";
//				}
//				else
//				{
//					sql = sql + "order by " + request.getParameter("screeningSortType") + " desc";
//				}
//			}
//	        ArrayList<Goods> allGoods = GoodsDao.stringSqlQuery(sql);
//	        if (allGoods != null)
//	        {
//	        	request.setAttribute("allGoods", allGoods);
//	        }
//	        PrintWriter out = response.getWriter();
//			out.println("1");
//	        request.getRequestDispatcher("Customer/Shopping.jsp").forward(request, response);
//		}
//		else {
//			String sql = "select * from userInfo.goodsInfo";
//			ArrayList<Goods> allGoods = GoodsDao.stringSqlQuery(sql);
//			request.setAttribute("allGoods", allGoods);
//			request.getRequestDispatcher("Customer/Shopping.jsp").forward(request, response);
//		}
		//
		
		HttpSession session = request.getSession();
		String[] check = request.getParameterValues("shop");
		if (check != null)
		{
			Map<CartInfo, Integer> cart  = (Map<CartInfo, Integer>)session.getAttribute("cartInfo");
			// judge customerID whether or not changed
			if (cart == null || Customer.custID != Integer.parseInt(session.getAttribute("CustomerID").toString()))
			{
				cart = new HashMap<CartInfo, Integer>();
			}
			Customer.custID = Integer.parseInt(session.getAttribute("CustomerID").toString());
			for (String id : check) {
				boolean flag = true;
				CartInfo cartInfo = new CartInfo();
				// question
				
				
				//add cartInfo in session.map
				int ID = Integer.parseInt(id);
				
				Iterator<Entry<CartInfo, Integer>> it = cart.entrySet().iterator();
				while (it.hasNext()) {
					Entry<CartInfo, Integer> entry=it.next();
					CartInfo key=entry.getKey();
					if (key.getGoodsID() == ID)
					{
						key.setPieces(key.getPieces() + 1);
						flag = false;
					}
					//delete appointed goods in session map
				}
				if (flag)
				{
					cartInfo.setGoodsID(ID);
					cartInfo.setCustomerID(Integer.parseInt(session.getAttribute("CustomerID").toString()));
					cartInfo.setPieces(1);
					cartInfo.setGoodsname(GoodsDao.BackGoodsNameWithID(Integer.parseInt(id)));
					cart.put(cartInfo, cart.size() + 1);
				}
				
			}
			
			session.setAttribute("cartInfo", cart);
			
			request.getRequestDispatcher("Customer/Cart.jsp").forward(request, response);
		}
		else {
			response.sendRedirect("Customer/Shopping.jsp");
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
