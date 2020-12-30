package com.ten.ser.stu;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ten.dao.DaoStu;
import com.ten.user.Student;

//老师添加学生
@SuppressWarnings("serial")
public class serInsertStu extends HttpServlet {

	public serInsertStu() {
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
			Student stu = new Student(request.getParameter("Sname"),request.getParameter("Spassword"),request.getParameter("Sclass")
					,request.getParameter("Ssex"),0);
			DaoStu insert = new DaoStu();
			int rs = insert.insertStu(stu);
			if(rs!=0){
				out.println("添加成功："+stu.getSNo());
			}else{
				out.println("添加失败"+stu.getSNo());
			}
			response.sendRedirect("/Ten/tea/selectStu.jsp");
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
