package com.rjgc.cjh.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.rjgc.cjh.domain.Customer;
import com.rjgc.cjh.domain.Goods;
import com.rjgc.cjh.domain.Manager;
import com.rjgc.cjh.utils.JDBCUtils;

public class CustomerDao {
	public static boolean login(int EnterID, String password) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<Customer> customers = findAll();
		for (Customer customer : customers) {
			if (customer.getID() == EnterID &&
					customer.getPassword().equals(password)) {
				return true;
			}
			}
		return false;
	}
	
	public static String BackCustomerName(int ID) {
		ArrayList<Customer> customers = findAll();
		for (Customer customer : customers) {
			if (customer.getID() == ID) {
				return customer.getCustomername();
			}
			}
		return null;
	}
	
	public static ArrayList<Customer> findAll() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<Customer> list = new ArrayList<Customer>();
		try {
			conn = JDBCUtils.getConnection();
			stmt = conn.createStatement();
			String sql = "select * from CustomerInfo";
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Customer customer = new Customer();
				customer.setCustomername(rs.getString("customername"));
				customer.setID(rs.getInt("ID"));
				customer.setPassword(rs.getString("password"));
				list.add(customer);
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
	
	public static boolean CheckCustomerID(int id) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtils.getConnection();
			stmt = conn.createStatement();
			String sql = "select * from CustomerInfo";
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				if (id == rs.getInt("ID")) {
					return true;
				}
			}
			return false;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			JDBCUtils.release(rs, stmt, conn);
		}
		return false;
	}
	
	
	public static boolean insert(Customer customer) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			//set up connection
			conn = JDBCUtils.getConnection();
			//set up statement
			stmt = conn.createStatement();
			String sql = "insert into CustomerInfo(ID,password,customername) values("
			 + customer.getID()
			 + ",'"
			 +customer.getPassword()
			 + "','"
			 +customer.getCustomername()
			 + "')";
			int num = stmt.executeUpdate(sql);
			if (num > 0)
			{
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
	
	
	
	
	
}
