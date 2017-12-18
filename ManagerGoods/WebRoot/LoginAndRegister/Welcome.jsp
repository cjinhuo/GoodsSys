<%@page import="com.rjgc.cjh.domain.Goods"%>
<%@page import="com.rjgc.cjh.dao.ManagerDao"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>Validate Login</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="AllStyle/Welcome.css">
	
  </head>
  
  <body>
  <center>
  		<%
  		if (Goods.Loginer != null)
  		{
  			%>
  		<p>Welcome <%=Goods.Loginer%></p>
    	<div class="container">
        <ul>
            <li><a href="OperateGoods/Add.jsp">添加商品</a></li>
            <li><a href="OperateGoods/Delete.jsp">删除商品</a></li>
            <li><a href="OperateGoods/Update.jsp">修改商品</a></li>
            <li><a href="OperateGoods/Query.jsp">查询商品</a></li>
        </ul>
    </div>  
        <div class="footer">
        <a href="LoginAndRegister/LogOff.jsp">注销账户</a>
        <a href="LoginAndRegister/Register.jsp">注册用户</a>
    </div>
  			<%
  		}
  		else
  		{
  			%>
  			<a href="LoginAndRegister/Login.jsp">请先登录，点击跳转！</a>
  			<%
  		}
  		 %>
    	
     </center>   
  </body>
</html>
