<%@ page language="java" import="java.util.*" import="model.*" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">  
 	<meta name="Author" content="yanbin"> 
</head>
 <div id="content">
    	<%
    	ArrayList<AbstractUser> list=(ArrayList<AbstractUser>)request.getAttribute("list");
    	if (list==null||list.size()<1){
    	out.print("没有数据！");
    	}else {
    	%> 
    	<form action="ModUser" method="post">
    	<table frame="all" align="center" border="1">
    	<tr>
    		<td align="center" colspan="7">
    			<h2>用户基本信息</h2>
    		</td>
    	</tr>
    	<tr align="center">
    		<td><b>公司名称</b></td>
    		<td><b>地址</b></td>
    		<td><b>联系电话</b></td>
    		<td><b>邮箱地址</b></td>
    		<td><b>注册时间</b></td>
    		<td><b>有效期至</b></td>
    		<td><b> 删除 </b></td>    		
    	</tr>
    	<%
    	for(AbstractUser user:list){
    		out.print(user);
    	%>
    	<tr align="center">
    		<td>
    		<input type="text" name="name" value="<%=user.getName()%>"/></td>
    		<td><input type="text" name="address" value="<%=user.getAddress()%>"/></td>
    		<td><input type="text" name="phone" value="<%=user.getPhone()%>"/></td>
    		<td><input type="text" name="email" value="<%=user.getEmail()%>"/></td>
    		<td><%=user.getRegisterTime()%></td>
    		<td><%=user.getExpireTime()%></td>
    		<td><a href="UserDelete?id=<%=user.getTenantId()%>">删除</a></td>    		
    		<td><input type="hidden"  name="userid" value="<%=user.getTenantId()%>"/></td>
    		</tr>
    	<%
    	}
    	%>
    	<tr>
    	<td><input type="submit" name="updata" value="确认修改"/></td>
    	</tr>
    <%
    }
%>
</table>
</form>
 <div id="turn">
<form action="User.jsp" method="post"><input type="submit" value="添加"></form>
<form action="FindUser" method="post"><input type="submit" value="刷新"></form>
</div>
<div id=bar>
<%
int pageNow=Integer.parseInt(request.getAttribute("pageNow").toString());
int pageCount=Integer.parseInt(request.getAttribute("pageCount").toString());
if(pageNow!=1){
out.println("<a href=FindUser?pageNow="+(pageNow-1)+">上一页</a>");
}
//显示超链接
for(int i=1;i<=pageCount;i++){
out.println("<a href=FindUser?pageNow="+i+">["+i+"]</a>");
}
//下一页
if(pageNow!=pageCount){
out.println("<a href=FindUser?pageNow="+(pageNow+1)+">下一页</a>");
}
 %>
</div>

</div>