package common.interceptor;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class LoginInterceptor  extends MethodFilterInterceptor{
	private static final long serialVersionUID = 1L;

	@Override
	protected String doIntercept(ActionInvocation actioninvocation) throws Exception {
		System.out.println("doIntercept------");
		Object user = ServletActionContext.getRequest().getSession().getAttribute("user");
		if(user != null){
			return actioninvocation.invoke(); //递归调用拦截器
		}else{
			return Action.LOGIN; //返回到登录页面
		}
	}
}
