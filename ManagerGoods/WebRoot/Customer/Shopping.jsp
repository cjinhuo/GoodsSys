<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.rjgc.cjh.dao.GoodsDao"%>
<%@page import="com.rjgc.cjh.domain.Goods"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Shopping.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="AllStyle/Shopping.css">

  </head>
  <style>
	 a{
  text-decoration:none;
  display:inline-block;
  text-align:center;
  line-height:60px;
  }
  </style>
<body onload="initStock()">
	<div class="all">
		<div class="header">
			<h4>购物状态</h4>
			<h4>商品名称</h4>
			<h4>商品类型</h4>
			<h4>商品库存</h4>
			<h4>生产日期</h4>
			<h4>供应商</h4>
			<div class="search">
				<form action="Customer/Shopping.jsp" method="post">
					<input type="text" name="searchContent" class="searchText"
						placeholder="Enter"> <input class="buttonSearch"
						type="submit" value="Search">
				</form>
			</div>
		</div>
		<div class="container">
		<form class="formData" method="post" action="Shopping">
			<%
		String argu = "";
			%>
			<% 
		if (request.getParameter("searchContent") != null && !request.getParameter("searchContent").equals(" "))
		{
			argu = request.getParameter("searchContent");
		}
		String sql = "select * from userInfo.goodsInfo where (id like '%"
					+ argu + "%'  or name like '%"
					+ argu + "%' or type like '%"
					+ argu + "%' or stock like '%"
					+ argu + "%' or manufacturer like '%"
					+ argu + "%' or supplier like '%"
					+ argu + "%' or managername like '%"
					+ argu + "%')";

 		if (request.getParameter("screeningStock") != null && !request.getParameter("screeningStock").equals("null"))
		{
			sql = sql + " and stock <" + Integer.parseInt(request.getParameter("screeningStock"));
		} 
		if (request.getParameter("screeningType") != null &&  !request.getParameter("screeningType").equals("null"))
		{
			sql = sql + " and type='" + request.getParameter("screeningType") + "'";
		}
		if (request.getParameter("screeningManufacturer") != null && !request.getParameter("screeningManufacturer").equals("null"))
		{
			sql = sql + " and supplier='" + request.getParameter("screeningManufacturer") + "'";
		}
		if (request.getParameter("screeningSort") != null && !request.getParameter("screeningSort").equals("null")
			&& request.getParameter("screeningSortType") != null && !request.getParameter("screeningSortType").equals("null"))
		{
			if (Integer.parseInt(request.getParameter("screeningSort")) == 1)
			{
				sql = sql + "order by " + request.getParameter("screeningSortType") + " asc";
			}
			else
			{
				sql = sql + "order by " + request.getParameter("screeningSortType") + " desc";
			}
		}
        ArrayList<Goods> allGoods = GoodsDao.stringSqlQuery(sql);
        if (allGoods != null)
        {
        for (Goods goods : allGoods) {
        	%>        	
			
				<ul>
					<li><input class="checkboxshop" type="checkbox" name="shop" value="<%=goods.getId()%>"></li>
					<li><input type="text" value="<%=goods.getName()%>"
						name="name" readonly="readonly"></li>
					<li><input type="text" value="<%=goods.getType() %>"
						name="type" readonly="readonly"></li>
					<li><input type="text" value="<%=goods.getStock() %>"
						name="stock" readonly="readonly"></li>
					<li><input type="text" value="<%=goods.getPD() %>" name="PD"
						readonly="readonly"></li>
					<li><input type="text" value="<%=goods.getSupplier() %>"
						name="supplier" readonly="readonly"></li>
					<li><input type="text" value="" readonly="readonly"></li>
				</ul>
			<%
        }
        }
         %>
         <input class="goshop" type="submit" name="submit" value="加入购物车">
         <a class="back" href='Customer/CustomerWelcome.jsp'>首页</a>
         </form>
		</div>
	</div>
	
	<div class="containerFloat">
	<div class="againContainer">
		<div class="floatForm">
			<h3>Screening Mechanism</h3>
			<form action="Customer/Shopping.jsp" method="post"
				class="filterForm" name="filterForm">
				<ul>
					<li><span>类型:</span> <select name="screeningType">
							<option value=null>请选择</option>
							<option value="book">book</option>
							<option value="medicine">medicine</option>
							<option value="digital">digital</option>
							<option value="fruit">fruit</option>
							<option value="toy">toy</option>
					</select></li>
					<li><span>库存:</span> <select id="stockName" name="screeningStock">
							<option value=null>请选择</option>
					</select></li>
					<li><span>供应商:</span> <select name="screeningManufacturer">
							<option value=null>请选择</option>
							<%
                    ArrayList<Goods> goodsList = GoodsDao.findAll();
                    if (goodsList != null)
                    {
                    for (Goods goods : goodsList)
                    {
                    	%>
							<option value="<%=goods.getSupplier()%>"><%=goods.getSupplier()%></option>
							<%
					}
					}
                    %>
					</select></li>
					<li><span>排序:</span> 
					<select name="screeningSortType">
							<option value=null>请选择</option>
							<option value="id">商品货号</option>
							<option value="PD">生产日期</option>
							<option value="EXP">保质期</option>
							<option value="manufacturer">生产商</option>
					</select>
					
					<select name="screeningSort">
							<option value=null>无序</option>
							<option value="1">升序</option>
							<option value="2">降序</option>
					</select></li>
				</ul>
				<input class="submit" type="submit" value="搜索" name="submit">
				<a class="backHome" href='LoginAndRegister/Welcome.jsp'>Back To Home</a>
			</form>

       	
		</div>
		</div>
	</div>
</body>
<script type="text/javascript">

	function initStock() {
    var root = document.getElementById("stockName")
    for (var i = 1; i <= 100; i++) {
        var e = document.createElement('option')
        e.value = i
        e.text = i + "以下";
        root.add(e, null)
    }
}
  </script>
</html>
