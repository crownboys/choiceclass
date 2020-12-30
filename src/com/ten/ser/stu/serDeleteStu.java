package com.ten.ser.stu;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ten.dao.DaoStu;

//老师删除学生信息
@SuppressWarnings("serial")
public class serDeleteStu extends HttpServlet {

	public serDeleteStu() {
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
		out.println("  <BODY>");
		try{
			
			DaoStu delete = new DaoStu();
			int rs = delete.deleteStu(Integer.parseInt(request.getParameter("id")));
			if(rs==0){
				out.println("<center>删除失败！</center>");
			}else {
				out.println("<center>删除成功！</center>");
			}
			response.setHeader("refresh","2;url=serSelectStu?page="+request.getParameter("page")+"");
			response.sendRedirect("/Ten/tea/selectStu.jsp");
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
