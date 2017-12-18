package com.rjgc.cjh.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import org.apache.taglibs.standard.lang.jstl.AndOperator;

import com.rjgc.cjh.domain.Goods;
import com.rjgc.cjh.domain.Manager;
import com.rjgc.cjh.utils.JDBCUtils;

public class GoodsDao {
	
	// insert data into goodsInfo table
	public static boolean insert(Goods goods) {

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			//set up connection
			conn = JDBCUtils.getConnection();
			//set up statement
			stmt = conn.createStatement();
			
			java.sql.Date date = new java.sql.Date(goods.getPD().getTime());
			String sql = "insert into goodsInfo(id,stock,name,type,"
					+ "PD,EXP,manufacturer,managername,supplier) values("
			 + goods.getId()
			 + ","
			 +goods.getStock()
			 + ",'"
			 +goods.getName()
			 + "','"
			 +goods.getType()
			 + "','"
			 + date
			 + "','"
			 + goods.getEXP()
			 +"','"
			 +goods.getManufacturer()
			 + "','"
			 +goods.getManagername()
			 +"','"
			 +goods.getSupplier()
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
	
	
	public static String BackGoodsNameWithID(int id) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtils.getConnection();
			stmt = conn.createStatement();
			String sql = "select * from goodsInfo where id=" + id;
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				return rs.getString("name");
			}
			return null;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			JDBCUtils.release(rs, stmt, conn);
		}
		return null;
	}
	
	public static int BackGoodsNumWithID(int id) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtils.getConnection();
			stmt = conn.createStatement();
			String sql = "select * from goodsInfo where id=" + id;
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				return rs.getInt("stock");
			}
			return -1;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			JDBCUtils.release(rs, stmt, conn);
		}
		return -1;
	}
	
	public static ArrayList<Goods> findAll() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<Goods> list = new ArrayList<Goods>();
		try {
			conn = JDBCUtils.getConnection();
			stmt = conn.createStatement();
			String sql = "select * from goodsInfo";
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Goods goods = new Goods();
				goods.setId(rs.getInt("id"));
				goods.setName(rs.getString("name"));
				goods.setType(rs.getString("type"));
				goods.setStock(rs.getInt("stock"));
				goods.setPD(rs.getDate("PD"));
				goods.setEXP(rs.getString("EXP"));
				goods.setManufacturer(rs.getString("manufacturer"));
				goods.setSupplier(rs.getString("supplier"));
				goods.setManagername(rs.getString("managername"));
				list.add(goods);
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
	
	
	public static boolean deleteOneData(int id) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtils.getConnection();
			stmt = conn.createStatement();
			String sql = "select * from goodsInfo";
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				if (id == rs.getInt("id"))
				{
					String delete = "delete from goodsInfo where id=" + id;
					if (stmt.executeUpdate(delete) > 0)
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
	
	public static ArrayList<Goods> fuzzyQuery(String argu)
	{
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<Goods> list = new ArrayList<Goods>();
		try {
			conn = JDBCUtils.getConnection();
			stmt = conn.createStatement();
			String sql = "select * from userInfo.goodsInfo where id like '%"
					+ argu + "%'  or name like '%"
					+ argu + "%' or type like '%"
					+ argu + "%' or stock like '%"
					+ argu + "%' or manufacturer like '%"
					+ argu + "%' or supplier like '%"
					+ argu + "%' or managername like '%"
					+ argu + "%'";
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Goods goods = new Goods();
				goods.setId(rs.getInt("id"));
				goods.setName(rs.getString("name"));
				goods.setType(rs.getString("type"));
				goods.setStock(rs.getInt("stock"));
				goods.setPD(rs.getDate("PD"));
				goods.setEXP(rs.getString("EXP"));
				goods.setManufacturer(rs.getString("manufacturer"));
				goods.setSupplier(rs.getString("supplier"));
				goods.setManagername(rs.getString("managername"));
				list.add(goods);
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
	
	public static ArrayList<Goods> advanceFuzzyQuery(String argu,int stock,String type,String managername)
	{
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<Goods> list = new ArrayList<Goods>();
		try {
			conn = JDBCUtils.getConnection();
			stmt = conn.createStatement();
			String sql = "select * from userInfo.goodsInfo where id like '%"
					+ argu + "%'  or name like '%"
					+ argu + "%' or type like '%"
					+ argu + "%' or stock like '%"
					+ argu + "%' or manufacturer like '%"
					+ argu + "%' or supplier like '%"
					+ argu + "%' or managername like '%"
					+ argu + "%' and stock < " + stock
					+ "and type'=" + type + "' and managername ='" + managername + "'";
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Goods goods = new Goods();
				goods.setId(rs.getInt("id"));
				goods.setName(rs.getString("name"));
				goods.setType(rs.getString("type"));
				goods.setStock(rs.getInt("stock"));
				goods.setPD(rs.getDate("PD"));
				goods.setEXP(rs.getString("EXP"));
				goods.setManufacturer(rs.getString("manufacturer"));
				goods.setSupplier(rs.getString("supplier"));
				goods.setManagername(rs.getString("managername"));
				list.add(goods);
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
	
	public static ArrayList<Goods> stringSqlQuery(String sql)
	{
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<Goods> list = new ArrayList<Goods>();
		try {
			conn = JDBCUtils.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Goods goods = new Goods();
				goods.setId(rs.getInt("id"));
				goods.setName(rs.getString("name"));
				goods.setType(rs.getString("type"));
				goods.setStock(rs.getInt("stock"));
				goods.setPD(rs.getDate("PD"));
				goods.setEXP(rs.getString("EXP"));
				goods.setManufacturer(rs.getString("manufacturer"));
				goods.setSupplier(rs.getString("supplier"));
				goods.setManagername(rs.getString("managername"));
				list.add(goods);
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
	
	
	
	public static boolean update(Goods goods) {

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			//set up connection
			conn = JDBCUtils.getConnection();
			//set up statement
			stmt = conn.createStatement();
			java.sql.Date date = new java.sql.Date(goods.getPD().getTime());
			String updateSQL = "update goodsInfo set name = '" + goods.getName() 
									+ "', type = '" +  goods.getType() 
									+ "', EXP = '" + goods.getEXP()
									+ "', Manufacturer = '" + goods.getManufacturer()
									+ "', supplier = '" + goods.getSupplier()
									+ "', managername = '" + goods.getManagername()
									+ "', stock = " + goods.getStock()
									+ ", PD = '" + date + "' where id=" + goods.getId();
			int num = stmt.executeUpdate(updateSQL);
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
