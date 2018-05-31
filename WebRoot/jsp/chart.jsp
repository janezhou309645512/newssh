<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>图形化报表</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
         <meta charset="utf-8"><link rel="icon" href="https://static.jianshukeji.com/highcharts/images/favicon.ico">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <style>
            /* css 代码  */
        </style>
        <script src="https://img.hcharts.cn/highcharts/highcharts.js"></script>
        <script src="https://img.hcharts.cn/highcharts/modules/exporting.js"></script>
        <script src="https://img.hcharts.cn/highcharts-plugins/highcharts-zh_CN.js"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath}/jquery-easyui-1.5.5.2/jquery.min.js"></script>  
  </head>
  
  <body>
      <div id="container" style="min-width:400px;height:400px"></div>
        <script >
        $(function () {
        $.ajax({
		url : 'chart_loadCharts.action',
		type : 'POST',
		dataType : 'json',
		data : {
			userNo:'janezhou'// 新厂
		},
		success : function(data) {
		alert(data);
		var x=data.x;
		var y=data.y;
		
        
        
           var chart = Highcharts.chart('container',{
    chart: {
        type: 'column'
    },
    title: {
        text: '包含负值的柱形图'
    },
    xAxis: {
        categories: ['分切', '模切', '手工', 'ipqc', '包装']
    },
    series: [{
        name: '小张',
        data: [5, 3, 4, 7, 2]
    }]
});
}
});
})
        </script>
    
    
    
  </body>
</html>
