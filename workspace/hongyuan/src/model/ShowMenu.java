package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ShowMenu {
	public ArrayList<Menu> show(String sql,int[]para){
		DBconn conn=new DBconn();
		ResultSet rs=conn.doSelect(sql,para);
		ArrayList<Menu> list= new ArrayList<Menu>();
			//request.setAttribute("name",rs.getString("name"));
			try {
				
				while(rs.next()){
					Menu product=new Menu();
					product.setId(rs.getInt("id"));
					product.setName(rs.getString("name"));
					product.setUrl(rs.getString("url"));
					product.setDescription(rs.getString("description"));
					list.add(product);
				}
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return list;
	}
	
	
	
	
	
	
}
