<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>文件内容</title>
</head>
<body>
    <center>
        <h2><%=	request.getAttribute("content").toString()%></h2>
    </center>
    <a href="FindFile">返回</a>
</body>
</html>