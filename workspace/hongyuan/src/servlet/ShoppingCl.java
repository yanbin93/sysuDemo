package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.*;
public class ShoppingCl extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public ShoppingCl() {
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
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();	
		//接受type值，判断用户希望做什么 del？add？update？
		String type=request.getParameter("type");
		//System.out.println("ml++++++++++++++++++++++++++");
		if("del".equals(type)){
			//说明用户要删除商品（从购物车）
			//接受用户希望删除商品的id
			String id=request.getParameter("id");
			//得到购物车（从session中得到）
			MyCart myCart =(MyCart)request.getSession().getAttribute("myCart");
			myCart.delMenu(id);
			//把要显示的商品信息放入request
			request.setAttribute("cartlist", myCart.showMyCart());
			request.setAttribute("totalPrice", myCart.getTotalPrice()+"");
			//调回showMyCart
			request.getRequestDispatcher("ShowCart.jsp").forward(request, response);
		}else if("add".equals(type)){
			//说明用户希望添加商品到购物车
			//接受用户想购买的商品的id
			String id=request.getParameter("id");
			//什么时候创建购物车对象？？（当用户登陆成功以后，为他创建一个购物车）
			//取出购物车，并添加书到购物车中
			MyCart myCart =(MyCart)request.getSession().getAttribute("myCart");
			//把商品添加到购物车中
			myCart.addMenu(id);
			//System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
			//为了防止每个页面刷新，我可以sendredirect
			//把要显示的放入request，准备显示
			request.setAttribute("cartlist", myCart.showMyCart());
			//把总价格放入request，准备显示
			out.print("?????");
			request.setAttribute("totalPrice", myCart.getTotalPrice()+"");
			//out.print("?????");
			request.getRequestDispatcher("ShowCart.jsp").forward(request, response);
			//response.sendRedirect("GoMenuList");
		}else if("update".equals(type)){
			//更新
			//得到用户希望更新的书号和数量
			String menuIds[]=request.getParameterValues("id");
			//得到每本书的数量
			String nums[]=request.getParameterValues("num");
			//取出购物车，并添加书到购物车中
			MyCart myCart =(MyCart)request.getSession().getAttribute("myCart");
			for(int i=0;i<menuIds.length;i++){
				//更新整个购物车
				myCart.updateMenu(menuIds[i], nums[i]);
			}
			//跳转回我的购物车
			//把要显示的放入request，准备显示
			request.setAttribute("cartlist", myCart.showMyCart());
			//把总价格放入request，准备显示
			request.setAttribute("totalPrice", myCart.getTotalPrice()+"");
			//跳转到显示我的购物车去
			request.getRequestDispatcher("ShowCart.jsp").forward(request, response);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

	public void init() throws ServletException {
		// Put your code here
	}

}
