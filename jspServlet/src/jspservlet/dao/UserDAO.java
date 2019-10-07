package jspservlet.dao;

import jspservlet.vo.Product;
import jspservlet.vo.User;

public interface UserDAO {	
	public int queryByUsername(User user) throws Exception;
	public int registeruserinfo(User user) throws Exception ;
	public void addtocart(Product product,User user) throws Exception ;
	public void dropcartproduct(Product product,User user) throws Exception;
	public void minusnum(Product product,User user) throws Exception;
	public void modifyuserinfo(User user) throws Exception ;
	
}
