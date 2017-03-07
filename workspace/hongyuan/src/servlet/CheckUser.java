package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MyCart;

public class CheckUser extends HttpServlet {

	/**
	 * Destruction of the servlet. <br>
	 */
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8"); 
		request.setCharacterEncoding("utf-8"); 
		PrintWriter out= response.getWriter();
		String username=request.getParameter("userName");
		String pwd=request.getParameter("pwd");
		if(username.equals("yanbin")&&pwd.equals("0000"))
		{
			MyCart myCart=new MyCart();
			request.getSession().setAttribute("myCart", myCart);
			request.getSession().setAttribute("username", username);
			request.getRequestDispatcher("FindMenu").forward(request, response);
		}else{
		//说明是合法用户，跳转到购物大厅
		//因为在我们后面的其他页面都可能使用到用户信息，因此我们可以把用户信息存放到session中
			request.getRequestDispatcher("Login.jsp").forward(request, response);
	}
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
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
