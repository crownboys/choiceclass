package com.ten.ser.cou;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ten.dao.DaoCou;
import com.ten.user.Course;

//老师修改课程功能
public class serDoUpdateCou extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public serDoUpdateCou() {
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
		out.println("  <BODY><center>");
		try{
			request.setCharacterEncoding("utf-8");
			Course cou = new Course(Integer.parseInt(request.getParameter("CNo")),request.getParameter("Cname"),request.getParameter("Ccredit"));
			DaoCou update = new DaoCou();
			int rs = update.updateCou(cou);
			if(rs!=0){
				out.println("修改成功："+cou.getCNo());
			}else{
				out.println("修改失败"+cou.getCNo());
			}
			response.sendRedirect("/Ten/tea/selectCou.jsp");
		}catch(Exception e){e.printStackTrace();}
		
		out.println("</center></BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

	public void init() throws ServletException {
	}

}
