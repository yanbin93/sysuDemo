<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%
String type=null;
String tmptype=(String)request.getParameter("type");
if (type!=null){
	type=tmptype;
if (type.equals("file") ){
	out.print( "<meta http-equiv=refresh content=2;url=fileLogin.jsp>");
}else if(type.equals("demo")){
	out.print("<meta http-equiv=refresh content=2;url=login.jsp> ");
	}
}
else {
	out.print("<meta http-equiv=refresh content=2;url=FindFile>");
}

%>

<title>文件处理结果</title>
</head>
<body>
    <center>
        <h2><%=	request.getAttribute("message").toString()%></h2>
    </center>
</body>
</html>