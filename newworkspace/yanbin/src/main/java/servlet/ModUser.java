package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.*;

public class ModUser extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8"); 
		request.setCharacterEncoding("utf-8"); 
		PrintWriter out = response.getWriter();
		String userid[]=request.getParameterValues("userid");
		String name[]=request.getParameterValues("name");
		String address[]=request.getParameterValues("address");
		String phone[]=request.getParameterValues("phone");
		String email[]=request.getParameterValues("email");
		//得到每本书的数量
		//取出购物车，并添加书到购物车中
		//AbstractUser list =(AbstractUser)request.getSession().getAttribute("list");
		for(int i=0;i<name.length;i++){
			DBconn conn=new DBconn();
			String[] para=new String[]{name[i],address[i],phone[i],email[i],userid[i]};
			conn.executeUpdate("update abstractuser set name=?,address=?,phone=?,email=?where id=?",para);
			//conn.doUpdate("update AbstractUser set name='"+name[i]+"',address='"+address[i]+"',phone='"+phone[i]+"',email='"+email[i]+"'where id='"+userid[i]+"'");

		}
		request.getRequestDispatcher("FindUser").forward(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
