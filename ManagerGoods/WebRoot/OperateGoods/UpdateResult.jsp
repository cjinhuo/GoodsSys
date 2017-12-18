<%@page import="com.rjgc.cjh.dao.GoodsDao"%>
<%@page import="java.text.SimpleDateFormat"%>
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
    
    <title>UpdateResult</title>
    
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
    response.setContentType("text/html;charset=UTF-8");
	request.setCharacterEncoding("UTF-8");
	response.setCharacterEncoding("utf-8");
    Goods goods = new Goods();
    goods.setId(Integer.parseInt(request.getParameter("id")));
    goods.setStock(Integer.parseInt(request.getParameter("stock")));
    goods.setManagername(request.getParameter("managername"));
    goods.setManufacturer(request.getParameter("manufacturer"));
    goods.setType(request.getParameter("type"));
    goods.setEXP(request.getParameter("EXP"));
    goods.setSupplier(request.getParameter("supplier"));
    goods.setName(request.getParameter("name"));
    String PD = request.getParameter("PD");
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    java.util.Date d = null;
    d = sdf.parse(PD);
    goods.setPD(d);
    if (GoodsDao.update(goods))
    {
    	%>
    	<p>Update ID:<%=goods.getId()%> All Informations Successfully</p>
    	<a href='OperateGoods/Update.jsp'>Back To Update</a>
    	<a href='LoginAndRegister/Welcome.jsp'>Back To Home</a>
    	<%
    }
    else
    {
    	%>
    	<p>Update ID:<%=goods.getId()%> All Informations Fail</p>
    	<a href='OperateGoods/Update.jsp'>Back To Update</a>
    	<a href='LoginAndRegister/Welcome.jsp'>Back To Home</a>
    	<%
    }
     %>
    </center>
  </body>
</html>
