package servlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.*;


public class FindUser extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8"); 
		request.setCharacterEncoding("utf-8"); 
		//PrintWriter out = response.getWriter();
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
		DBconn conn=new DBconn();
		ResultSet rs=conn.doSelect("select count(*) from abstractuser", new int[]{});
		ShowUser showuser=new ShowUser();
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
		String sql="select * from abstractuser order by id desc limit ?,?";
		request.setAttribute("pageNow", pageNow);
		request.setAttribute("pageCount", pageCount);
		ArrayList<AbstractUser> list=showuser.show(sql,new int[]{(pageNow-1)*pageSize,pageSize});
		request.setAttribute("list", list);
		request.getRequestDispatcher("User_list.jsp").forward(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
