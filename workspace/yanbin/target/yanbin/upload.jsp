<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
   <meta charset="utf-8"> 
   <title>Bootstrap 实例 - 嵌套列</title>
   <link rel="stylesheet" href="https://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">  
   <script src="https://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
   <script src="https://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

<form method="post" action="FindFile" enctype="multipart/form-data">
	选择一个文件:
	<input type="file" name="uploadFile" />
	<br/><br/>
	<input type="submit" value="上传" />
</form>
</body>
</html>