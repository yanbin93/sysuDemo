package model;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ShowOrder {
	public ArrayList<Order> show(String sql,int[]para){
		DBconn conn=new DBconn();
		ResultSet rs=conn.doSelect(sql,para);
		ArrayList<Order> list= new ArrayList<Order>();
			//request.setAttribute("name",rs.getString("name"));
			try {
				
				while(rs.next()){
					Order product=new Order();
				
					product.setName(rs.getString("name"));
					product.setPrice(rs.getDouble("price"));
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