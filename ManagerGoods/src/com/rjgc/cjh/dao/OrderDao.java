package com.rjgc.cjh.dao;

import java.awt.List;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.rjgc.cjh.domain.CartInfo;
import com.rjgc.cjh.domain.Customer;
import com.rjgc.cjh.utils.JDBCUtils;

public class OrderDao {
	public static boolean insert(CartInfo cartInfo) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			//set up connection
			conn = JDBCUtils.getConnection();
			//set up statement
			stmt = conn.createStatement();
			String sql = "insert into orderInfo(orderID,pieces,CustomerID,goodsID,goodsname) values("
			 + cartInfo.getOrderID()
			 + ","
			 +cartInfo.getPieces()
			 + ","
			 +cartInfo.getCustomerID()
			 +","
			 +cartInfo.getGoodsID()
			 +",'"
			 +cartInfo.getGoodsname()
			 + "')";
			int num = stmt.executeUpdate(sql);
			if (num > 0)
			{
				String updatesqlString = "update userInfo.goodsInfo set stock=stock-" + cartInfo.getPieces() + " where id=" + cartInfo.getGoodsID();
				stmt.executeUpdate(updatesqlString);
				return true;
			}
			return false;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.release(rs, stmt, conn);
		}
		return false;
	}
	
	public static ArrayList<CartInfo> findWithCustomerID(int CustomerID) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<CartInfo> list = new ArrayList<CartInfo>();
		try {
			conn = JDBCUtils.getConnection();
			stmt = conn.createStatement();
			String sql = "select * from orderInfo where CustomerID="+CustomerID;
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				CartInfo cartInfo = new CartInfo();
				cartInfo.setCustomerID(CustomerID);
				cartInfo.setGoodsID(rs.getInt("goodsID"));
				cartInfo.setGoodsname(rs.getString("goodsname"));
				cartInfo.setPieces(rs.getInt("pieces"));
				cartInfo.setOrderID(rs.getInt("orderID"));
				list.add(cartInfo);
			}
			return list;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			JDBCUtils.release(rs, stmt, conn);
		}
		return null;
	}
	
	public static ArrayList<CartInfo> findWithOrderID(ArrayList<Integer> orderID) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		ArrayList<CartInfo> list = new ArrayList<CartInfo>();
		try {
			conn = JDBCUtils.getConnection();
			stmt = conn.createStatement();
			for (Integer num : orderID) {
				String sql = "select * from orderInfo where orderID="+num;
				rs = stmt.executeQuery(sql);
				while (rs.next()) {
					CartInfo cartInfo = new CartInfo();
					cartInfo.setCustomerID(rs.getInt("CustomerID"));
					cartInfo.setGoodsID(rs.getInt("goodsID"));
					cartInfo.setGoodsname(rs.getString("goodsname"));
					cartInfo.setPieces(rs.getInt("pieces"));
					cartInfo.setOrderID(rs.getInt("orderID"));
					list.add(cartInfo);
				}
			}
			return list;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			JDBCUtils.release(rs, stmt, conn);
		}
		return null;
	}
	
	
	
	public static int BackMaxorderID() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			//set up connection
			conn = JDBCUtils.getConnection();
			//set up statement
			stmt = conn.createStatement();
			String sql = "select max(orderID)as orderID from userInfo.orderInfo";
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				return rs.getInt("orderID");
			}
			return 0;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.release(rs, stmt, conn);
		}
		return 0;
	}
	
	public static ArrayList<Integer> FindOrderIDWithCustomerID(int CustomerID) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<Integer> list = new ArrayList<Integer>();
		try {
			conn = JDBCUtils.getConnection();
			stmt = conn.createStatement();
			String sql = "select distinct orderID from orderInfo where CustomerID="+CustomerID;
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				int num = rs.getInt("orderID");
				list.add(num);
			}
			return list;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			JDBCUtils.release(rs, stmt, conn);
		}
		return null;
	}
}
