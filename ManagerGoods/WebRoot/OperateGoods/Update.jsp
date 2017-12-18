<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.rjgc.cjh.dao.GoodsDao"%>
<%@page import="com.rjgc.cjh.domain.Goods"%>
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
    
    <title>Update</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="AllStyle/Delete.css">
	<style>
	.containerButton{
        width: 70px;
        height: 70px;
        position: fixed;
        left: 0px;
        top: 400px;
        overflow: hidden;
    }
    .containerButton a{
        font-size: 18px;
        text-align: center;
        line-height: 70px;
        text-decoration: none;
        width: 100%;
        height: 100%;
        border-radius: 70px;
        background-color: #26c7f5;
        color: #9480ff;
        left: -35px;
        position: absolute;
        transition: 0.5s;
    }
    .containerButton:hover a{
        left: 0;
        background-color: #9480ff;
        color: #26c7f5;
    }
    .containerButton a:active{
        color: #f55990;
        transition: 0.2s;
    }
	</style>
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
            <form action="OperateGoods/Update.jsp" method="post">
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
        	<form class="formData" method="post" action="OperateGoods/UpdateInfo.jsp">
				<ul>
					<li><input type="number" value="<%=goods.getId() %>"
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
					<li><input type="text" value="<%=goods.getSupplier() %>"q
						 name="supplier" readonly="readonly"></li>
					<li><input class="submit" type="submit" value="Update"></li>
				</ul>
				</form>
				<%
        }
         %>
			
		</div>
	<div class="containerButton">
        <a href="LoginAndRegister/Welcome.jsp">Home</a>
    </div>
</div>
</body>
  
</html>
