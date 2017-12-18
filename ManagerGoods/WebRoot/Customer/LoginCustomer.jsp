<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'LoginCustomer.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="AllStyle/Login.css">


  </head>
  <style>
     a{
  text-decoration:none;
  display:inline-block;
  text-align:center;
  line-height:60px;
  }
  h2{
  text-align:center;
  }
  </style>
  <body>
        <div class="container">
    <h2>Login And Beginning</h2>
    <form name="loginForm" class="formContent" method="post" action="Login">
        <ul>
            <li>
                <span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;ID:</span>
                <input  type="number" name="ID" required>
            </li>
            <li>
                <span>&nbsp;&nbsp;Password:</span>
                <input type="password" name="password" required>
            </li>
        </ul>
        <input class="submit" type="submit" name="submit" value="Login">
        <a class="reset" href='Customer/RegisterCustomer.jsp'>Register</a>
    </form>
</div>
  </body>
</html>
