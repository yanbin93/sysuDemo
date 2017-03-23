<%@page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
<script src="http://static.runoob.com/assets/jquery-validation-1.14.0/lib/jquery.js"></script>
<script src="http://static.runoob.com/assets/jquery-validation-1.14.0/dist/jquery.validate.min.js"></script>
<script src="http://static.runoob.com/assets/jquery-validation-1.14.0/dist/localization/messages_zh.js"></script>
<script>
$.validator.setDefaults({
    submitHandler: function(form) {
     alert("提交成功")
     form.submit();
    }
});
$().ready(function() {
    $("#userForm").validate();
});	
</script>
  </head>
  <body>
    <form id="userForm" class="cxmform" action="AddUser" method="post">
    
  			<table id="editTable" align="center" border="1px" cellpadding="1px"
				cellspacing="2px" width="600px" height="50px" background="">
				<tr>请输入用户基本信息</tr>
				<tr>
					<td>公司名称</td>
					<td><input id="name" name="name" type="text" minlength="2" required></td>
				</tr>
				<tr>
					<td>地址</td>
					<td><input id="address" name="address" type="text" required></td>
				</tr>
				<tr>
					<td>联系电话</td>
					<td><input id="phone" name="phone" type="text" required></td>
				</tr>
				<tr>
    				<td>邮箱地址:</td>
    				<td><input id="email" name="email" type="email" email required ></td>
    			</tr>
    			<tr algin="center">
    				<td><input  type="submit" value="提交">
  					<input  type="reset" value="重置" >
  					<!--  <a href="homepage.jsp">返回</a>
  					</td>
  					<td><a href="login.jsp">退出登录</a></td>-->
  				</tr>	
  		</table>
  			</form>
  		
  </body>
</html>
