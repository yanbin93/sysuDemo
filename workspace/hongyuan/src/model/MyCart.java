package model;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import model.*;;
//这个表示我的购物车
public class MyCart {
	HashMap<String ,Menu> hm=new HashMap<String ,Menu>();	
	//添加书
	public void addMenu(String id){
		if(hm.containsKey(id)){
			Menu book=hm.get(id);
			//如果该书已经购买过，shoppingNum数量+1
			int shoppingNum=book.getShoppingNum();
			book.setShoppingNum(shoppingNum+1);
			
		}else{
			String sql="select * from menu where id=?";
			DBconn conn=new DBconn();
			ResultSet rs=conn.doSelect(sql,new int[]{Integer.parseInt(id)});
			ArrayList<Menu> list= new ArrayList<Menu>();
				//request.setAttribute("name",rs.getString("name"));
				try {
					if(rs.next()){
						Menu product=new Menu();
						product.setId(rs.getInt("id"));
						product.setName(rs.getString("name"));
						product.setNum(rs.getInt("num"));
						product.setPrice(rs.getDouble("price"));
						product.setUrl(rs.getString("url"));
						product.setDescription(rs.getString("description"));
						//list.add(product);
						System.out.print("加入购物车");
						//System.out.print(product.getName()+product.getDescription());
						//System.out.print(product.getPrice());	
						//System.out.print(product.getShoppingNum());
						hm.put(id,product);
					}
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		
	}
	//删除书
	public void delMenu(String id){
		hm.remove(id);
	}
	//更新书(对于购物车更新。。)
	public void updateMenu(String id,String nums){
		//取出id对应的Book
		Menu menu=hm.get(id);
		menu.setShoppingNum(Integer.parseInt(nums));
	}
	//清空书,清空购物车
	public void clearMenu(){
		hm.clear();
	}
	//显示该购物车中的所有商品信息
	public ArrayList showMyCart(){
		ArrayList<Menu> al=new ArrayList<Menu>();
		//遍历HashMap
		Iterator iterator=hm.keySet().iterator();
		while(iterator.hasNext()){
			//取出key
			String id=(String)iterator.next();
			//取出book
			Menu menu=hm.get(id);
			al.add(menu);
		}
		return al;
	}
	//返回该购物车的总价格
	public float getTotalPrice(){
		float totalPrice=0.0f;	
		//得到总价格
		ArrayList<Menu> al=new ArrayList<Menu>();
		//遍历HashMap
		Iterator iterator=hm.keySet().iterator();
		while(iterator.hasNext()){
			//取出key
			String id=(String)iterator.next();
			//取出book
			Menu menu=hm.get(id);
			totalPrice+=(double)menu.getPrice()*menu.getShoppingNum();
	}
		return totalPrice;
	}
}
