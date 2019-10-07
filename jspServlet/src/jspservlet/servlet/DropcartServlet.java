package jspservlet.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jspservlet.dao.UserDAO;
import jspservlet.dao.impl.UserDAOImpl;
import jspservlet.vo.Product;
import jspservlet.vo.User;

public class DropcartServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res)
		    throws IOException, ServletException{}

		
		 public void doPost(HttpServletRequest req, HttpServletResponse res)
		    throws IOException, ServletException{
			 Product product = new Product();
			 
			 HttpSession session=req.getSession();   
	         User user= (User)session.getAttribute("User"); 
			 UserDAO dao = new UserDAOImpl();   
			 
			 
			 
		     try {
		    	 
		    	if (req.getParameter("drop") != null) {
		    		product.setProductID(req.getParameter("drop"));
					dao.dropcartproduct(product, user);
				}else 
				if (req.getParameter("add") != null) {
					product.setProductID(req.getParameter("add"));
					dao.addtocart(product, user);
				}else 
				if (req.getParameter("minus") != null) {
					product.setProductID(req.getParameter("minus"));
					dao.minusnum(product, user);	
					}
				
				
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
			} 
		    
		         res.sendRedirect("./dropcartproduct.jsp");
		       
				
		 }
}

