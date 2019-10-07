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

public class ModifyServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res)
		    throws IOException, ServletException{}

		
		 public void doPost(HttpServletRequest req, HttpServletResponse res)
		    throws IOException, ServletException{
			 
			 HttpSession session=req.getSession();   			 
			 User user=(User)session.getAttribute("User");
			 user.setUsername(req.getParameter("username"));
			 user.setPhone(req.getParameter("phone"));
			 user.setAddress(req.getParameter("address"));
			 if (req.getParameter("password").equals(req.getParameter("password1"))) {
			 user.setPassword(req.getParameter("password"));
			 
			 UserDAO dao = new UserDAOImpl();   

		     try {
					dao.modifyuserinfo(user);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
			}  
		         session.setAttribute("User", user);
		         res.sendRedirect("./welcome.jsp");
		        } else {   
		         res.sendRedirect("./modify.jsp");
		        }
			 
			 
			 
				
		 }
}
