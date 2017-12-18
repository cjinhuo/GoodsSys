<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'DeleteInfo.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="AllStyle/AddInfo.css">

  </head>
  
  <body>
      <div class="all">
    <div class="header">
        <h4>商品货号</h4>
        <h4>商品名称</h4>
        <h4>商品类型</h4>
        <h4>商品库存</h4>
        <h4>生产日期</h4>
        <h4>保质期</h4>
        <h4>添加者</h4>
        <h4>生产商</h4>
        <h4>供应商</h4>
    </div>
    <div class="container">
        <form class="formData" method="post" action="OperateGoods/DeleteResult.jsp">
            <ul>
                <li><input type="text" value="<%=request.getParameter("id")%>" name="id" readonly="readonly"></li>
                <li><input type="text" value="<%=request.getParameter("name")%>" name="name" readonly="readonly"></li>
                <li><input type="text" value="<%=request.getParameter("type")%>" name="type" readonly="readonly"></li>
                <li><input type="text" value="<%=request.getParameter("stock")%>" name="stock" readonly="readonly"></li>
                <li><input type="text" value="<%=request.getParameter("PD")%>" name="PD" readonly="readonly"></li>
                <li><input type="text" value="<%=request.getParameter("EXP")%>" name="EXP" readonly="readonly"></li>
                <li><input type="text" value="<%=request.getParameter("managername")%>" name="managername" readonly="readonly"></li>
                <li><input type="text" value="<%=request.getParameter("manufacturer")%>" name="manufacturer" readonly="readonly"></li>
                <li><input type="text" value="<%=request.getParameter("supplier")%>" name="supplier" readonly="readonly"></li>
            </ul>
            <input class="submit" type="submit" value="Delete">
            <input class="reset" type="button" value="Back" onclick="javascript:history.go(-1);
            location.replace(document.referrer)">
        </form>
    </div>
</div>
  </body>
</html>
