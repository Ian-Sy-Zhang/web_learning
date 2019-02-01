package org.Ian.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.Ian.Dao.LoginDao;
import org.Ian.entity.Student;

public class LoginServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//登陆请求
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("uname");
		String id = request.getParameter("uid");
		//拿到名字和密码之后组装成一个JavaBean
		Student student = new Student();
		student.setName(name);
		student.setId(id);
		
		try {
			int result = LoginDao.login(student);
			if (result >0) {
				response.sendRedirect("welcome.jsp");
			}else {
				response.sendRedirect("failure.jsp");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
