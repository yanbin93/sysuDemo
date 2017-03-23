package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
public class ShowUser {
	
	public ArrayList<AbstractUser> show(String sql,int[]para){
	DBconn conn=new DBconn();
	ResultSet rs=conn.doSelect(sql,para);
	ArrayList<AbstractUser> list= new ArrayList<AbstractUser>();
		//request.setAttribute("name",rs.getString("name"));
		try {
			while(rs.next()){
				AbstractUser user=new AbstractUser();
				user.setTenantId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setAddress(rs.getString("address"));
				user.setPhone(rs.getString("phone"));
				user.setEmail(rs.getString("email"));
				user.setRegisterTime(rs.getDate("register_time"));
				user.setExpireTime(rs.getDate("expire_time"));
				list.add(user);
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	}return list;
}
	public ArrayList<AbstractUser> show(String sql){
	DBconn conn=new DBconn();
	ResultSet rs=conn.doSelect(sql);
	ArrayList<AbstractUser> list= new ArrayList<AbstractUser>();
		//request.setAttribute("name",rs.getString("name"));
		try {
			while(rs.next()){
				AbstractUser user=new AbstractUser();
				user.setTenantId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setAddress(rs.getString("address"));
				user.setPhone(rs.getString("phone"));
				user.setEmail(rs.getString("email"));
				user.setRegisterTime(rs.getDate("register_time"));
				user.setExpireTime(rs.getDate("expire_time"));
				list.add(user);
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	}return list;
	}
}