package servlet;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.*;

public class RegistServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public RegistServlet() {
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
			String username=request.getParameter("usernamesignup");
			String pwd=request.getParameter("passwordsignup");
			String email=request.getParameter("emailsignup");
			String other=request.getParameter("othersignin");
			pwd =md.EncryptionStr32(pwd, "MD5", "UTF-8");
			String sql="insert into table username values (?,?,null,?)";
			java.sql.PreparedStatement ps =JDBCToHiveUtils.prepare(hiveConn,sql);
			ResultSet rs;
			boolean flag = false;
			try {
				ps.setString(1,username);
				ps.setString(2,password);
				// ps.setString(3,int);
				ps.setString(3,email);
				rs = ps.executeUpdate(sql);
				//int columns=rs.getMetaData().getColumnCount();
				System.out.println("添加用户成功")
				// 	while(rs.next()){
				// 		System.out.println(rs.getString("username"));
				// 		System.out.println(rs.getString("password"));
				// 		if ((username.equals(rs.getString("username")))&&(pwd.equals(rs.getString("password")))){
				// 			flag=true;
				// 			break;
				// 		}
				// 	}
				rs.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if(flag){
					request.getRequestDispatcher("login.jsp").forward(request, response);
				}else{
 				request.getRequestDispatcher("login.jsp").forward(request, response);
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
