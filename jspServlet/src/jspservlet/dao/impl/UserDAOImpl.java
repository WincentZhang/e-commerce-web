package jspservlet.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import jspservlet.dao.UserDAO;
import jspservlet.db.DBConnect;
import jspservlet.vo.Product;
import jspservlet.vo.User;


public class UserDAOImpl implements UserDAO {

	
	public int queryByUsername(User user) throws Exception {
		// TODO Auto-generated method stub
		int flag = 0;
		String sql = "select * from userinfo where username=?";
        PreparedStatement pstmt = null ;
        DBConnect dbc = null;   
  
        // 下面是针对数据库的具体操作   
        try{   
            // 连接数据库   
            dbc = new DBConnect() ;   
            pstmt = dbc.getConnection().prepareStatement(sql) ; 
            pstmt.setString(1,user.getUsername()) ;   
    
            // 进行数据库查询操作   
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){  
                // 查询出内容，之后将查询出的内容赋值给person对象   
                if(rs.getString("password").equals(user.getPassword())){
                	flag = 1;
                } 
            }   
            rs.close() ; 
            
            pstmt.close() ;  
        
        }catch (SQLException e){   
            System.out.println(e.getMessage());   
        }finally{   
            // 关闭数据库连接   
            dbc.close() ;   
        }   
        
		return flag;
	}
	
	public int registeruserinfo(User user) {
		String sql = "insert into userinfo values(?,?,?,?)";
		String sql1 = "select * from userinfo where username=?";
        PreparedStatement pstmt = null ;
        DBConnect dbc = null;   
        int flag=1;
        // 下面是针对数据库的具体操作   
        try{   
            // 连接数据库   
            dbc = new DBConnect() ;  
            pstmt = dbc.getConnection().prepareStatement(sql1) ; 
            pstmt.setString(1,user.getUsername()) ; 
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){                  
                	flag = 0;              
            }   
            rs.close() ;
            
            if (flag==1) {
            pstmt = dbc.getConnection().prepareStatement(sql) ; 
            pstmt.setString(1,user.getUsername()) ;   
            pstmt.setString(2,user.getPassword()) ;
            pstmt.setString(3,user.getPhone()) ;
            pstmt.setString(4,user.getAddress()) ;
            // 进行数据库查询操作   
            pstmt.execute();
            
            }
            pstmt.close() ;  
        
        }catch (SQLException e){   
            System.out.println(e.getMessage());   
        }finally{   
            // 关闭数据库连接   
            dbc.close() ;   
        }   
        return flag;
	}

	public void addtocart(Product product,User user) throws Exception {
		String sql = "insert into shoppingcart values(?,?,?,?,?,?)";
		String sql1 = "select * from product where productID=?";
		String sql2="select * from shoppingcart where productID=? and username=?";
		String sql3="update shoppingcart set num=num+1 , total=price*num where productID=? ";

        PreparedStatement pstmt = null ;
        DBConnect dbc = null;   
        // 下面是针对数据库的具体操作   
        try{   
            // 连接数据库   
            dbc = new DBConnect() ;  
            pstmt = dbc.getConnection().prepareStatement(sql1) ; 
            pstmt.setString(1,product.getProductID()) ; 
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){                  
            product.setPrice(rs.getDouble(3));
            product.setProductName(rs.getString(2));
            product.setUsername(user.getUsername());
            product.setTotal(product.getPrice()*product.getNum());
            }
            pstmt = dbc.getConnection().prepareStatement(sql2) ; 
            pstmt.setString(1,product.getProductID()) ; 
            pstmt.setString(2,user.getUsername()) ; 
            rs = pstmt.executeQuery();
            if (!rs.next()) {
            	pstmt = dbc.getConnection().prepareStatement(sql) ; 
                pstmt.setString(1,product.getProductID()) ;
                pstmt.setString(2,product.getProductName()) ;
                pstmt.setInt(3,product.getNum()) ;
                pstmt.setDouble(4,product.getPrice()) ;
                pstmt.setDouble(5,product.getTotal()) ;
                pstmt.setString(6,product.getUsername()) ;
                pstmt.execute();
			}else {
				pstmt = dbc.getConnection().prepareStatement(sql3) ; 
                pstmt.setString(1,product.getProductID()) ;
                pstmt.executeUpdate();
			}
            rs.close() ;            
            pstmt.close() ;  
        
        }catch (SQLException e){   
            System.out.println(e.getMessage());   
        }finally{   
            // 关闭数据库连接   
            dbc.close() ;   
        }   
		
	}

	public void dropcartproduct(Product product, User user) throws Exception {
		
		String sql=" delete from shoppingcart where productID=? and username=?";		
        PreparedStatement pstmt = null ;
        DBConnect dbc = null;   
        try{    
            dbc = new DBConnect() ;                  
            pstmt = dbc.getConnection().prepareStatement(sql) ; 
            pstmt.setString(1,product.getProductID()) ; 
            pstmt.setString(2,user.getUsername()) ; 
            pstmt.execute();
            pstmt.close() ;         
        }catch (SQLException e){   
            System.out.println(e.getMessage());   
        }finally{   
            // 关闭数据库连接   
            dbc.close() ;   
        }   			
	}

	

	public void minusnum(Product product, User user) throws Exception {
		String sql=" update shoppingcart set num=num-1,total=num*price where productID=? and username=?";
		String sql2="select * from shoppingcart where productID=? and username=?";
        PreparedStatement pstmt = null ;
        DBConnect dbc = null;   
        try{    
            dbc = new DBConnect() ; 
            pstmt = dbc.getConnection().prepareStatement(sql2) ; 
            pstmt.setString(1,product.getProductID()) ; 
            pstmt.setString(2,user.getUsername()) ; 
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()&&rs.getInt(3)>1) {						
            pstmt = dbc.getConnection().prepareStatement(sql) ; 
            pstmt.setString(1,product.getProductID()) ; 
            pstmt.setString(2,user.getUsername()) ; 
            pstmt.execute();
            pstmt.close() ;   
            }      
        }catch (SQLException e){   
            System.out.println(e.getMessage());   
        }finally{   
            // 关闭数据库连接   
            dbc.close() ;   
        }   			
		
	}

	public void modifyuserinfo(User user) throws Exception {
		String sql = "update userinfo set password=?,phone=?,address=? where username=?";
        PreparedStatement pstmt = null ;
        DBConnect dbc = null;   
     
        try{        
            
        	dbc=new DBConnect();
            pstmt = dbc.getConnection().prepareStatement(sql) ; 
            pstmt.setString(1,user.getPassword()) ;
            pstmt.setString(2,user.getPhone()) ;
            pstmt.setString(3,user.getAddress()) ;
            pstmt.setString(4,user.getUsername()) ;
            // 进行数据库查询操作   
            pstmt.executeUpdate();   
            pstmt.close() ;  
        
        }catch (SQLException e){   
            System.out.println(e.getMessage());   
        }finally{   
            // 关闭数据库连接   
            dbc.close() ;   
        }   
       
	}	
}
