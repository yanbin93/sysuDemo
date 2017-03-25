package servlet;
import model.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ProductList
 */
public class ProductList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
				response.setContentType("text/html;charset=utf-8"); 
		request.setCharacterEncoding("utf-8"); 
		String username=null;
		if (request.getSession().getAttribute("username")==null){response.sendRedirect("fileLogin.jsp");}
		else{ username= (String)request.getSession().getAttribute("username");
		String productID="";
		
		if (request.getParameter("productId")!=null){
			productID=request.getParameter("productId");
		}
		//PrintWriter out = response.getWriter();
		int pageSize=12;
		int pageNow=1;//默认显示第一页
		int rowCount=0;//
		int pageCount=1;//该值是通过pageSize和rowCount
//		//接受用户希望显示的页数（pageNow）
		String s_dirname=(String) request.getAttribute("dirname");
		String s_pageNow=request.getParameter("pageNow");
		if (s_pageNow!=null){pageNow=Integer.parseInt(s_pageNow);}
		if(request.getParameter("dirname")!=null){ s_dirname=request.getParameter("dirname");}
		System.out.println("FindFile s_dirname: "+s_dirname);
		String dirname=null;
		if (request.getParameter("username")!=null){username=request.getParameter("username").toString();}
		if (request.getAttribute("username")!=null){username=request.getAttribute("username").toString();}
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
		String sql="select * from product where Id >= ? and Id <?";
		ShowProduct showproduct=new ShowProduct();
		String[] para={Integer.toString(pageNow),Integer.toString(pageNow+pageSize)};
		ArrayList<Product> list=null;
		System.out.println("productId: "+para+"----");
		try {
			list = showproduct.hiveQuery(sql,para);
			rowCount = showproduct.hiveQuery("select * from product ").size();
			System.out.println("FindFile dirname:!! "+dirname);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if((rowCount%pageSize==0)&&(rowCount!=0)){
		pageCount=rowCount/pageSize;
		}else{
		pageCount=rowCount/pageSize+1;
		request.setAttribute("pageSize", pageCount);
		}
		if (pageCount>12){
			pageCount=12;
		}
		System.out.println(list);
		int pageStart=(pageNow-1)*pageSize;
		int pageEnd=(pageStart+pageSize)<rowCount?pageStart+pageSize:rowCount;
		List<Product> tmpList=list;
		request.setAttribute("pageNow", pageNow);
		if (s_pageNow==null){s_pageNow="1";}
		request.setAttribute("s_pageNow", s_pageNow);
		System.out.println(s_pageNow);
		request.setAttribute("pageCount", pageCount);
		request.setAttribute("list", tmpList);
		request.setAttribute("dirname", dirname);
		request.getRequestDispatcher("product_list.jsp").forward(request, response);
		}
	

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
