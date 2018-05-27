<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title></title>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
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
  <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span></button>
                        <h4 class="modal-title" id="myModalLabel">事件提交</h4>
                    </div>
                    <div class="modal-body">
 
                        <div class="form-group">
                            <label for="txt_departmentname">用户名</label>
                            <input type="text" name="txt_departmentname" data-bind="value:userNo" class="form-control" id="txt_departmentname" placeholder="类目名称">
                        </div>
                          <div class="form-group">
                            <label for="txt_departmentname">事件类型</label>
                            <input type="text" name="txt_departmentname" data-bind="value:eventType" class="form-control" id="txt_departmentname" placeholder="类目名称">
                        </div>
                          <div class="form-group">
                            <label for="txt_departmentname">事件描述</label>
                            <input type="text" name="txt_departmentname" data-bind="value:eventDes" class="form-control" id="txt_departmentname" placeholder="类目名称">
                        </div>
                        
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span>关闭</button>
                        <button type="button" id="event_submit" class="btn btn-primary" name="addEvent" data-dismiss="modal"><span class="glyphicon glyphicon-floppy-disk" aria-hidden="true"></span>添加</button>
                    </div>
                </div>
            </div>
        </div>
        </div>
     
    

  </body>
</html>
