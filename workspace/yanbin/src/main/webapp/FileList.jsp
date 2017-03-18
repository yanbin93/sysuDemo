<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.io.*,java.util.*"  import="model.File"%>
<!DOCTYPE html>
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css"
	href="js/jquery/bootstrap-2/css/bootstrap.css" />
<link rel="stylesheet" type="text/css"
	href="js/jquery/bootstrap-2/jquery/jquery-2.1.1.min.js" />
<link rel="stylesheet" type="text/css"
	href="js/jquery/bootstrap-2/js/bootstrap.min.js" />
</head>
<body>
	<div class="container">
	<div class="row clearfix">
		<div class="col-md-3 column">
		</div>
		<div class="col-md-9 column">
		<%
    	ArrayList<File> list=(ArrayList<File>)request.getAttribute("list");
    	if (list==null||list.size()<1){
    	out.print("没有数据！");
    	}
    	else {
    	%> 
			<table class="table">
				<thead>
					<tr>
						<th>
							编号
						</th>
						<th>
							名称
						</th>
						<th>
							类型
						</th>
						<th>
							大小
						</th>
					</tr>
				</thead>
				<tbody>
				<%
    	for(File file:list)
    	{
    	%>
					<tr>
						<td>
							1
						</td>
						<td>
						<%=file.getName()%>
						</td>
						<td>
						<%=file.getType()%>
						</td>
						<td>
						<%=Long.toString(file.getSize())+" KB"%>
						</td>
					</tr>
					<%
					}
    	}
					%>
					<!--  <tr class="success">
						<td>
							1
						</td>
						<td>
							TB - Monthly
						</td>
						<td>
							01/04/2012
						</td>
						<td>
							Approved
						</td>
					</tr>
					<tr class="error">
						<td>
							2
						</td>
						<td>
							TB - Monthly
						</td>
						<td>
							02/04/2012
						</td>
						<td>
							Declined
						</td>
					</tr>
					<tr class="warning">
						<td>
							3
						</td>
						<td>
							TB - Monthly
						</td>
						<td>
							03/04/2012
						</td>
						<td>
							Pending
						</td>
					</tr>
					<tr class="info">
						<td>
							4
						</td>
						<td>
							TB - Monthly
						</td>
						<td>
							04/04/2012
						</td>
						<td>
							Call in to confirm
						</td>
					</tr>
					-->
				</tbody>
			</table>
		</div>
	</div>
	</div>
  </body>
</html>