<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.io.*,java.util.*,java.text.DecimalFormat" import="model.File,model.pathList"%>
<!DOCTYPE html>
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css"
	href="js/jquery/bootstrap/css/bootstrap.min.css" />
<script src="js/jquery/bootstrap/jquery/jquery-2.1.1.min.js" />
<script src="js/jquery/bootstrap/js/bootstrap.min.js" />
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
<%
String dirname = (String)request.getAttribute("dirname");
String[] pathlist=pathList.trans(dirname);
if (dirname.length()>=17){
dirname=dirname.substring(18, dirname.length());
request.setAttribute("dirname",dirname);
}
%>
	<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column">
				<h1 class="text-center">Hadoop云盘系统</h1>
				<h3 class="text-right"><%="Welcome "+ session.getAttribute("username")%>
				 <a href="fileLogin.jsp"">退出登录</a>
				 </h3>
			</div>
		</div>
		<div class="row clearfix">
			<div class="col-md-3">
				<img alt="1x1" src="lib/hadoop.jpg" class="img-rounded" width=200px
					height=200px />
				<form method="post" action="UploadServlet?uploadDir=<%=dirname%>" enctype="multipart/form-data">
					<div class="form-group">
						<label for="exampleInputFile">File input</label> <input
							name="uploadFile" type="file" />
					</div>
					<button type="submit"
						class="btn btn-lg btn-primary active btn-block">Submit</button>
				</form>
				<ul class="nav nav-tabs nav-stacked">
					<li><a href="SearchType?type=0">文本</a></li>
					<li><a href="SearchType?type=1">图片</a></li>
					<li ><a href="SearchType?type=2">压缩文件</a></li>
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

			<div class="col-md-9 ">
				<nav class="navbar navbar-default" role="navigation">
					<div class="navbar-header">
<%
int len=pathlist.length;
%>
						<ul class="breadcrumb">
							<li><a href="FindFile?dirname=/">Home</a></li>
							<%for (int i=0;i<len;i++) {
							String[] tmp = pathlist[i].split("/");	
							out.print("<li><a href=FindFile?dirname="+pathlist[i]+">"+tmp[tmp.length-1]+"</a></li>");
							}
							%>
						</ul>
					</div>
					<div class="collapse navbar-collapse" float="right">

						<form class="navbar-form navbar-left" role="search" action="SearchFile" method="post">
							<div class="form-group">
								<input class="form-control" name="filename" type="text" />
							</div>
							<button type="submit" class="btn btn-default">Search</button>
						</form>
          
					</div>
				</nav>

				<%
			
    	List<File> list=(List<File>)request.getAttribute("list");
    	if (list==null||list.size()<1){
    	out.print("<h3>没有数据</h3>");
    	}
    	else {
    	%>
				<table class="table">
					<thead>
						<tr>
							<th>编号</th>
							<th>名称</th>
							<th>类型</th>
							<th>大小</th>
						</tr>
					</thead>
					<tbody>
						<%
		String[] classes={"error","success","error","warning","error","info"};
		String cla;
    	for(int i=0;i<list.size();i++)
    		
    	{
    		File file = list.get(i);
    		cla=classes[i%6];
    		String[] arr=file.getName().split("/");
    		long tmpsize=file.getSize();
    		DecimalFormat df = new DecimalFormat("0.0");
    		String size=df.format(tmpsize/1024/1024.0)+" MB";
    		if (tmpsize/1024/1024==0){
    			size=(tmpsize/1024)+" KB";
    			if (tmpsize/1024==0){
        			size=(float)tmpsize+" B";
    			}
    		}
    	%>
						<tr class=<%=cla%>>
							<td><%=i+1%></td>

							<%if (file.getType().equals("Dir"))
						{
						%>
							<td><a style='color:blue' href="FindFile?dirname=<%=file.getName()%>"><%=file.getName()%></a>
							</td>
							<%
						}else
						{
							%>
							<td><a style='color:red' href="ReadFile?filename=<%=file.getName()%>"  target="_blank"><%=arr[arr.length-1]%></a></td>
							<% 
					}
%>
							<td><%=file.getType()%></td>
							<td><%=size%></td>
							<td><a style='color:red' href="DeleteFile?dirname=<%=file.getName()%>">删除</a></td>
							<td><a style='color:red' href="Test?filename=<%=file.getName()%>&isDir=<%=file.getType()%>" target="_blank">打开</a></td>
						</tr>
						<%

					}
    	}
					%>
					</tbody>
				</table>
				<%
				int pageNow = Integer.parseInt(request.getAttribute("pageNow").toString());
				int pageCount = Integer.parseInt(request.getAttribute("pageCount").toString());
				out.println("<ul class=pagination>");
				if (pageNow != 1) {
					out.println("<li><a href=FindFile?pageNow=" + (pageNow - 1) + ">Prev</a></li>");
				}
				for (int i = 1; i <= pageCount; i++) {
					out.println("<li><a href=FindFile?pageNow=" + i + ">" + i + "</a></li>");
				}
				if (pageNow != pageCount) {
					out.println("<li><a href=FindFile?pageNow=" + (pageNow + 1) + ">Next</a></li>");
				}
				out.println("</ul>");
			%>
			</div>
		</div>
	</div>
</body>
</html>