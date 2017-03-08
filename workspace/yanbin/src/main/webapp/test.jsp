    <%@ page language="java" contentType="text/html; charset=UTF-8"  
        pageEncoding="UTF-8"%>  
    <%@ page import="java.sql.*" %>  
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">  
    <html>  
    <head>  
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">  
    <title>Insert title here</title>  
    </head>  
    <body>  
    <%  
    Connection con = null;    
    try {    
        Class.forName("com.mysql.jdbc.Driver");    
        // 其中test是我们要链接的数据库，user是数据库用户名，password是数据库密码。    
        // 3306是mysql的端口号，一般是这个    
        // 后面那串长长的参数是为了防止乱码，免去每次都需要在任何语句都加入一条SET NAMES UTF8    
        String url = "jdbc:mysql://localhost:3306/yanbin";    
        String user = "root";    
        String password = "0000";    
        con = DriverManager.getConnection(url, user, password);    
    } catch (Exception e) {    
        e.printStackTrace();    
    }   
    out.println("数据库链接成功！");  
    %>  
    <form action="TestServlet" method="post">
    <input type="submit" value="登录"/>
    </form>
    <a href="TestServlet">The test servlet</a>
    </body>  
    </html>  