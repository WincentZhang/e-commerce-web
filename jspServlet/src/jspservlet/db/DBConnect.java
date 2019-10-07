package jspservlet.db;


import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {  
	    private final String DBDRIVER = "com.mysql.cj.jdbc.Driver" ;   
	    private final String DBURL = "jdbc:mysql://127.0.0.1:3306/javawebdb1?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=GMT" ;   
	    private final String DBUSER = "root" ;   
	    private final String DBPASSWORD = "13696033418zhang" ;   
	    private Connection conn = null ;   
	  
	    public DBConnect()   {   
	        try{   
	            Class.forName(DBDRIVER) ;   
	            this.conn = DriverManager.getConnection(DBURL,DBUSER,DBPASSWORD) ;  
	        }catch (Exception e){ 
	        	System.out.println(e.getMessage());  
	        	}   
	    }   
	  
	    // 取得数据库连接   
	    public Connection getConnection(){   
	        return this.conn ;   
	    }   
	  
	    // 关闭数据库连接   
	    public void close(){   
	        try{   
	            this.conn.close() ;   
	        }catch (Exception e){ }          
	    }   
}  
