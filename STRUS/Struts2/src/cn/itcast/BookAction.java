package cn.itcast;

import com.opensymphony.xwork2.ActionSupport;

public class BookAction extends ActionSupport {

	@Override
	public String execute() throws Exception {
		return "success";
	}
}
