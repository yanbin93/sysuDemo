<%@ page language="java" import="java.util.*" import="model.*" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">  
 	<meta name="Author" content="yanbin"> 
<style>
div#content{
		height:800px;width:700px;float:left;
		}
</style>
</head>
 <div id="content">
    	<%
    	 ArrayList<Menu> list=new ArrayList<Menu>();
 		list=(ArrayList<Menu>)request.getAttribute("list");
    	if (list==null||list.size()<1){
    	out.print("没有数据！");
    	}else {
    	%> <table frame="all" align="center" border="1">
    	<tr>
    		<td align="center" colspan="4">
    			<h2>已选菜单</h2>
    		</td>
    	</tr>
    	<tr align="center">
    		<td><b>序号</b></td>
    		<td><b>菜名</b></td>
    		<td><b>价格</b></td>
    		<td><b>删除 </b></td>
    	</tr>
    	<%int i=1;
    	for(Menu menu:list){
    	%>
    	<tr align="center">
    		<td>&nbsp;<%=i++%></td>
    		<td>&nbsp;<%String name=menu.getName();%></td>
    		<td>&nbsp;<%Double price=menu.getPrice();%></td>
    	<td><a href="MenuDelete?id=<%=menu.getId()%>">删除</a></td>
    	</tr>
    	<%
    	}
    }
%>
</table>
 <div id="turn">
<form action="User.jsp" method="post"><input type="submit" value="添加"></form>
<form action="FindUser" method="post"><input type="submit" value="刷新"></form>
<a href="homepage.jsp">返回</a>
<a href="login.jsp">退出登录</a>
</div>
</div>