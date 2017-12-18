<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'CustomerWelcome.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="AllStyle/Welcome.css">

  </head>
  
  <body>
  
  <center>
    <p>Welcome ${sessionScope.customername}</p>
    	<div class="container">
        <ul>
            <li><a href="Customer/Shopping.jsp">购物中心</a></li>
            <li><a href="PersonalData">订单中心</a></li>
        </ul>
    </div>  
        <div class="footer">
        <a href="Customer/LoginCustomer.jsp">注销账户</a>
        <a href="LoginAndRegister/Index.jsp">网站首页</a>
    </div>
    </center>
  </body>
</html>
