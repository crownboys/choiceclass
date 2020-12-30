package com.ten.ser.cou;

//老师添加课程功能
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ten.dao.DaoCou;
import com.ten.user.Course;

public class serDoInsertCou extends HttpServlet {

	public serDoInsertCou() {
		super();
	}

	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY><center>");
		try{
			request.setCharacterEncoding("utf-8");
			Course cou = new Course(request.getParameter("Cname"),request.getParameter("Ccredit"));
			DaoCou insert = new DaoCou();
			int rs = insert.insertCou(cou);
			if(rs!=0){
				out.println("添加成功："+cou.getCNo());
			}else{
				out.println("添加失败"+cou.getCNo());
				
			}
			response.sendRedirect("/Ten/tea/selectCou.jsp");
		}catch(Exception e){e.printStackTrace();}
		out.println("  </center></BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
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
