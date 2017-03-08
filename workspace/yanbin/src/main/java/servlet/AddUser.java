package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.*;

public class AddUser extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public AddUser() {
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
			request.setAttribute("useName","yanbin");
			String name=request.getParameter("name");
			String address=request.getParameter("address");
			String phone=request.getParameter("phone");
			String email=request.getParameter("email");
			Date expireTime=null;
			// 获取用户注册时间
			Date date=new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String registerTime = sdf.format(date);
			// 设定用户账号失效时间
			Calendar now = Calendar.getInstance();
			String year = Integer.toString(now.get(Calendar.YEAR) + 1);
			String month = Integer.toString(now.get(Calendar.MONTH) + 1);
			String day = Integer.toString(now.get(Calendar.DAY_OF_MONTH));
			String str = year + "-" + month + "-" + day;
			try {
			 expireTime = new java.sql.Date(sdf.parse(str).getTime());
			} catch (ParseException e) {
				e.printStackTrace();
			}
			String sql="insert into abstractUser(name,address,phone,email,register_time,expire_time)values('"+name+"','"+address+"','"+phone+"','"+email+"','"+registerTime+"','"+expireTime+"')";
		 	conn.doInsert(sql);
		 	out.print("用户数据插入成功");
		 	request.getRequestDispatcher("FindUser").forward(request, response);
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
