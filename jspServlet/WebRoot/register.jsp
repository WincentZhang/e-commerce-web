<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'register.jsp' starting page</title>
        <meta http-equiv=“Refresh"  />
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
  	<h1>Register</h1>
    <form method="post" action="./register"> 
			username : <input type="text" name="username"/><br/>
			password : <input type="password" name="password"/><br/>
			confirm password : <input type="password" name="password1"/><br/>
			phone:<input type="text" name="phone"/><br/>
			address:<input type="text" name="address"/><br/>
			<input  name="submit" type="SUBMIT" value="Register"> <br/>
			
	</form>
  </body>
</html>
