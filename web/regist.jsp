<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
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
    <form action="<%=path %>/reg.action" method="post">
    	账户:<input type="text" name="userName" />
    	密码:<input type="password" name="userPwd" />
    	年龄:<input type="text" name="userAge" />
    	爱好:<input type="checkbox" name="userLike" value="游泳" />游泳
    	<input type="checkbox" name="userLike" value="篮球" />篮球
    	<input type="checkbox" name="userLike" value="游戏" />游戏
    	<input type="submit" value="登录" />
    </form>
  </body>
</html>
