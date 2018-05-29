<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>多文件上传</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<!-- 引入JQuery -->
  <script type="text/javascript" src="${pageContext.request.contextPath}/jquery-easyui-1.5.5.2/jquery.min.js"></script>
  <!-- 引入EasyUI -->
  <script type="text/javascript" src="${pageContext.request.contextPath}/jquery-easyui-1.5.5.2/jquery.easyui.min.js"></script>
  <!-- 引入EasyUI的中文国际化js，让EasyUI支持中文 -->
  <script type="text/javascript" src="${pageContext.request.contextPath}/jquery-easyui-1.5.5.2/locale/easyui-lang-zh_CN.js"></script>
  <!-- 引入EasyUI的样式文件-->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/jquery-easyui-1.5.5.2/themes/default/easyui.css" type="text/css"/>
  <!-- 引入EasyUI的图标样式文件-->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/jquery-easyui-1.5.5.2/themes/icon.css" type="text/css"/>
 <style type="text/css">  
        .img-div{  
            border: 1px solid #ddd;  
            border-radius: 100%;  
            float: left;  
            line-height: 1;  
            margin-left: 5px;  
            overflow: hidden;  
        }  
  
    </style>  
  </head>
  
  <body>
  <h1>文件上传</h1>
  <!-- 
   <form  id='upload' method="post" action="/newssh/upload_uploadFile.action" enctype="multipart/form-data">
    -->
    <form  id='uploadfile' method="post" action="/newssh/multiUpload_multiUploadFile.action" enctype="multipart/form-data">
	<div style="margin:20px 0;"></div>
	<div class="easyui-panel" title="Upload File" style="width:50%;height:100%;padding:30px 70px 50px 70px">
	<!--  
		<div style="margin-bottom:20px">
			<div>Name:</div>
			<input class="easyui-textbox" style="width:100%">
		</div>
		
		<div style="margin-bottom:20px">
			<div>文件1:</div>
			<input class="easyui-filebox" name="file" data-options="prompt:'选择一个文件...'" style="width:100%">
		</div>
		-->
	    <input type="file" id="xdaTanFileImg"  multiple="multiple"  name="upload" onchange="xmTanUploadImg(this)"/>  
    <div class="img-box" id="imgboxid">  
  
    </div>  
  
                      <div id="xmTanDiv"></div><br/>  
                <div id="errordiv"   style="margin-top:15px;width:100%;text-align:center;">  
		<div>
		
		
		
		
			<input type="submit" class="easyui-linkbutton" style="width:100%" value="上传" />
		</div>
	</div>
	
    </form>  
    <script type="text/javascript">
    //选择图片，马上预览  
    function xmTanUploadImg(obj) {  
  
        var fl=obj.files.length;  
        for(var i=0;i<fl;i++){  
            var file=obj.files[i];  
            var reader = new FileReader();  
  
            //读取文件过程方法  
  
            reader.onloadstart = function (e) {  
                console.log("开始读取....");  
            }  
            reader.onprogress = function (e) {  
                console.log("正在读取中....");  
            }  
            reader.onabort = function (e) {  
                console.log("中断读取....");  
            }  
            reader.onerror = function (e) {  
                console.log("读取异常....");  
            }  
            reader.onload = function (e) {  
                console.log("成功读取....");  
  
                var imgstr='<img style="width:100px;height:100px;" src="'+e.target.result+'"/>';  
                var oimgbox=document.getElementById("imgboxid");  
                var ndiv=document.createElement("div");  
  
                ndiv.innerHTML=imgstr;  
                ndiv.className="img-div";  
                oimgbox.appendChild(ndiv);  
                 
            }  
  
            reader.readAsDataURL(file);  

        }  
  
    }  
    
      $('#uploadfile').form({
		success:function(result){
		 var data=$.parseJSON(result); 
                                 var message=data.message;
                                  if (message=="OK"){//提交成功
                                	  $('#upload').form('clear');//提交成功 清除表单数据
                                 
                         				$.messager.show({
                         					title: '提交成功',
                         					msg: message
                         				});	
                         				
                         				
                         			} else {
                         			$.messager.show({
                         					title: '提交失败',
                         					msg: message
                         				});			
                         				}
		
		}
	});
    
    
    
    
    
    
    </script>
    
    
    </body>
    
    
  
  
  
</html>
