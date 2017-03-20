package model;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
public class ShowProduct {
	
	public ArrayList<Product> show(String sql,int[]para){
	DBconn conn=new DBconn();
	ResultSet rs=conn.doSelect(sql,para);
	ArrayList<Product> list= new ArrayList<Product>();
		//request.setAttribute("name",rs.getString("name"));
		try {
			while(rs.next()){
				Product product=new Product();
				product.setProductId(rs.getInt("product_id"));
				product.setProductName(rs.getString("name"));
				product.setProductNo(rs.getString("factory_id"));
				product.setProductBatch(rs.getString("product_batch"));
				product.setProductStart(rs.getDate("product_start"));
				product.setProductEnd(rs.getDate("product_end"));
				product.setDescription(rs.getString("description"));
				list.add(product);
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	}return list;
}
	public ArrayList<Product> show(String sql){
	DBconn conn=new DBconn();
	ResultSet rs=conn.doSelect(sql);
	ArrayList<Product> list= new ArrayList<Product>();
		//request.setAttribute("name",rs.getString("name"));
		try {
			while(rs.next()){
				Product product=new Product();
				product.setProductId(rs.getInt("product_id"));
				product.setProductName(rs.getString("name"));
				product.setProductNo(rs.getString("factory_id"));
				product.setProductBatch(rs.getString("product_batch"));
				product.setProductStart(rs.getDate("product_start"));
				product.setProductEnd(rs.getDate("product_end"));
				product.setDescription(rs.getString("description"));
				list.add(product);
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	}return list;
	}
}