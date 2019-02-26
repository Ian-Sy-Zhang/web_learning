package cn.itcast.form;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.*;

public class Form1DemoAction extends ActionSupport {

	@Override
	public String execute() throws Exception {
		// 第一种方式 使用ActionContext类来获取表单数据
		//1 获取ActionContext对象
		ActionContext context = ActionContext.getContext();
		//2 调用方法得到表单数据
		Map<String, Object> map = context.getParameters();
		
		Set<String> keys = map.keySet();
		for (String key:keys) {
			//根据key得到value
			//至于这里为什么是Object【】数组，是因为表单中可能出现复选框的情况
			Object[] obj = (Object[]) map.get(key);
			System.out.println(Arrays.toString(obj));
		}
		
		return NONE;
	}
}
