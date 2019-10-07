package jspservlet.servlet;


import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.RepaintManager;

import jspservlet.dao.UserDAO;
import jspservlet.dao.impl.UserDAOImpl;
import jspservlet.vo.User;

public class RegisterServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse res)
		    throws IOException, ServletException{}

		
		public void doPost(HttpServletRequest req, HttpServletResponse res)
		    throws IOException, ServletException{
			 User user = new User();
			 HttpSession session=req.getSession();   
			 user.setUsername(req.getParameter("username"));
			 user.setPhone(req.getParameter("phone"));
			 user.setAddress(req.getParameter("address"));
			 if (req.getParameter("password").equals(req.getParameter("password1"))) {
			 user.setPassword(req.getParameter("password"));			 
			 UserDAO dao = new UserDAOImpl();   
			 int flag=0;
		     try {
					flag=dao.registeruserinfo(user);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
			} 
			     if(flag == 1){   		    	 
		         session.setAttribute("User", user);
		         res.sendRedirect("./welcome.jsp");
		        } else {   
		         res.sendRedirect("./register.jsp");
		        }			 			 			 
			 }else {
				 res.sendRedirect("./register.jsp");
			}			 			 			 	         		    				
		 }	
}
