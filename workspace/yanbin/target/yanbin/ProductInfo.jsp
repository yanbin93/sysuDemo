<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  <script src="http://static.runoob.com/assets/jquery-validation-1.14.0/lib/jquery.js"></script>
<script src="http://static.runoob.com/assets/jquery-validation-1.14.0/dist/jquery.validate.min.js"></script>
<script src="http://static.runoob.com/assets/jquery-validation-1.14.0/dist/localization/messages_zh.js"></script>
  </head>
  <body>
	<div id="dlg" style="width:400px;height:200px;padding:10px 20px;algin:center"  >
		<form id="fm" method="post" action="AddProduct">
			<table  align="center" border="1px" cellpadding="1px"
				cellspacing="2px" width="600px" height="50px" background="">
				<tr>
					<td>商品名称：</td>
					<td><input type="text" name="productName" ></td>
				</tr>
				<tr>
					<td>商品货号：</td>
					<td><input type="text" name="productCode"  ></td>
				</tr>
				<tr>
					<td>货品号：</td>
					<td><input type="text" name="productNo" ></td>
				</tr>
				<tr>
					<td>生产批号：</td>
					<td><input type="text" name="productBatch" ></td>
				</tr>
				<tr>
					<td>生产日期：</td>
					<td><input type="text" name="productStart"  ></td>
				</tr>
				<tr>
					<td>过期日期：</td>
					<td><input type="text" name="productEnd" ></td>
				</tr>
				<tr>
					<td valign="top">商品描述：</td>
					<td><textarea rows="7" cols="30" name="description" id="description" ></textarea></td>
				</tr>
			</table>
				<input type="submit" value="添加" >
			</from>
		<from action="FindProcuct" method="post"><input type="submit" value="查找"></form>
	</div>
  </body>
  <a href="homepage.jsp">返回</a>&nbsp;<a href="login.jsp">退出登录</a>
</html>
