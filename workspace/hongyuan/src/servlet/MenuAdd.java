package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.*;

public class MenuAdd extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public MenuAdd() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8"); 
		request.setCharacterEncoding("utf-8"); 
		PrintWriter out=response.getWriter();
			DBconn conn=new DBconn();
			MyCart myCart =(MyCart)request.getSession().getAttribute("myCart");
			ArrayList<Menu> al=(ArrayList<Menu>) myCart.showMyCart();
			float price=myCart.getTotalPrice();
			String name="";
			String id="";
			for(int i=0;i<al.size();i++){
				Menu menu=(Menu)al.get(i);
				id=id+Integer.toString(menu.getId())+";";
				name=name+menu.getName()+":"+Integer.toString(menu.getShoppingNum())+"份; ";
			}	
			String sql="insert into menuorder(menuid,name,price,ordertime,buy)value(?,?,?,?,?)";
			String []para=new String[]{id,name,String.valueOf(price),null,"no"};
			Boolean rs=conn.executeUpdate(sql, para);
			if(rs){
				out.print("成功插入");
				request.getRequestDispatcher("GoOrderServlet").forward(request, response);
			}
			
	}
	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
