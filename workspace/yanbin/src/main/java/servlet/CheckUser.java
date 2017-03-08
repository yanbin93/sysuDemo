package servlet;

import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import model.*;
import hive.JDBCToHiveUtils;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;


public class CheckUser extends HttpServlet {
	/**
	 * Constructor of the object.
	 */
	public CheckUser() {
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
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			response.setContentType("text/html;charset=utf-8"); 
			request.setCharacterEncoding("utf-8"); 
			PrintWriter out= response.getWriter();
			//DBconn conn=new DBconn();
			java.sql.Connection hiveConn =JDBCToHiveUtils.getConnnection();
			MD5 md=new MD5();
			String username=request.getParameter("username");
			String pwd=request.getParameter("password");
			pwd =md.EncryptionStr32(pwd, "MD5", "UTF-8");
			String sql="select * from username";
			java.sql.PreparedStatement ps =JDBCToHiveUtils.prepare(hiveConn,sql);
			ResultSet rs;
			boolean flag = false;
			try {
				rs = ps.executeQuery();
				//int columns=rs.getMetaData().getColumnCount();
				System.out.println("查询用户成功");
				
					while(rs.next()){
						if ((username.equals(rs.getString("username")))&&(pwd.equals(rs.getString("password")))){
							flag=true;
							break;
						}
					}
					rs.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if(flag){
					request.getRequestDispatcher("homepage.jsp").forward(request, response);
				}else{
				request.getRequestDispatcher("Error.jsp").forward(request, response);
				}
			
	}
	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
	}
	}
