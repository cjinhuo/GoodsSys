<%@page import="java.lang.ProcessBuilder.Redirect"%>
<%@page import="com.rjgc.cjh.dao.ManagerDao"%>
<%@page import="com.rjgc.cjh.domain.Manager"%>
<%@page import="com.rjgc.cjh.utils.JDBCUtils"%>
<%@page import="java.sql.Statement"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>Validate Register</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="AllStyle/Common.css">

  </head>
  
  <body>
  <center>
	<%
	Manager manager = new Manager();
	manager.setLoginname(request.getParameter("loginname"));
	manager.setPassword(request.getParameter("password"));
	manager.setUsername(request.getParameter("username"));
	manager.setTelephone(Integer.parseInt(request.getParameter("telephone")));
	if (!ManagerDao.find(request.getParameter("loginname")) 
	&& request.getParameter("repeatpassword").equals(request.getParameter("password")))
	{
		if (ManagerDao.insert(manager)) {
		%>
		<p>Succeed Register</p>
		<a href='LoginAndRegister/Login.jsp'>Go To Login</a>
		<%
		}
		else {
		%>
		<p>Fail Register</p>
		<a href='LoginAndRegister/Register.jsp'>Please Register Again</a>
		<%
		}
	}
	else
	{%>
	<p>Already Exists LoginName or Your seconde passowrd is different with  Last Time</p>
	<a href='LoginAndRegister/Register.jsp'>Please Register Again</a>
	<%
		
	}
	 %>
	 </center>
  </body>
</html>
