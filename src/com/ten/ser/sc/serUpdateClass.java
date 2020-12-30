package com.ten.ser.sc;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ten.dao.DaoSc;
import com.ten.user.SC;

//老师通过查询学生选课情况进入修改教室操作
public class serUpdateClass extends HttpServlet {

	public serUpdateClass() {
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

		HttpSession session = request.getSession();
		if(session.getAttribute("teacher")==null){
			response.sendRedirect("../Login.jsp");
		}else{
			out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
			out.println("<HTML>");
			out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
			out.println("  <BODY>");
			try{
				int sno = Integer.parseInt(request.getParameter("sno"));
				int cno = Integer.parseInt(request.getParameter("cno"));
				
				DaoSc update = new DaoSc();	
				SC sc = update.selectone(sno,cno);
				if(sc!=null){
					request.setAttribute("room", sc);
					request.getRequestDispatcher("/tea/updateRoom.jsp?type="+request.getParameter("type")+"&key="+request.getParameter("key")+"").forward(request, response);
				}else{
					out.println("<h2>查询失败，请稍后重试</h2>");
					response.setHeader("refresh",  "2;url=serQuerySc");
				}
			}catch(Exception e){e.printStackTrace();}
			out.println("  </BODY>");
			out.println("</HTML>");
		}
		out.flush();
		out.close();
	}

	public void init() throws ServletException {
		
	}

}
