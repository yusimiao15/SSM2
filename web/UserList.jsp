<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'UserLsist.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <script type="text/javascript" src="js/jquery-1.8.2.min.js"></script>
	<link rel="stylesheet" type="text/css" href="styles.css">
  </head>
  <script type="text/javascript">
  	$(document).ready(function(){
		$("#showBtn").click(function() {
			$.getJSON('<%=path%>/showUserList','',function(rs){
  				for(var i=0;i<rs.length;i++){
  					var li = $("<li></li>");
  					li.html("<a href='${pageContext.request.contextPath}/deleteUser/"
  					+rs[i].id+"/"+rs[i].password+"'>"+rs[i].userName+","+rs[i].identityCode)+"</a>";
  					$("#ul").append(li);
  				}
			});
		});
	});
  </script>
  <body>
    <button id="showBtn">查看用户</button>
    <ul id="ul">
    
    </ul>
  </body>
</html>
