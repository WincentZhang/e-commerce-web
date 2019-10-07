package jspservlet.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jspservlet.dao.UserDAO;
import jspservlet.dao.impl.UserDAOImpl;
import jspservlet.vo.User;

public class LogoutServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res)
		    throws IOException, ServletException{}

		
		 public void doPost(HttpServletRequest req, HttpServletResponse res)
		    throws IOException, ServletException{
			 
			 HttpSession session=req.getSession();   
			 session.removeAttribute("user");
		     
		         res.sendRedirect("./login.jsp");
		       
		 }
}
