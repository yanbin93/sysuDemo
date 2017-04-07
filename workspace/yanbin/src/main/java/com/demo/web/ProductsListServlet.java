package com.demo.web;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.dao.impl.GoodsDaoImpl;
import com.demo.factory.DAOFactory;
import com.demo.model.PageBean;
import com.demo.util.DBUtils;
import com.demo.util.JsonUtil;
import com.demo.util.ResponseUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * Servlet implementation class ProductsListServlet
 */
public class ProductsListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DBUtils dbUtils=new DBUtils();
	GoodsDaoImpl goodsDao=DAOFactory.getGoodsDaoInstance();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductsListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connection con=null;
		con=dbUtils.createConn2();
		try{
			System.out.println("connection succses");
			JSONObject result=new JSONObject();
			JSONArray jsonArray=JsonUtil.formatRsToJsonArray(goodsDao.idList(con));
			System.out.println(jsonArray);
			int total=goodsDao.count(con);
			System.out.println(total);

			System.out.println(result);
			//response.setHeader("Access-Control-Allow-Origin", "*");
			ResponseUtil.write(response,jsonArray);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
