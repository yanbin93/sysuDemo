<%@ page language="java" import="java.util.*" import="model.*" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">  
 	<meta name="Author" content="yanbin"> 
<style>
div#content{
		height:800px;width:800px;
		}
div#bar{
width:800px;
float:left;
}
.img{
	width:200px;
	height:200px;
	float:left;
	}
</style>
<script type="text/javascript">
</script>
</head>
 <div id="content">
 <% ArrayList<Menu> list=new ArrayList<Menu>();
 String username=session.getAttribute("username").toString();
 list=(ArrayList<Menu>)request.getAttribute("list");
if(list==null||list.size()<1){
    	out.print("没有数据！");
    	}else {
    	for(Menu menu:list){
 	String url=menu.getUrl();
 	String name=menu.getName();
 	String description=menu.getDescription();
 	String path=url+name+description;
 	%>
    	<div class="img">
    	<table  align="center" >
    	<tr align="center" width=200px>
    	<a href="ShoppingCl?type=add&id=<%=menu.getId()%>">
    	 <img width=200px height=200px alt="无法加载图片" src=<%=path%>></img> 
    <!-- 	<img width=200px height=200px alt="无法加载图片" src="/images/茶油炒鸡.jpg"></img>-->
    	</a>
    	</tr>
    	<tr align="center" width=200px><%=name%></tr>
    	</table>
    	</div> 	
<%
} 
}
%>

</div>
<div id="bar" >
<%
int pageNow=Integer.parseInt(request.getAttribute("pageNow").toString());
int pageCount=Integer.parseInt(request.getAttribute("pageCount").toString());
if(pageNow!=1){
out.println("<a href=FindMenu?pageNow="+(pageNow-1)+">上一页</a>");
}
//显示超链接
for(int i=1;i<=pageCount;i++){
out.println("<a href=FindMenu?pageNow="+i+">["+i+"]</a>");
}
//下一页
if(pageNow!=pageCount){
out.println("<a href=FindMenu?pageNow="+(pageNow+1)+">下一页</a>");
}
%>
</div>

