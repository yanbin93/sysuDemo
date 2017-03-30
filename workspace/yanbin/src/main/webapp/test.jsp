<%@ page contentType="application/x-download charset=UTF-8" import="java.net.URL ,java.io.*,org.apache.hadoop.fs.*,org.apache.hadoop.conf.Configuration,org.apache.hadoop.io.IOUtils" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
//String filename = request.getParameter("name");

Configuration conf = new Configuration();
FileSystem hdfs = null;
String HADOOP_URL="hdfs://MS-TXY:9002/";
InputStream inputStream = null;  
OutputStream outputStream = null;   
	String filename = "data.txt";
	response.setContentType("application/x-download");
	response.setHeader("Content-Disposition","attachment;filename="+filename);
	outputStream = response.getOutputStream();
	try {
	inputStream = new URL(HADOOP_URL+filename).openStream();
	// process in
	byte[] buffer = new byte[1024];
	int i = -1;
	while ((i = inputStream.read(buffer)) != -1) {
	    outputStream.write(buffer, 0, i);
		
	}
	 out.clear();
     out = pageContext.pushBody();
	} finally {
		outputStream.flush();
		outputStream.close();
		inputStream.close();
	}
	

%>

</body>
</html>

  