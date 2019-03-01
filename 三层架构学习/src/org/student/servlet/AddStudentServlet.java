package org.student.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.servlet.entity.Student;
import org.servlet.service.StudentService;


/**
 * Servlet implementation class AddStudentServlet
 */
public class AddStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddStudentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ID = request.getParameter("sID");
		String name = request.getParameter("sname");
		int age = Integer.parseInt(request.getParameter("sage"));
		String addressString = request.getParameter("saddress");
		Student student = new Student(ID, name, age, addressString);
		StudentService studentService = new StudentService();
		boolean result = studentService.addStudent(student);
		PrintWriter out = response.getWriter();
		/*
		 * out request response session application这几个jsp对象都可以在servlet拿到
		 * out:PrintWriter out = response.getWriter();
		 * session: request.getSession();
		 * application:request.getServletContext();
		 */
		if (result) {
			out.print("增加成功");
		}
		else {
			out.print("增加失败");
		}
	}


	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
