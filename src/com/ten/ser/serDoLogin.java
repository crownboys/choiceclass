package com.ten.ser;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ten.dao.DaoStu;
import com.ten.dao.DaoTea;
import com.ten.user.Student;
import com.ten.user.Teacher;

//判断登录
@SuppressWarnings("serial")
public class serDoLogin extends HttpServlet {

	/**
	 * 对象的构造函数。
	 */
	public serDoLogin() {
		super();
	}

	/**
	 * Servlet的销毁。 <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * servlet的doGet方法. <br>
	 *
	 * 当表单的标记值方法等于get时，将调用此方法.
	 * 从客户端到服务器的参数响应
	 * 从服务器到客户端的参数响应
	 * 如果发生错误，则抛出ServletException
	 * 如果发生错误，则抛出IOException
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * servlet的doPost方法. <br>
	 * 当表单的标记值方法等于post时，将调用此方法。
	 * 从客户端到服务器的参数响应
	 * 从服务器到客户端的参数响应
	 * 如果发生错误，则抛出ServletException
	 * 如果发生错误，则抛出IOException
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		try{
			int username = Integer.parseInt(request.getParameter("username"));
			String password = request.getParameter("password");
			String type  = null;
			if(request.getParameter("type")!=null)
				type = request.getParameter("type");
			if(type.equals("tea")){//判断是否为老师
				Teacher tea = new Teacher(username,null,password);
				DaoTea logint = new DaoTea();
				tea = logint.loginTea(tea);
				if(tea!=null){
					session.setAttribute("teacher", tea);
					response.sendRedirect("/Ten/tea/teacher.jsp");
				}else{
					out.println("T用户名或密码不正确，请核对后重试!!");
					response.setHeader("refresh","2;url=/Ten/tea/teaLogin.jsp");
				}
			}else if(type.equals("stu")){	//判断是否为学生
				Student stu = new Student(username,null,password,null,null,0);
				out.println(stu.getSname()+"::"+stu.getSpassword()+"<br>");
				out.println(stu.getSname()+"::"+stu.getSpassword()+"<br>");
				DaoStu logins  = new DaoStu();
				stu = logins.loginStu(stu);
				if(stu!=null){
					session.setAttribute("student", stu);
					response.sendRedirect("/Ten/stu/student.jsp");
				}else{
					out.println("S用户名或密码不正确，请核对后重试!!");
					response.setHeader("refresh","2;url=/Ten/Login.jsp");
				}
			}else{
				out.println("错误！请登录！");
				response.setHeader("refresh","2;url=/Ten/Login.jsp");
			}
		}catch(Exception e){ e.printStackTrace();response.sendRedirect("/Ten/Login.jsp");}
		out.flush();
		out.close();
		}

	/**
	 * Servlet的初始化. <br>
	 *
	 * 如果发生错误，则抛出ServletException
	 */
	public void init() throws ServletException {
	}

}
