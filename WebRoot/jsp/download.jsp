<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'download.jsp' starting page</title>
    
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
     <h1>通过链接下载文件</h1>  
    <a href="http://192.168.66.26/pcc/PCC_630-ALB678-B_D.pdf">pcc</a>  
    <a href="http://192.168.66.26/3.8/screen.txt">文本</a>  
    <h1>通过servlet程序下载文件</h1>  
    <a href="${pageContext.request.contextPath}/images/logo.png">图片</a>  
    <a href="${pageContext.request.contextPath}/privatefile/hql.txt">文件</a>  
  </body>
</html>
