package model;
import java.sql.*;
import java.util.*;


import hive.JDBCToHiveUtils;
public class ShowProduct {
	private static Connection conn = JDBCToHiveUtils.getConnnection();
	private static PreparedStatement ps;
	private static ResultSet rs = null;
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


	public ArrayList<Product> hiveQuery(String sql,String[] para) throws Exception{		
	ps =JDBCToHiveUtils.prepare(conn,sql);
	ArrayList<Product> list= new ArrayList<Product>();
	for (int i=1;i<=para.length;i++){
		ps.setString(i, para[i-1]);
	}
		//request.setAttribute("name",rs.getString("name"));
		try {
			rs=ps.executeQuery();
			while(rs.next()){
				Product product=new Product();
				product.setProductId(rs.getInt("productId"));
				product.setProductName(rs.getString("productName"));
				product.setProductNo(rs.getString("ProductNo"));
				product.setProductCode(rs.getString("productCode"));
				//product.setProductBatch(rs.getString("productBatch"));
				//product.setProductStart(rs.getDate("product_start"));
				//product.setProductEnd(rs.getDate("product_end"));
				//product.setDescription(rs.getString("description"));
				list.add(product);
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	}return list;
	}
	
	public ArrayList<Product> hiveQuery(String sql) throws Exception{		
		ps =JDBCToHiveUtils.prepare(conn,sql);
		ArrayList<Product> list= new ArrayList<Product>();
			//request.setAttribute("name",rs.getString("name"));
			try {
				rs=ps.executeQuery();
				while(rs.next()){
					Product product=new Product();
					product.setProductId(rs.getInt("productId"));
					product.setProductName(rs.getString("productName"));
					product.setProductNo(rs.getString("ProductNo"));
					product.setProductCode(rs.getString("productCode"));
					//product.setProductBatch(rs.getString("productBatch"));
					//product.setProductStart(rs.getDate("product_start"));
					//product.setProductEnd(rs.getDate("product_end"));
					//product.setDescription(rs.getString("description"));
					list.add(product);
				}
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}return list;
		}
}