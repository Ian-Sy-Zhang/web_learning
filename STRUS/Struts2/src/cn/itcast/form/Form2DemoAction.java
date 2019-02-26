package cn.itcast.form;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class Form2DemoAction extends ActionSupport {
	@Override
	public String execute() throws Exception {
//		// TODO Auto-generated method stub
//		//1 使用ServletActionContext类获取request对象
//		HttpServletRequest request = ServletActionContext.getRequest();
//		//2 调用request里面的方法得到结果
//		String username = request.getParameter("usetname");
//		String password = request.getParameter("password");
//		String address = request.getParameter("address");
//		
//		System.out.println(username + ";" + password +";" + address);
//		
		//操作三个域对象
		//1 request域 后台向前台传递值
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("req", "reqValue");
		
		//2 session域
		HttpSession session = request.getSession();
		session.setAttribute("sess", "sessValue");
		
		//3 ServletContext域
		ServletContext context = ServletActionContext.getServletContext();
		context.setAttribute("contextname", "contextValue");
		
		return NONE;
	}
}
