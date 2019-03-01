package org.Ian.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import org.Ian.Dao.UpdateDao;
import org.Ian.Dao.getStudentInfoDao;
import org.Ian.entity.Student;


public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		Student student = new Student();
		HttpSession session = request.getSession();
		//通过session来获取当前用户的ID
		String id = (String)session.getAttribute("ID");
		
		student = getStudentInfoDao.getinfo(id);
		
		UpdateDao.update(student);
		int trainingTimes = getStudentInfoDao.getinfo(id).getTimes();
		
		//存疑 这里是不是同一个用户服务之中只有一个session但是不能重名
		HttpSession timessession = request.getSession();
		timessession.setAttribute("trainingTimes", trainingTimes);
		
		if (trainingTimes == 999) {
			response.sendRedirect("updateFailure.jsp");
		}
		else {
			response.sendRedirect("UpdateSuccess.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
