package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.File;
import model.showFile;

/**
 * Servlet implementation class SearchType
 */
public class SearchType extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchType() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8"); 
		request.setCharacterEncoding("utf-8"); 
		//PrintWriter out = response.getWriter();
		int pageSize=12;
		int pageNow=1;//默认显示第一页
		int rowCount=0;//
		int pageCount=1;//该值是通过pageSize和rowCount
//		//接受用户希望显示的页数（pageNow）
		String type = null;
		String s_pageNow=request.getParameter("pageNow");
		String s_type=request.getParameter("type");
		String dirname = "/";
		String filename = null;
		if(s_type!=null){
			//接收到了pageNow
			type=s_type;
			}
		if(s_pageNow!=null){
		//接收到了pageNow
		pageNow=Integer.parseInt(s_pageNow);
		}
		List<List<String>> typelist=new ArrayList<List<String>>();
		List<String> type1 =Arrays.asList("txt","doc","sh","py");
		List<String> type2 =Arrays.asList("jpg","tif","bmp","gif");
		typelist.add(type1);
		typelist.add(type2);
		System.out.println(type+typelist);
		showFile showfile=new showFile();
		ArrayList<File> list=null;
		if (type!=null){
		try {
			list = showfile.showSometype(typelist.get(Integer.parseInt(type)));
			rowCount = list.size();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		if(rowCount%pageSize==0){
		pageCount=rowCount/pageSize;
		}else{
		pageCount=rowCount/pageSize+1;
		}
		System.out.println(list);
		int pageStart=(pageNow-1)*pageSize;
		int pageEnd=(pageStart+pageSize)<rowCount?pageStart+pageSize:rowCount;
		List<File> tmpList=list.subList(pageStart, pageEnd);
		request.setAttribute("pageNow", pageNow);
		request.setAttribute("pageCount", pageCount);
		request.setAttribute("list", tmpList);
		request.setAttribute("dirname", dirname);
		request.getRequestDispatcher("FileTree.jsp").forward(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}
}