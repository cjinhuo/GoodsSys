package com.rjgc.cjh.dao;

import java.io.Console;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import org.omg.IOP.TAG_CODE_SETS;

import com.rjgc.cjh.domain.Manager;
import com.rjgc.cjh.utils.JDBCUtils;



public class ManagerDao {
	
	//validate login's username and password
	public static boolean login(String username, String password) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<Manager> managers = findAll();
		for (Manager manager : managers) {
			if (manager.getLoginname().equals(username) &&
					manager.getPassword().equals(password)) {
				return true;
			}
			}
		return false;
	}
	public static String loginUserName(String username, String password) {
		ArrayList<Manager> managers = findAll();
		for (Manager manager : managers) {
			if (manager.getLoginname().equals(username) &&
					manager.getPassword().equals(password)) {
				return manager.getUsername();
			}
			}
		return null;
	}
	//insert one data value
	public static boolean insert(Manager manager) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			//set up connection
			conn = JDBCUtils.getConnection();
			//set up statement
			stmt = conn.createStatement();
			String sql = "insert into managerInfo(username,password,telephone,loginname) values('"
			 + manager.getUsername()
			 + "','"
			 +manager.getPassword()
			 + "',"
			 +manager.getTelephone()
			 + ",'"
			 +manager.getLoginname()
			 + "')";
			System.out.print(123);
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
	
	public static ArrayList<Manager> findAll() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<Manager> list = new ArrayList<Manager>();
		try {
			conn = JDBCUtils.getConnection();
			stmt = conn.createStatement();
			String sql = "select * from managerInfo";
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Manager manager = new Manager();
				manager.setUsername(rs.getString("username"));
				manager.setPassword(rs.getString("password"));
				manager.setLoginname(rs.getString("loginname"));
				manager.setTelephone(rs.getInt("telephone"));
				list.add(manager);
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
	//determined whether UserName exists or not
	public static boolean find(String registerUser) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtils.getConnection();
			stmt = conn.createStatement();
			String sql = "select * from managerInfo";
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				if (registerUser.equals(rs.getString("loginname"))) {
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
}
