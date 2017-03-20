package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DBconn;

public class AddProduct extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public AddProduct() {
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
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8"); 
		request.setCharacterEncoding("utf-8"); 
		PrintWriter out= response.getWriter();
			DBconn conn=new DBconn();
			//int id=Integer.parseInt(request.getParameter("productId"));
			String name=request.getParameter("productName");
			String no=request.getParameter("productNo");
			String batch=request.getParameter("productBatch");
			String description=request.getParameter("description");
			Date expireTime=null;
			String startTime=request.getParameter("productStart");
			String endTime=request.getParameter("productEnd");
			String sql="insert into product(name,factory_id,product_batch,product_start,product_end,description)values('"+name+"','"+no+"','"+batch+"','"+startTime+"','"+endTime+"','"+description+"')";
		 	conn.doInsert(sql);
		 	request.getRequestDispatcher("FindProduct").forward(request, response);
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
