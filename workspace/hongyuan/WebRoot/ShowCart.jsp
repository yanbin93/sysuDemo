<%@ page language="java" import="java.util.*,model.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>查看购物车</title>
  </head>  
  <body>
    <h2>我的购物车</h2>
  <a href="FindMenu">返回购物大厅</a>">返回购物大厅</a>
  <form action="ShoppingCl?type=update" method="post">
  <table border="1" style="border-collapse:collapse width:1200px">
  <tr><th>序号</th><th>菜名</th><th>价格</th><th>数量</th><th>删除</th></tr>
 <%//从request中取出药显示的商品信息
 	ArrayList<Menu> al=(ArrayList<Menu>)request.getAttribute("cartlist");
 	for(int i=0;i<al.size();i++){
 	Menu menu=(Menu)al.get(i);
  %> 
  <tr>
  <td><%=i+1%><input type='hidden' name="id" value="<%=menu.getId() %>"/></td>
  <td><%=menu.getName()%></td><td>
  <%=menu.getPrice() %></td>
  <td><input type="text" name="num" value="<%=menu.getShoppingNum() %>"/>份</td>
  <td><a href='ShoppingCl?type=del&id=<%=menu.getId() %>'>删除</a></td>
  </tr>
    <%} %>
  <tr><td colspan="6"><input type="submit" value="update"/></td></tr>
  <tr><td colspan="6">购物车的总价格：<%=request.getAttribute("totalPrice")%>元</td></tr>
  </table>
  </form>
  <a href="MenuAdd">提交订单</a>
  </body>
</html>
