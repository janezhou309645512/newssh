<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'user.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
	
	<!-- 引入bootstrap table控件-->
	  <script type="text/javascript" src="${pageContext.request.contextPath}/jquery-easyui-1.5.5.2/jquery.min.js"></script>  
      <script src="${pageContext.request.contextPath}/bootstrap/3.3.4/js/bootstrap.min.js"></script>
		<script src="${pageContext.request.contextPath}/bootstrap-table/js/bootstrap-table.js"></script>
		<script src="${pageContext.request.contextPath}/bootstrap-table/js/bootstrap-table-zh-CN.js"></script>
    <script src="https://cdn.bootcss.com/knockout/3.4.0/knockout-min.js"></script>
    <script src="${pageContext.request.contextPath}/knockout/knockout.mapping-latest.js"></script>
    
    <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/3.3.4/css/bootstrap.min.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap-table/css/bootstrap-table.css" />
<!-- bootstrap引入时间控件  -->
 <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/3.3.4/css/bootstrap-datetimepicker.css" />
  <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/3.3.4/css/bootstrap-datetimepicker.min.css" />
 <script src="${pageContext.request.contextPath}/bootstrap/3.3.4/js/bootstrap-datetimepicker.js"></script>
 <script src="${pageContext.request.contextPath}/bootstrap/3.3.4/js/bootstrap-datetimepicker.min.js"></script>
 <script src="${pageContext.request.contextPath}/bootstrap/3.3.4/js/locales/bootstrap-datetimepicker.fr.js"></script>

  
  <!-- 引入EasyUI -->
  <script type="text/javascript" src="${pageContext.request.contextPath}/jquery-easyui-1.5.5.2/jquery.easyui.min.js"></script>
  <!-- 引入EasyUI的中文国际化js，让EasyUI支持中文 -->
  <script type="text/javascript" src="${pageContext.request.contextPath}/jquery-easyui-1.5.5.2/locale/easyui-lang-zh_CN.js"></script>
  <!-- 引入EasyUI的样式文件-->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/jquery-easyui-1.5.5.2/themes/default/easyui.css" type="text/css"/>
  <!-- 引入EasyUI的图标样式文件-->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/jquery-easyui-1.5.5.2/themes/icon.css" type="text/css"/>
 
 <!-- 引入自定义的 -->
 <script src="${pageContext.request.contextPath}/myjs/event.js"></script>
 <link rel="stylesheet" href="${pageContext.request.contextPath}/mycss/event.css" />
  </head>
  
  <body>
   <div class="panel-body" style="padding-bottom:0px;">
        <div class="panel panel-default">
            <div class="panel-heading">查询条件</div>
            <div class="panel-body">
                <form id="formSearch" class="form-horizontal">
                    <div class="form-group" style="margin-top:15px">
                  
                     <label class="control-label col-sm-1" for="txt_search_departmentname">开始日期</label>
                        <div class="col-sm-3">
                            <input id="jsp_event_startDate" type="text" class="easyui-datebox form-control" required="required">
                        
                        </div>
                    
                        
                       
                        <label class="control-label col-sm-1" for="txt_search_departmentname">工号</label>
                        <div class="col-sm-3">
                            <input type="text" class="form-control" id="jsp_event_userNo">
                        </div>
                        
                        <div class="col-sm-4" style="text-align:left;">
                            <button type="button"   id="jsp_event_btnSelect" class="btn btn-primary event_btn">查询</button>
                        </div>
                        
                        <label class="control-label col-sm-1" for="txt_search_departmentname">结束日期</label>
                        <div class="col-sm-3">
                           <input id="jsp_event_endDate" type="text" class="easyui-datebox form-control" required="required">
                        </div>
                        
                        
                        <label class="control-label col-sm-1" for="txt_search_statu">事件类型</label>
                        <div class="col-sm-3">
                            <input type="text" class="form-control"  id="jsp_event_eventType">
                        </div>
                        
                        
                    </div>
                </form>
            </div>
        </div>       
       </div> 
    
    <jsp:include page="eventAdd.jsp"/> 
    
    <div id="toolbar" class="btn-group">
            <button id="event_add" type="button" class="btn btn-default">
                <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>新增
            </button>
            <button id="event_edit" type="button" class="btn btn-default">
                <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>修改
            </button>
            <button id="event_delete" type="button" class="btn btn-default">
                <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>删除
            </button>
        </div>
   <table  id="jsp_event_tb"></table> 
   <script type="text/javascript">
   
 
   
   </script>
   
    </body>
</html>
