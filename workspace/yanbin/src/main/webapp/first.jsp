<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<!-- 把刚刚的那个header.jsp文件包含进去,里面就有了JqueryEasyUI所需要的文件了 -->
  	<jsp:include page="header.jsp"/>
    <title>JqueryEasyUI的Layout</title>
  </head>
  
  <body>
        <div class="easyui-layout" style="width:600px;height:400px;">  
        <div data-options="region:'north',title:'North Title',split:true" style="height:100px;"></div>  
        <div data-options="region:'south',title:'South Title',split:true" style="height:100px;"></div>  
        <div data-options="region:'east',iconCls:'icon-reload',title:'East',split:true" style="width:100px;"></div>  
        <div data-options="region:'west',title:'West',split:true" style="width:100px;"></div>  
        <div data-options="region:'center',title:'center title'" style="padding:5px;background:#eee;"></div>  
    </div>  
  </body>
</html>