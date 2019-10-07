<%@page import="jspservlet.vo.User"%>
<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'shopping.jsp' starting page</title>
   
  </head>

  <body>
    <%User user = (User)session.getAttribute("User"); %>
    welcome   <%= user.getUsername() %>
	 <form method="post" action="./shopping" > 			
		 <button type="submit" value="3" name="button">add to cart</button>				
	 </form>
	 <form method="post" action="./shopping" > 			
		 <button type="submit" value="4" name="button">add to cart</button>				
	 </form>
	 <form method="post" action="./shopping" > 			
		 <button type="submit" value="5" name="button">add to cart</button>				
	 </form>
	 <a href="dropcartproduct.jsp">go to cart </a>
</body>
</html>
