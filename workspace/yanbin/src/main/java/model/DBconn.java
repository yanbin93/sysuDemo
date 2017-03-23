package model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class DBconn {
	public static String driver;//定义驱动
	public static String url;//定义链接URL

	public static String username;//定义数据库用户名
	public static String password;//定义数据库密码
	public static Connection connection;//定义链接
	public static Statement statement;//定义statement
	public static ResultSet result;//定义结果集
	//设置connection
	static{
	driver="com.mysql.jdbc.Driver";
	url="jdbc:mysql://localhost:3306/yanbin";
	username="root";
	password="0000";
	try {
	Class.forName(driver);
	connection=DriverManager.getConnection(url,username,password);
	if(connection!=null){System.out.println("链接成功--------------------------------");}
	} catch (ClassNotFoundException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	}catch(SQLException ex){
	ex.printStackTrace();
	}
	}
    public void doInsert(String sql) {     
        try {     
       statement = connection.createStatement();     
            int i = statement.executeUpdate(sql); 
            System.out.print("成功插入"+i+"组数据！");
        } catch(SQLException sqlexception) {     
            System.err.println("db.executeInset:" + sqlexception.getMessage());     
        }finally{      
        }     
    }     
    public void doDelete(String sql) {     
        try {     
       statement = connection.createStatement();     
            int i = statement.executeUpdate(sql);   
            System.out.print("删除成功！");
        } catch(SQLException sqlexception) {     
            System.err.println("db.executeDelete:" + sqlexception.getMessage());     
        }     
    }     
    public void doUpdate(String sql) {     
        try {     
       statement = connection.createStatement();     
            int i = statement.executeUpdate(sql);     
            System.out.print("更新成功");
        } catch(SQLException sqlexception) {     
        	
            System.err.println("db.executeUpdate:" + sqlexception.getMessage());     
        }     
    }     
    public ResultSet doSelect(String sql,int []parameters) {     
        try {  
            connection=DriverManager.getConnection(url,username,password);  
            statement = connection.createStatement(java.sql.ResultSet.TYPE_SCROLL_INSENSITIVE,java.sql.ResultSet.CONCUR_READ_ONLY);       
            PreparedStatement ps=connection.prepareStatement(sql);
            for(int i=0;i<parameters.length;i++){
				ps.setInt(i+1, parameters[i]);
			};
            result=ps.executeQuery();
            //result = statement.executeQuery(sql);
            System.out.println("取得结果集");  
        } catch(SQLException sqlexception) {     
            System.err.println("db.executeQuery: " + sqlexception.getMessage());     
        }     
        return result;    
        
    }
    
    
    public ResultSet doSelect(String sql) {     
        try {  
            connection=DriverManager.getConnection(url,username,password);  
            statement = connection.createStatement(java.sql.ResultSet.TYPE_SCROLL_INSENSITIVE,java.sql.ResultSet.CONCUR_READ_ONLY);       
            result = statement.executeQuery(sql);
            System.out.println("取得结果集");  
        } catch(SQLException sqlexception) {     
            System.err.println("db.executeQuery: " + sqlexception.getMessage());     
        }     
        return result;     
    }     
    public boolean executeUpdate(String sql,String[] parameters){
		boolean b=false;
		//1.创建一个ps
		try{
			connection=DriverManager.getConnection(url,username,password);  
			PreparedStatement ps=connection.prepareStatement(sql);
			//给？赋值
			if(parameters!=null){
				for(int i=0;i<parameters.length;i++){
					ps.setString(i+1, parameters[i]);
				}
			}
			//执行
			int num=ps.executeUpdate();
			if(num==1){
				b=true;
			}

		}catch(Exception e){
			e.printStackTrace();//开发阶段
			//抛出异常，抛出运行异常，可以给调用该函数的函数一个选择
			//可以处理，也可以放弃处理
			throw new RuntimeException(e.getMessage());
		}
		return b;
}
}
