<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>Register</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="AllStyle/Register.css">

	
	
  </head>
  
  <body>
    <div class="container">
    <h2>Register And Beginning</h2>
    <form name="registerForm" class="formContent" method="post" action="LoginAndRegister/TestRegister.jsp">
        <ul>
        <li>
            <span>LoginName:</span>
            <input  type="text" name="loginname" required>
        </li>
        <li>
            <span>&nbsp;UserName:</span>
            <input type="text" name="username" required>
        </li>
        <li>
            <span>&nbsp;&nbsp;Password:</span>
            <input type="text" name="password" required>
        </li>
        <li>
            <span>&nbsp;RepeatPW:</span>
            <input type="text" name="repeatpassword" required>
        </li>
        <li>
            <span>&nbsp;Telephone:</span>
            <input type="number" name="telephone" required>
        </li>
    </ul>
        <input class="submit" type="submit" name="submit" value="REGISTER">
        <input class="reset" type="reset" name="reset" value="RESET">
    </form>
  </body>
</html>
