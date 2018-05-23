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
	  <script type="text/javascript" src="${pageContext.request.contextPath}/jquery-easyui-1.5.5.2/jquery.min.js"></script>  
      <script src="${pageContext.request.contextPath}/bootstrap/3.3.4/js/bootstrap.min.js"></script>
		<script src="${pageContext.request.contextPath}/bootstrap-table/js/bootstrap-table.js"></script>
		<script src="${pageContext.request.contextPath}/bootstrap-table/js/bootstrap-table-zh-CN.js"></script>
    
    <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/3.3.4/css/bootstrap.min.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap-table/css/bootstrap-table.css" />

  </head>
  
  <body>
    <div>
      <input type="date" value="2015-09-24" id="startDate"/>  
      <input type="date" value="2015-09-24" id="endDate"/> 
      <input type="text"  id="gongdan"/>
      <input type="text"  id="liaohao"/>
      <button   id="btnselect">查询</button>
      
    </div>  
    
    <div id="toolbar" class="btn-group">
            <button id="btn_add" type="button" class="btn btn-default">
                <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>新增
            </button>
            <button id="btn_edit" type="button" class="btn btn-default">
                <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>修改
            </button>
            <button id="btn_delete" type="button" class="btn btn-default">
                <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>删除
            </button>
        </div>
  <table  id="jsp_user_tb"></table> 
  <script type="text/javascript">
//根据窗口调整表格高度
  $(window).resize(function() {
      $("#tbevent").bootstrapTable("resetView", {
          height: tableHeight()
      })
  })
  $(function () {
  
 //1.初始化Table
 var oTable = new TableInit();
 oTable.Init();
  
 //2.初始化Button的点击事件
 /* var oButtonInit = new ButtonInit();
 oButtonInit.Init(); */
  
 });
  var TableInit = function () {
	  var oTableInit = new Object();
	  //初始化Table
	  oTableInit.Init = function () {
	     $("#tbevent").bootstrapTable({
	                  //请求方法
	                 method: "get",
	                 toolbar: "#toolbar", //工具按钮用哪个容器
	                  //是否显示行间隔色
	                 striped: true,
	                 //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）     
	                 cache: false,    
	                 //是否显示分页（*）  
	                 pagination: true,   
	                  //是否启用排序  
	                 sortable: false,    
	                  //排序方式 
	                 sortOrder: "asc",    
	                 //初始化加载第一页，默认第一页
	                 //我设置了这一项，但是貌似没起作用，而且我这默认是0,- -
	                 pageNumber:1,   
	                 //每页的记录行数（*）   
	                 pageSize: 10,  
	                 //可供选择的每页的行数（*）    
	                 pageList: [10, 25, 50, 100],
	                  showColumns: true,                  //是否显示所有的列（选择显示的列）
	                 showRefresh: true,                  //是否显示刷新按钮
	                 clickToSelect: true,                //是否启用点击选中行
	                 //这个接口需要处理bootstrap table传递的固定参数,并返回特定格式的json数据  
	                 showToggle: true,                   //是否显示详细视图和列表视图的切换按钮
	                 cardView: false,                    //是否显示详细视图
	                 detailView: false,                  //是否显示父子表
	                 url: "/pm/eventShow_loadEvents.action",
	                 //默认值为 'limit',传给服务端的参数为：(每页数量)limit, (哪一页)offset, search, sort, order Else
	                 //queryParamsType:'',   
	                 ////查询参数,每次调用是会带上这个参数，可自定义      
	                 
	                            
	                 queryParams : function(params) {
	                   var no = $("#gongdan").val();
	                   var name = $("#liaohao").val();
	                     return {
	                           pageNumber: params.offset+1,
	                           pageSize: params.limit,
	                           //companyId:subcompany,
	                           //name:name
	                           userNo:no==null?"":no,
	                           eventType:name=null?0:name
	                         };
	                 },
	         
	                 //分页方式：client客户端分页，server服务端分页（*）
	                 sidePagination: "server",
	                 //是否显示搜索
	                 search: true,  
	                 //Enable the strict search.    
	                 strictSearch: true,
	                 //Indicate which field is an identity field.
	               
	               columns:[{
	 					checkbox: true
	 				}, {
	 					field: "id",
	 					title: "id",
	 					sortable: true
	 				}, {
	 					field: "userNo",
	 					title: "用户名",
	 					sortable: true
	 				}, {
	 					field: "eventType",
	 					title: "类型"
	 				},{
	 					field: "eventDes",
	 					title: "描述"
	 				},
	 				
	 				{
	 				
	                     title: '操作',
	                     width: 120,
	                     align: 'center',
	                     valign: 'middle',
	                     formatter: actionFormatter
	 				}],
	                pagination:true,
	                //双击点击，编辑界面（先获取行信息） 
	               onDblClickRow: function (row) {
	               p.show({
	     //          x:100,  
	     //          y:100  
	               });
	          id=row.id;
	         $("#dia_userNo").attr("value",row.userNo);
	         $("#dia_eventType").attr("value",row.eventType);
	         $("#dia_eventDes").attr("value",row.eventDes);
	         //设置这个按钮的信息 
	         $("#ok").attr("value","保存");
	         $("#ok").attr("name","update");
	         },
	            });
	           };
	            return oTableInit;
	           };
	            //操作栏的格式化
	         function actionFormatter(value, row, index) {
	             var id = value;
	             var result = "";
	             result += "<a href='javascript:;' class='btn btn-xs green' onclick=\"EditViewById('" + id + "', view='view')\" title='查看'><span class='glyphicon glyphicon-search'></span></a>";
	             result += "<a href='javascript:;' class='btn btn-xs blue' onclick=\"EditViewById('" + id + "')\" title='编辑'><span class='glyphicon glyphicon-pencil'></span></a>";
	             result += "<a href='javascript:;' class='btn btn-xs red' onclick=\"DeleteByIds('" + id + "')\" title='删除'><span class='glyphicon glyphicon-remove'></span></a>";

	             return result;
	         }	 
	    
	     $("#btnselect").click(function(){
	    var options = $("#tbevent").bootstrapTable('refresh');
	       
	      
	     });
	       $("#tab11").click(function(){
	       alert("切换");
	       
	      
	     });
	     
	     $("#btn_delete").click(function(){
	     //获取所选行的数组
	    var selects = $("#tbevent").bootstrapTable("getSelections");
	    for(var i=0;i<selects.length;i++){
	    
	     var str=selects[0];
	    
	    }
	    alert(str+"");
	       
	      
	     });
	     
  
  
  
  
  
  
  
  
  
  
  
  
  </script>
    </body>
</html>
