package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.*;

public class FindProduct extends HttpServlet {
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
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
		String username=null;
		if (request.getSession().getAttribute("username")==null){System.out.println("~~~~~");response.sendRedirect("login.jsp");}
		else{ username= (String)request.getSession().getAttribute("username");
		System.out.println("!!!!!!!");
		String productID="";
		if (request.getParameter("productId")!=null)
		{productID=request.getParameter("productId");}
		int pageSize=12;
		int pageNow=1;//默认显示第一页
		int rowCount=0;//
		int pageCount=1;//该值是通过pageSize和rowCount
//		//接受用户希望显示的页数（pageNow）
		String s_dirname=(String) request.getAttribute("dirname");
		String s_pageNow=request.getParameter("pageNow");
		if(request.getParameter("dirname")!=null){ s_dirname=request.getParameter("dirname");}
		System.out.println("FindFile s_dirname: "+s_dirname);
		String dirname=null;
		System.out.println("username:!! "+username);
		if (username.equals("yanbin")){
			System.out.println("welcome yanbin!,you have the highest privilage");
		dirname = "/";}
		else{
		dirname = "/hadoop";
		System.out.println("welcome not yanbin!,you don't have the highest privilage");
		}
		if(s_dirname!=(null)){
			//接收到了pageNow
			dirname=s_dirname;
			}
		if(s_pageNow!=null){
		//接收到了pageNow
		pageNow=Integer.parseInt(s_pageNow);
		}
		String sql="select * from product where productId = ?";
		ShowProduct showproduct=new ShowProduct();
		String[] para={productID};
		ArrayList<Product> list=null;
		System.out.println("productId: "+para+"----"+productID);
		try {
			list = showproduct.hiveQuery(sql,para);
			rowCount = list.size();
			System.out.println("FindFile dirname:!! "+dirname);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if((rowCount%pageSize==0)&&(rowCount!=0)){
		pageCount=rowCount/pageSize;
		}else{
		pageCount=rowCount/pageSize+1;
		}
		System.out.println(list);
		int pageStart=(pageNow-1)*pageSize;
		int pageEnd=(pageStart+pageSize)<rowCount?pageStart+pageSize:rowCount;
		List<Product> tmpList=list.subList(pageStart, pageEnd);
		request.setAttribute("pageNow", pageNow);
		request.setAttribute("pageCount", pageCount);
		request.setAttribute("list", tmpList);
		request.setAttribute("dirname", dirname);
		request.getRequestDispatcher("product_search.jsp").forward(request, response);
		}
	}
	
	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}
	public void init() throws ServletException {
		// Put your code here
	}

}
