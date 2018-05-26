//根据窗口调整表格高度
   $(window).resize(function() {
      $("#jsp_event_tb").bootstrapTable("resetView", {
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
	     $("#jsp_event_tb").bootstrapTable({
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
	                 url: "/newssh/eventShow_loadEvents.action",
	                 //默认值为 'limit',传给服务端的参数为：(每页数量)limit, (哪一页)offset, search, sort, order Else
	                 //queryParamsType:'',   
	                 ////查询参数,每次调用是会带上这个参数，可自定义      
	                 
	                            
	                 queryParams : function(params) {
	                  // var no = $("#gongdan").val();
	                   //var name = $("#liaohao").val();
	                     return {
	                           pageNumber: params.offset,
	                           pageSize: params.limit
	                           
	                           //name:name
	                           //userNo:no==null?"":no,
	                           //eventType:name=null?0:name
	                         };
	                 },
	         
	                 //分页方式：client客户端分页，server服务端分页（*）
	                 sidePagination: "server",
	                 //是否显示搜索
	                 search: false,  
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
	 					field: "eventTime",
	 					title: "时间"
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
	    var options = $("#jsp_event_tb").bootstrapTable('refresh');
	       });
	  
	    
	   
	      
	 //有关增删查改的操作
$(function() {
    //初始化
    operate.operateInit();
});
// 操作
var operate = {
    // 初始化按钮事件
    operateInit : function() {
        this.operateAdd();
        this.operateUpdate();
        this.operateDelete();
        this.DepartmentModel = {
             //和标签中的data-bind  对应
            userNo : ko.observable(),
            eventType : ko.observable(),
            eventDes : ko.observable()
        };
    },
    // 新增
    operateAdd : function() {
        $('#event_add').on(
                "click",
                function() {
                    $("#myModal").modal().on(
                            "shown.bs.modal",
                            function() {
                                var oEmptyModel = {
                                
                                    userNo : ko.observable(),
                                    eventType : ko.observable(),
                                    eventDes : ko.observable()
                                  
                                };
                                ko.utils.extend(operate.DepartmentModel,
                                        oEmptyModel);
                                ko.applyBindings(operate.DepartmentModel,
                                        document.getElementById("myModal"));
                                operate.operateSave();
                            }).on('hidden.bs.modal', function() {
                        ko.cleanNode(document.getElementById("myModal"));
                    });
                });
    },
    // 编辑  修改这里我没有做  如果需要的话  把弹出页面中input中的data-bind中value:name 换成value:你后台传来的变量名称                  
    operateUpdate : function() {
        $('#event_edit').on(
                "click",
                function() {
                    $("#myModal").modal().on(
                            "shown.bs.modal",
                            function() {
                                var arrselectedData = tableInit.myViewModel
                                        .getSelections();
                                if (!operate.operateCheck(arrselectedData)) {
                                    return;
                                }
                                // 将选中该行数据有数据Model通过Mapping组件转换为viewmodel
                                ko.utils.extend(operate.DepartmentModel,
                                        ko.mapping.fromJS(arrselectedData[0]));
                                ko.applyBindings(operate.DepartmentModel,
                                        document.getElementById("myModal"));
                                operate.operateSave();
                            }).on('hidden.bs.modal', function() {
                        // 关闭弹出框的时候清除绑定(这个清空包括清空绑定和清空注册事件)
                        ko.cleanNode(document.getElementById("myModal"));
                    });
                });
    },
    // 删除
    operateDelete : function() {  //当点击删除的时候  会进入这个方法
        $('#event_delete').on(
                "click",
                function() {
                    var arrselectedData = $("#jsp_event_tb").bootstrapTable(
                            'getSelections');
                    if (arrselectedData.length <= 0) {
                        alert("请选中一行");
                    } else {
                        var b = JSON.stringify(arrselectedData);
                        $.ajax({
                            url : "/newssh/eventHandle_deleteEvent.action",
                            type : "post",
                            data : {
                                "id" : b  //传输到后台的是 json对象 后台接收后需要转换成list  然后循环获取id删除
                            },
                            success : function(status) {
                                alert(status);
                                $("#jsp_event_tb").bootstrapTable('refresh');
                            }
                        });
                    }
                });
    },
    // 保存数据
    operateSave : function() {  //当点击保存的时候回跳到这个方法
        $('#event_submit').on("click", function() {
            // 取到当前的viewmodel
            var oViewModel = operate.DepartmentModel;
            // 将Viewmodel转换为数据model
            var oDataModel = ko.toJS(oViewModel);
            if (oDataModel.userNo == undefined || oDataModel.userNo.trim() == "") {
                alert("类目不能为空");
            } else {
               
                $.ajax({
                    url : "/newssh/eventHandle_addEvent.action",  //url
                    type : "post",
                    data : {   //参数
                        "userNo" : oDataModel.userNo,
                        "eventType" :oDataModel.eventType,
                        "eventDes" :oDataModel.eventDes
                    },
                    success : function(result) {
                    	 var data=$.parseJSON(result); 
                         var message=data.message;
                          if (message=="OK"){//提交成功，清零
                        	  
                             $("#jsp_event_tb").bootstrapTable('refresh');
                 				$.messager.show({
                 					title: '添加成功',
                 					msg: message
                 				});	
                 				
                 			} else {
                 			$.messager.show({
                 					title: 'Error',
                 					msg: message
                 				});			
                 				}
                 		
                       
                      
                    }
                });
            }
        });
    },
    // 数据校验
    operateCheck : function(arr) {
        if (arr.length <= 0) {
            alert("请至少选择一行数据");
            return false;
        }
        if (arr.length > 1) {
            alert("只能编辑一行数据");
            return false;
        }
        return true;
    }
}
