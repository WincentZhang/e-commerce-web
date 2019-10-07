package jspservlet.servlet;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import jspservlet.dao.UserDAO;
import jspservlet.dao.impl.UserDAOImpl;
import jspservlet.vo.Product;
import jspservlet.vo.User;

public class ShoppingServlet extends HttpServlet {
	/**
	 * 
	 */
	public void doGet(HttpServletRequest req, HttpServletResponse res)
		    throws IOException, ServletException{}

		
		 public void doPost(HttpServletRequest req, HttpServletResponse res)
		    throws IOException, ServletException{
			 Product product = new Product();
			 product.setProductID(req.getParameter("button"));
			 
			 HttpSession session=req.getSession();   
	         User user= (User)session.getAttribute("User"); 
	         System.out.println(user.getUsername());
			 UserDAO dao = new UserDAOImpl();   
		
		     try {
				dao.addtocart(product, user);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
			} 
		    
		         res.sendRedirect("./shopping.jsp");
		       
				
		 }
}
