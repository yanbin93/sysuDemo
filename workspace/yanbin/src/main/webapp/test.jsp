<%@ page language="java" contentType="text/html; charset=UTF-8"  
    pageEncoding="UTF-8"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">  

<html>  
<head>  
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">  
<title>Insert title here</title>  
<link rel="stylesheet" type="text/css" href="js/jquery/easyui/themes/default/easyui.css">  
<link rel="stylesheet" type="text/css" href="js/jquery/easyui/themes/icon.css">  
<script type="text/javascript" src="js/jquery/easyui/jquery.min.js"></script>  
<script type="text/javascript" src="js/jquery/easyui/jquery.easyui.min.js"></script>  
<script>
		var url;
		function deleteUser(){
			var row=$('#dg').datagrid('getSelected');
			if(row){
				$.messager.confirm("系统提示","您确定要删除这条记录吗?",function(r){
					if(r){
						$.post('userDelete',{id:row.id},function(result){
							if(result.success){
								$.messager.alert("系统提示","已成功删除这条记录!");
								$("#dg").datagrid("reload");
							}else{
								$.messager.alert("系统提示",result.errorMsg);
							}
						},'json');
					}
				});
			}
		}
		
		function newUser(){
			$("#dlg").dialog('open').dialog('setTitle','添加用户');
			$('#fm').form('clear');
			url='userSave';
		}
		
		
		function editUser(){
			var row=$('#dg').datagrid('getSelected');
			if(row){
				$("#dlg").dialog('open').dialog('setTitle','编辑用户');
				$('#fm').form('load',row);
				url='userSave?id='+row.id;
			}
		}
		
		
		function saveUser(){
			$('#fm').form('submit',{
				url:url,
				onSubmit:function(){
					return $(this).form('validate');
				},
				success:function(result){
					var result=eval('('+result+')');
					if(result.errorMsg){
						$.messager.alert("系统提示",result.errorMsg);
						return;
					}else{
						$.messager.alert("系统提示","保存成功");
						$('#dlg').dialog('close');
						$("#dg").datagrid("reload");
					}
				}
			});
		}
		
	</script>
</head>  
    <body class="easyui-layout">  
         
      <!-- 正上方panel -->  
        
        <div region="north" style="height:100px;padding:10px;" href="root/Web/common/page/top.html"></div>   
        <div region="west" title="菜单栏" split="true" style="width:280px;padding1:1px;overflow:hidden;">  
            <div class="easyui-accordion" fit="true" border="false">  
                <div title="用户权限管理" selected="true">  
                <ul>  
                    <li><a href="javascript:addTab('tabId_loginInfo','用户管理','/root/ospm/loginInfo/goLoginInfoMain.jhtml');">用户管理</a></li>  
                    <li><a href="javascript:addTab('tabId_privilege','权限管理','root/ospm/loginInfo/goPrivilegeMain.jhtml');">权限管理</a></li>  
                </ul>  
                </div>  
            </div>  
        </div>  
  
        <!-- 正中间panel-->
        <div region="center" title="功能区" >  
            <div class="easyui-tabs" id="centerTab" fit="true" border="false">  
                <div title="欢迎页" style="padding:20px;overflow:hidden;">   
                    <div style="margin-top:20px;">  
                        <h3>你好，欢迎来到权限管理系统</h3>  
                          <div>
                          <table id="dg" title="用户管理" class="easyui-datagrid" style="width:700px;height:365px"
            url="userList"
            toolbar="#toolbar" pagination="true"
            rownumbers="true" fitColumns="true" singleSelect="true">
        <thead>
            <tr>
            	<th field="id" width="50" hidden="true">编号</th>
                <th field="name" width="50">姓名</th>
                <th field="phone" width="50">电话</th>
                <th field="email" width="50">Email</th>
                <th field="qq" width="50">QQ</th>
            </tr>
        </thead>
    </table>
    <div id="toolbar">
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newUser()">添加用户</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editUser()">编辑用户</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="deleteUser()">删除用户</a>
    </div>
	
	<div id="dlg" class="easyui-dialog" style="width:400px;height:250px;padding:10px 20px"
            closed="true" buttons="#dlg-buttons">
        <form id="fm" method="post">
        	<table cellspacing="10px;">
        		<tr>
        			<td>姓名：</td>
        			<td><input name="name" class="easyui-validatebox" required="true" style="width: 200px;"></td>
        		</tr>
        		<tr>
        			<td>联系电话：</td>
        			<td><input name="phone" class="easyui-validatebox" required="true" style="width: 200px;"></td>
        		</tr>
        		<tr>
        			<td>Email：</td>
        			<td><input name="email" class="easyui-validatebox" validType="email" required="true" style="width: 200px;"></td>
        		</tr>
        		<tr>
        			<td>QQ：</td>
        			<td><input name="qq" class="easyui-validatebox" required="true" style="width: 200px;"></td>
        		</tr>
        	</table>
        </form>
	</div>
    
	<div id="dlg-buttons">
		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok" onclick="saveUser()">保存</a>
		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')">关闭</a>
	</div>
         <table id="dg"></table></div>
                    </div>  
        
                </div>  
            </div> 
            
        </div>  
        <!-- 正下方panel -->  
      
    </body>  
</html>