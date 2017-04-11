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
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css"
	href="js/jquery/bootstrap/css/bootstrap.min.css" /> 
<script src="js/jquery/bootstrap/jquery/jquery-2.1.1.min.js" ></script>
<script src="js/jquery/bootstrap/js/bootstrap.min.js" > </script>
<link id="bootstrap_221" rel="stylesheet" type="text/css"
	class="library"
	href="http://sandbox.runjs.cn/js/sandbox/bootstrap-2.2.1/css/bootstrap.min.css">
	
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
	<div class="container" >
	<!-- div class="container-fluid"-->
		<div class="row clearfix" >
			<div class="col-md-12 column">
				<h1 class="text-center">Hadoop溯源系统</h1>
				<p class="text-right"><i class="icon-user"></i><%=" "+ session.getAttribute("username")%>
				 <a href="exit.jsp">退出登录</a>
				 </p>
			</div>
		</div>
		<div class="row clearfix" style="BORDER-RIGHT: 3px outset;BORDER-LEFT: 3px outset; BORDER-TOP: 3px outset;  BORDER-BOTTOM: 3px outset;HEIGHT: 100%">
			<div class="col-md-3" style=" BORDER-TOP: 3px outset; HEIGHT: 100%">
				<img alt="1x1" src="lib/fangwei.png" class="img-rounded" width=200px
					height=200px />
				<form method="post" action="#?uploadDir=<%=dirname%>" enctype="multipart/form-data">
					<div class="form-group">
						<label for="exampleInputFile">File input</label>
						 <input name="uploadFile" type="file" />
					</div>
					<button type="submit"
						class="btn btn-lg btn-primary active btn-block">Submit</button>
				</form>
				<ul class="nav nav-tabs nav-stacked">
					<li ><a href="exit.jsp">Common User</a></li>
					<li class="active"><a href="exit.jsp">Company User</a></li>
					<li ><a href="exit.jsp">Adminiatrater</a></li>
					<li class="dropdown pull-right"><a href="#"
						data-toggle="dropdown" class="dropdown-toggle">其他<strong
							class="caret"></strong></a>
						<ul class="dropdown-menu">
							<li><a href="SearchType?type=3">音乐</a></li>
							<li><a href="SearchType?type=4">视频</a></li>
							<li><a href="SearchType?type=5">应用程序</a></li>
						</ul></li>
				</ul>
			</div>

			<div class="col-md-9 " style="BORDER-LEFT: 3px outset; BRDER-TOP: 3px outset; HEIGHT: 100%">
				<nav class="navbar navbar-default" role="navigation">
					<div class="container-fluid">
					<div class="navbar-header">
					<%if (session.getAttribute("username").equals("yanbin")) {
								out.print("<a class=\"navbar-brand\" href=\"FindFile?dirname=/\">前往文件系统</a>");
							}else{
								out.print("<a class=\"navbar-brand\" href=FindFile?dirname=/hadoop>前往文件系统</a>");
							}
					%>
					
					</div>
							<div>
					<form class="navbar-form navbar-right" role="search" action="FindProduct2" method="post">
							<div class="form-group">
								<input class="form-control" name="productId" type="text" />
							</div>
							<button type="submit" class="btn btn-default">Search</button>
									<a href="ProductList">返回</a>
									<a class="navbar-brand" href=demo.html>前往企业管理端</a>
						</form>
          </div>			
				</div>
					
		
					
				</nav>

				<%
			
    	List<Object> list=(List<Object>)request.getAttribute("list");
    	if (list==null||list.size()<1){
    	out.print("<h3>没有数据</h3>");
    	}
    	else {
    	%>
				<table class="table">
					<thead>
						<tr>
						<th>序号</th>
							<th>商品ID</th>
							<th>商品名称</th>
							<th>货品号</th>
							<th>货号</th>
						</tr>
					</thead>
					<tbody>
	<%
		String[] classes={"","success","","warning","","info","","error"};
		String cla;
    	for(int i=0;i<list.size();i++)	
    	{
    		Object object = list.get(i);
    		int[] not= {0,5,6,7,8};
	    	Integer[] is = ArrayUtils.toObject(not);
	    	List<Integer> notIn = Arrays.asList(is);
    		List<String> result=  ListAll.show(object);
    	%>
						<tr class=<%=classes[i%8]%>>
							<td><%=i+1%></td>
<%for (Integer j=0;j<result.size();j++)
{
	if (notIn.contains(j)){continue;}
	%>
	<td><%=result.get(j)%></td>
	<%
}
%>
				</tr>
						<%
					}
    	
					%>
					</tbody>
				</table>
				<%
    	}
				int pageNow=1;
				int pageCount=1;
				int pageSize=1;
				if(request.getAttribute("pageSize")!=null){ pageSize = Integer.parseInt(request.getAttribute("pageSize").toString());}
				if(request.getAttribute("pageNow")!=null){ pageNow = Integer.parseInt(request.getAttribute("pageNow").toString());}
				if(request.getAttribute("pageCount")!=null){ pageCount = Integer.parseInt(request.getAttribute("pageCount").toString());}
				out.println("<ul class=pagination>");
				if (pageNow != 1) {
					out.println("<li><a href=Product?pageNow=" + (pageNow - 1) + ">Prev</a></li>");
				}
				for (int i = 1; i <= pageCount; i++) {
					out.println("<li><a href=ProductList?pageNow=" + i + ">" + i + "</a></li>");
				}
				if (pageNow != pageCount) {
					out.println("<li><a href=ProductList?pageNow=" + (pageNow + 1) + ">Next</a></li>");
				}%>
				<li>共<%=pageSize%>页</li>
				</ul>
				<ul >
				<div>
				<form action="ProductList" method="post">
				<%String s_pageNow="1";
				if(request.getAttribute("s_pageNow")!=null){s_pageNow=request.getAttribute("s_pageNow").toString();}
				%>
						<li><button type="submit" >跳到</button>
				第<input style="width:100px;height:20px" type="text" name="pageNow" value=<%=s_pageNow %>>页</li> 
				
				</form>
				</div>
				</ul>

			</div>
		</div>
	</div>
</body>
</html>