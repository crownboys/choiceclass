package com.ten.ser.cou;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ten.dao.DaoCou;

//老师删除课程功能实现
public class serDeleteCou extends HttpServlet {

	public serDeleteCou() {
		super();
	}

	
	public void destroy() {
		super.destroy(); 
		
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
		out.println("  <BODY>");
		try{
			
			DaoCou delete = new DaoCou();
			int rs = delete.deleteCou(Integer.parseInt(request.getParameter("id")));
			if(rs==0){
				out.println("<center>删除失败！</center>");
				response.sendRedirect("/Ten/tea/selectCou.jsp");
			}else {
				out.println("<center>删除成功！</center>");
				response.sendRedirect("/Ten/tea/selectCou.jsp");
			}

			
		}catch(Exception e){e.printStackTrace();}
		out.println("</BODY>");
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
