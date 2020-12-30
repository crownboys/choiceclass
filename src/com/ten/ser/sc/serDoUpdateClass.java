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

//修改教室操作
public class serDoUpdateClass extends HttpServlet {

	
	public serDoUpdateClass() {
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
				String classroom = request.getParameter("classroom");
				DaoSc update = new DaoSc();
				SC sc = new SC();
				sc.setSNo(sno);
				sc.setCNo(cno);
				sc.setClassroom(classroom);
				int rs = update.updateClass(sc);
				if(rs!=0) {
					System.out.println("classroom update over!!");
					out.println("<center><h2>教室修改成功</h2></center>");
				}else{
					out.println("<center><h2>教室修改失败</h2></center>");
				}
				response.setHeader("refresh","2;url=/Ten/tea/Query.jsp?type="+request.getParameter("type")+"&query="+request.getParameter("key")+"");
			}catch(Exception e){e.printStackTrace();}
			out.println("  </BODY>");
			out.println("</HTML>");
		}
		out.flush();
		out.close();
	}

	public void init() throws ServletException {
		// Put your code here
	}

}
