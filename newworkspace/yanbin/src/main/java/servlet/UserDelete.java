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

public class UserDelete extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public UserDelete() {
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
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8"); 
		request.setCharacterEncoding("utf-8"); 
		PrintWriter out= response.getWriter();
			DBconn conn=new DBconn();
			int id=Integer.valueOf(request.getParameter("id"));
			String sql="delete from abstractUser where id='"+id+"'";
			conn.doDelete(sql);
			ShowUser showuser=new ShowUser();
			ArrayList<AbstractUser> list= new ArrayList<AbstractUser>();
			int pageSize=12;
			int pageNow=1;//默认显示第一页
			int rowCount=0;//
			int pageCount=0;//该值是通过pageSize和rowCount
			//接受用户希望显示的页数（pageNow）
			String s_pageNow=request.getParameter("pageNow");
			if(s_pageNow!=null){
			//接收到了pageNow
			pageNow=Integer.parseInt(s_pageNow);
			}
			ResultSet rs=conn.doSelect("select count(*) from abstractuser", new int[]{});
			try {
				if(rs.next()){
				rowCount=rs.getInt(1);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//计算pageCount
			if(rowCount%pageSize==0){
			pageCount=rowCount/pageSize;
			}else{
			pageCount=rowCount/pageSize+1;
			}
			//查询出需要显示的记录
			sql="select * from abstractuser order by id desc limit ?,?";
			request.setAttribute("pageNow", pageNow);
			request.setAttribute("pageCount", pageCount);
			list=showuser.show(sql,new int[]{(pageNow-1)*pageSize,pageSize});
			request.setAttribute("list", list);
			request.getRequestDispatcher("User_list.jsp").forward(request, response);
		}
	/*public void service(ServletRequest request, ServletResponse response)
			throws ServletException, IOException {
			request.getRequestDispatcher("FindUser").forward(request, response);
			}
	*/
	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
