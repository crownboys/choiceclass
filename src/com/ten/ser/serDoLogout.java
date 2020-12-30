package com.ten.ser;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//转换登陆角色
@SuppressWarnings("serial")
public class serDoLogout extends HttpServlet {

	/**
	 * 对象的构造函数。
	 */
	public serDoLogout() {
		super();
	}

	/**
	 * Servlet的销毁。
	 */
	public void destroy() {
		super.destroy(); 
	}

	/**
	 * servlet的doGet方法. <br>
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
		HttpSession session = request.getSession();
		try{
				session.removeAttribute("teacher");
				session.removeAttribute("student");
	
		}catch(Exception e){e.printStackTrace();};
		response.sendRedirect("/Ten/Login.jsp");
	}
	
	public void init() throws ServletException {
		// Put your code here
	}

}
