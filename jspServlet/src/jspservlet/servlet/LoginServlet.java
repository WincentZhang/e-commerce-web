package jspservlet.servlet;


import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jspservlet.dao.UserDAO;
import jspservlet.dao.impl.UserDAOImpl;
import jspservlet.db.DBConnect;
import jspservlet.vo.User;

public class LoginServlet extends HttpServlet {
	
	 public void doGet(HttpServletRequest req, HttpServletResponse res)
	    throws IOException, ServletException{}

	
	 public void doPost(HttpServletRequest req, HttpServletResponse res)
	    throws IOException, ServletException{
		 User user = new User();
		 user.setUsername(req.getParameter("username"));
		 user.setPassword(req.getParameter("password"));
		 
		 UserDAO dao = new UserDAOImpl();   
	     int flag = 0; 
	     try {
				flag = dao.queryByUsername(user);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		} 
		 if(flag == 1){  
			 String sql = "select * from userinfo where username=?";
		     PreparedStatement pstmt = null ;
		     DBConnect dbc = null;   
			 try{    
		            dbc = new DBConnect() ;   
		            pstmt = dbc.getConnection().prepareStatement(sql) ; 
		            pstmt.setString(1,user.getUsername()) ;    
		            ResultSet rs = pstmt.executeQuery();
		            while(rs.next()){  
		               user.setAddress(rs.getString("address"));
		               user.setPhone(rs.getString("phone"));
		                }  
		            rs.close() ; 
		            pstmt.close() ;    
		        }catch (SQLException e){   
		            System.out.println(e.getMessage());   
		        }finally{   
		            // 关闭数据库连接   
		            dbc.close() ;   
		        }   
		     
			 HttpSession session=req.getSession();   
	         session.setAttribute("User", user); 
	         
	         res.sendRedirect("./welcome.jsp");
	        } else {   
	         res.sendRedirect("./login.jsp");
	        }
	 }
}
	 