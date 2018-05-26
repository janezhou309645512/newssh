<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'base.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
  </head>
  
  <body>
 <div id="dlg" class="easyui-dialog" style="width:400px;height:280px;padding:10px 20px"
		closed="true" buttons="#dlg-buttons">
	<div class="ftitle">事件提交</div>
	<form id="event_add_fr" method="post">
		<div class="fitem">
			<label>工        号:</label>
			<input name="userNo" class="easyui-validatebox" required="true">
		</div>
		<!--  
		<div class="fitem">
		<label>事件类型:</label>
	<select  class="easyui-combobox" name="eventType" style="width:200px;">
    <option value="aa">1</option>
    <option>2</option>
    <option>3</option>
    <option>4</option>
    <option>5</option>
</select>
        </div>
		-->
		<div class="fitem">
			<label>事件类型:</label>
			<input name="eventType" class="easyui-validatebox" required="true">
		</div>
		<div class="fitem">
			<label>事件描述:</label>
			<input name="eventDes" class="easyui-validatebox" required="true">
		</div>
		
	</form>
</div>
<div id="dlg-buttons">
	<a href="#" class="easyui-linkbutton" iconCls="icon-ok" onclick="saveUser()">Save</a>
	<a href="#" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')">Cancel</a>
</div>
<script type="text/javascript">
  function saveUser(){
	$('#event_add_fr').form('submit',{
		url: "/newssh/eventHandle_addEvent.action",
		onSubmit: function(){
			return $(this).form('validate');
			
		},
		success: function(result){
		
		
		 //var data = eval('(' + result + ')'); // change the JSON string to javascript object
       
		     //解析json
		 var data=$.parseJSON(result); 
        var message=data.message;
         alert(message);
      
			if (message=="OK"){//提交成功，清零
			 $('#event_add_fr').form('clear');
				
			} else {
			$.messager.show({
					title: 'Error',
					msg: message
				});			
				}
		
		
	},
	
});
}  

</script>
  </body>
</html>
