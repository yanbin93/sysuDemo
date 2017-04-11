<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.io.*,java.util.*,java.util.List,java.util.regex.*,java.text.DecimalFormat" import="model.*,org.apache.commons.lang.ArrayUtils"%>
<!DOCTYPE html>
<head>
<%
if(session.getAttribute("username")==null||!session.getAttribute("usertype").toString().equals("companyUser")){
	  response.sendRedirect("login.jsp");
	}
String dirname=request.getParameter("dirname");
%>
<meta charset="UTF-8" />
<link rel="stylesheet" type="text/css"
	href="js/jquery/bootstrap/css/bootstrap.min.css" /> 
<script src="js/jquery/bootstrap/jquery/jquery-2.1.1.min.js" ></script>
<script src="js/jquery/bootstrap/js/bootstrap.min.js" > </script>
<script id="jquery_172" type="text/javascript" class="library"
	src="http://sandbox.runjs.cn/js/sandbox/jquery/jquery-1.7.2.min.js"></script>
<script id="bootstrap_221" type="text/javascript" class="library"
	src="http://sandbox.runjs.cn/js/sandbox/bootstrap-2.2.1/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="js/jquery/my.css">
<script type="text/javascript" src="js/jquery/tree2/my.js"></script>
<style>
.divsearch{float:right }
</style>
</head>
<body>
	<div class="container" style="width:100%">
	<!-- div class="container-fluid"-->
<div class="row clearfix" style="BORDER-RIGHT: 3px outset;BORDER-LEFT: 3px outset; BORDER-TOP: 3px outset;  BORDER-BOTTOM: 3px outset;HEIGHT: 100%">
			<div class="col-sm-12 col-md-12 col-lg-12" style="BORDER-LEFT: 3px outset; BRDER-TOP: 3px outset; HEIGHT: 100%">
				<h1 class="text-center">Hadoop溯源系统</h1>
				<p class="text-right"><i class="icon-user"></i><%=" "+ session.getAttribute("username")%>
				 <a href="exit.jsp">退出登录</a>
				 </p>
				 <iframe scrolling='auto' frameborder='0' src="main.html" style='width:100%;height:100%;'></iframe>
				 
			</div>
		</div>
	
					
			
	</div>
</body>
</html>