<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<% 
session.setAttribute("username", request.getAttribute("username"));
String type = request.getAttribute("type").toString();
if (type.equals("demo")) {
	request.getRequestDispatcher("homepage.jsp").forward(request, response);
	session.setAttribute("username", request.getAttribute("usertype"));
	}
else if(type.equals("file")){
	request.getRequestDispatcher("toFileTree.jsp").forward(request, response);
	}
else {
	request.getRequestDispatcher("index.jsp").forward(request, response);
}
%>
</body>
</html>