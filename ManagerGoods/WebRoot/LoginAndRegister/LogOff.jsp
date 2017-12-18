<%@page import="com.rjgc.cjh.domain.Goods"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'LogOff.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="AllStyle/LogOffResult.css">


  </head>
  
  <body>
  <center>
  <p>确定要注销当前用户：<%=Goods.Loginer%></p>
  </center>
  <div class="footer">
  <a href="LoginAndRegister/LogOffResult.jsp">确定</a>
  <a href="LoginAndRegister/Welcome.jsp">返回</a>
  </div>
  </body>
</html>
