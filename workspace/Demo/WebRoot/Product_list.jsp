<%@ page language="java" import="java.util.*" import="model.*" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">  
 	<meta name="Author" content="yanbin"> 
  </head>
  <body>
    	<%
    	ArrayList<Product> list=(ArrayList<Product>)request.getAttribute("list");
    	if (list==null||list.size()<1){
    	out.print("没有数据！");
    	}else {
    	%>
    	  <table frame="all" align="center" width="600" border="1">
    	<tr>
    		<td align="center" colspan="8">
    			<h2>商品信息</h2>
    		</td>
    	</tr>
    	<tr align="center">
    		<td><b>商品ID</b></td>
    		<td><b>商品名称</b></td>
    		<td><b>货品号</b></td>
    		<td><b>商品生产批号</b></td>
    		<td><b>生产日期</b></td>
    		<td><b>过期日期</b></td>
    		<td><b>商品描述信息 </b></td>
    		<td><b>删除</b></td>
    	</tr>
    	<% 
    	for(Product product:list){
    	%>
    	<tr align="center">
    		<td>&nbsp;<%=product.getProductId() %></td>
    		<td>&nbsp;<%=product.getProductName()%></td>
    		<td>&nbsp;<%=product.getProductNo()%></td>
    		<td>&nbsp;<%=product.getProductBatch()%></td>
    		<td><%=product.getProductStart()%></td>
    		<td><%=product.getProductEnd()%></td>
    		<td><%=product.getDescription()%></td>
    	<td><a href="ProductDelete?id=<%=product.getProductId()%>">删除</a></td>
    	</tr>
    	<%
    	}
    }
%>
    </table>
 <div id=bar>
<%
int pageNow=Integer.parseInt(request.getAttribute("pageNow").toString());
int pageCount=Integer.parseInt(request.getAttribute("pageCount").toString());
if(pageNow!=1){
out.println("<a href=FindProduct?pageNow="+(pageNow-1)+">上一页</a>");
}
//显示超链接
for(int i=1;i<=pageCount;i++){
out.println("<a href=FindProduct？pageNow="+i+">["+i+"]</a>");
}
//下一页
if(pageNow!=pageCount){
out.println("<a href=FindProduct?pageNow="+(pageNow+1)+">下一页</a>");
}
 %>
</div>
<div>
<form action="ProductInfo.jsp" method="post"><input type="submit" value="添加"></form>
<form action="FindProduct" method="post"><input type="submit" value="刷新"></form>
<a href="homepage.jsp">返回</a>
<a href="login.jsp">退出登录</a>
</div>
</body>
</html>