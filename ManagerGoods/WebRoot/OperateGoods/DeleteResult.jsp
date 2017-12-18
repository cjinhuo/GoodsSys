<%@page import="com.rjgc.cjh.dao.GoodsDao"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>DeleteResult</title>
    
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
    int id = Integer.parseInt(request.getParameter("id"));
    if (GoodsDao.deleteOneData(id))
    {
    %>
    <p>Delete Successfully!</p>
    <a href='OperateGoods/Delete.jsp'>Back To Delete</a>
    <p>or<a href='LoginAndRegister/Welcome.jsp'>Go To HomePage</a></p>
    <% 
    }
    else
    {
    %>
    <p>Failed To Delete!</p>
    <a href='LoginAndRegister/Welcome.jsp'>Go To HomePage</a>
    <%
    
    }
     %>
     </center>
  </body>
</html>
