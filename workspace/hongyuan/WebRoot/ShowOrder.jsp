<%@ page language="java" import="java.util.*" import="model.*" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">  
 	<meta name="Author" content="yanbin"> 
<style>
</style>
</head>
<body>
<h2>我的订单</h2>
  <a href="GoMenuList">返回购物大厅</a>">返回购物大厅</a>
  <table border="1" style="border-collapse:collapse width:1200px">
  <tr><th>序号</th><th>菜名</th><th>价格</th><th>删除</th></tr>
<%ArrayList<Order> list=(ArrayList<Order>)request.getAttribute("list");
if(list==null||list.size()<1){
    	out.print("没有数据！");
    	}else {
    	int i=0;
    	for(Order order:list){
 %> 
<tr>
	<td><%=i+1%></td>
  <td><%=order.getName()%></td>
  <td><%=order.getPrice()%>元</td>
</tr>
<% i=i+1;}
}
 %>
</table>
</body>