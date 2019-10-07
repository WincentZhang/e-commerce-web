<%@ page language="java" pageEncoding="GB18030"%>
 
<html> 
	<head>
		<title>JSP for UserForm form</title>
		
	</head>
	<body>
		<form method="post" action="./login"> 
			username : <input type="text" name="username"/><br/>
			password : <input type="password" name="password"/><br/>
			<input  name="submit" type="SUBMIT" value="Login"> <br/>
			<a href="register.jsp" target="_self">register</a>
		</form>
	</body>
</html>

