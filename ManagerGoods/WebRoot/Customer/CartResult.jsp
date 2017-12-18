<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'CartResult.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="AllStyle/Cart.css">
  </head>
  <style>
  h3{
  algin-text:center;
  }
  a{
  text-decoration:none;
  }
  </style>
  <body>
 <h3>${sessionScope.customername}的订单</h3>
  	<div class="all">
		<div class="header">
			<h4>序号</h4>
			<h4>商品名称</h4>
			<h4>商品数量</h4>
			<h4>订单号</h4>
		</div>
		<div class="container">
		<form class="formData" method="post">
		<c:forEach items="${success}" var="cart" varStatus="index">
				<ul>
					<li><input type="text" value="${index.count}"
						 readonly="readonly"></li>
					<li><input type="text" value="${cart.goodsname}"
						 readonly="readonly"></li>
					<li><input type="number" value="${cart.pieces}"
						readonly="readonly""></li>
					<li><input type="number" value="${cart.orderID}"
						readonly="readonly""></li>
				</ul>
				<br />
		</c:forEach>
         <a class="goshop" href='Customer/CustomerWelcome.jsp'>首页</a>
         </form>
		</div>
	</div>
  </body>
</html>
