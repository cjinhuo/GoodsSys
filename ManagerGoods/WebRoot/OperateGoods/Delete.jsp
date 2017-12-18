<%@page import="com.rjgc.cjh.dao.GoodsDao"%>
<%@page import="com.rjgc.cjh.domain.Goods"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    response.setContentType("text/html;charset=UTF-8");
	request.setCharacterEncoding("UTF-8");
	response.setCharacterEncoding("utf-8");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'Delete.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" type="text/css" href="AllStyle/Delete.css">


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
        <div class="search">
            <form action="OperateGoods/Delete.jsp" method="post">
                <input type="text" name="searchContent" class="searchText" placeholder="Enter">
                <input  class="buttonSearch" type="submit" value="Search">
            </form>
        </div>
    </div>
		<div class="container">
				<%
		String argu;
		if (request.getParameter("searchContent") == null)
		{
			argu = "";
		}
		else
		{
			argu = request.getParameter("searchContent");
		}
        ArrayList<Goods> allGoods = GoodsDao.fuzzyQuery(argu);
        for (Goods goods : allGoods) {
        	%>
        	<form class="formData" method="post" action="OperateGoods/DeleteInfo.jsp">
				<ul>
					<li><input type="text" value="<%=goods.getId() %>"
						 name="id" readonly="readonly"></li>
					<li><input type="text" value="<%=goods.getName()%>"
						 name="name" readonly="readonly"></li>
					<li><input type="text" value="<%=goods.getType() %>"
						 name="type" readonly="readonly"></li>
					<li><input type="text" value="<%=goods.getStock() %>"
						 name="stock" readonly="readonly"></li>
					<li><input type="text" value="<%=goods.getPD() %>"
						 name="PD"readonly="readonly"></li>
					<li><input type="text" value="<%=goods.getEXP() %>"
						 name="EXP" readonly="readonly"></li>
					<li><input type="text" value="<%=goods.getManagername() %>"
						 name="managername" readonly="readonly"></li>
					<li><input type="text" value="<%=goods.getManufacturer() %>"
						 name="manufacturer"readonly="readonly"></li>
					<li><input type="text" value="<%=goods.getSupplier() %>"
						 name="supplier" readonly="readonly"></li>
					<li><input class="submit" type="submit" value="Delete"></li>
				</ul>
				</form>
				<%
        }
         %>
			
		</div>
</div>
</body>
</html>
