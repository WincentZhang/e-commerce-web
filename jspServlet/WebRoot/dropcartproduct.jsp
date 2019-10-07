<%@page import="java.sql.ResultSet"%>
<%@page import="jspservlet.vo.Product"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="jspservlet.db.DBConnect"%>
<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@page import="jspservlet.vo.User"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'dropcartproduct.jsp' starting page</title>
    
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
    <%User user = (User)session.getAttribute("User"); %>
    welcome   <%= user.getUsername() %>
    <%
	String sql = "select * from shoppingcart where username=?";
        PreparedStatement pstmt = null ;
        DBConnect dbc = null;   
  
        // 下面是针对数据库的具体操作   
        try{    
            dbc = new DBConnect() ;   
            pstmt = dbc.getConnection().prepareStatement(sql) ; 
            pstmt.setString(1,user.getUsername()) ;   
 
            ResultSet rs = pstmt.executeQuery();%>
            
            
            <br>
	<br>
	<table align="center">
		<tr>
			<th>
				<%
					out.print("productID");
				%>
			</th>
			<th>
				<%
					out.print("productName");
				%>
			</th>
			<th>
				<%
					out.print("quality");
				%>
			</th>
			<th>
				<%
					out.print("price");
				%>
			</th>
			<th>
				<%
					out.print("total");
				%>
			</th>
			<th>
				<%
					out.print("add");
				%>
			</th>
			<th>
				<%
					out.print("minus");
				%>
			</th>
			<th>
				<%
					out.print("delete");
				%>
			</th>
		</tr>
 
		<%
			while (rs.next()) {
		%>
		<tr>
			<td>
				<%
					out.print(rs.getString(1));
				%>
			</td>
			<td>
				<%
					out.print(rs.getString(2));
				%>
			</td>
			<td>
				<%
					out.print(rs.getString(3));
				%>
			</td>
			<td>
				<%
					out.print(rs.getString(4));
				%>
			</td>
			<td>
				<%
					out.print(rs.getString(5));
				%>
			</td>
			<td>
				<form method="post" action="./dropcartproduct" > 			
		 		<button type="submit" value="<%=rs.getString(1) %>" name="add">add</button>
		 		 </form>		
			</td>
			<td>
				<form method="post" action="./dropcartproduct" > 			
		 		<button type="submit" value="<%=rs.getString(1) %>" name="minus">minus</button>
		 		 </form>		
			</td>
			<td>
				<form method="post" action="./dropcartproduct" > 			
		 		<button type="submit" value="<%=rs.getString(1) %>" name="drop">drop</button>
		 		 </form>		
			</td>
						
		</tr>
		<%
			}
		%>
	</table>
	<div align="center">
		<br> <br> <br>
            
            
           <%   
            rs.close() ; 
            
            pstmt.close() ;  
        
        }catch (SQLException e){   
            System.out.println(e.getMessage());   
        }finally{   
 
            dbc.close() ;   
        }   
	%>
  </body>
</html>
