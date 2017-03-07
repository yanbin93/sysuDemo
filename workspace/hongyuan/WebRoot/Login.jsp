<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  
    <title>防伪溯源系统登录</title>
  
  <body >
  
    <div id="main">
    	 	
  		<h1>欢迎使用红园点菜系统！</h1>
  	
		<form action="CheckUser" method="post" >
			<table id="input">
				<tr>
					<td>用户名：</td>
					<td><input type="text" value="" class="inp" name="userName" id="username"/></td>		
				</tr>
				<tr>
					<td>密&nbsp;码：</td>
					<td><input type="password" value="" class="inp" name="pwd" id="password" /></td>
				</tr>
				<tr>
					<td><input type="submit" value="登录"/></td>
					<td><input type="reset" value="重置"  /></td>
				</tr>
			</table>
		</form>
		<span>
			点击<a href="Regist.jsp">此处</a>注册新用户
</span>
	</div>
  </body>
</html>
