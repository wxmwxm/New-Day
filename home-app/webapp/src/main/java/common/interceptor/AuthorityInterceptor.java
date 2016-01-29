package common.interceptor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

import common.models.AManagers;

public class AuthorityInterceptor extends AbstractInterceptor{
	private static final long serialVersionUID = 1L;
	private String sessionName;
	private String excludeName;
	private String generalScript;
	private List<String>  list;

   public List<String>  strlsit(String str){
     String[]  s = str.split(",");
     List<String>  list = new  ArrayList<String>();
     for(String ss : s){
        list.add(ss.trim());
     }
     return list;
   }
	/*
	 System.out.println("doIntercept--------");
	Object user = ServletActionContext.getRequest().getSession().getAttribute("User");
	if(user != null){
		return arg0.invoke();
	}else{
		return Action.LOGIN;
	}
	*/

	public void destroy() {
		 System.out.println("destroy--------");
		// TODO Auto-generated method stub
		
	}

	public void init() {
	     list = strlsit(excludeName);
		 System.out.println("init--------"+excludeName);
	}
    public String intercept(ActionInvocation invocation) throws Exception {
		// TODO Auto-generated method stub
		 String actionName = invocation.getProxy().getActionName();
		 System.out.println("doIntercept--------"+actionName);
	     if(list.contains(actionName)){
	        //请求的是合法
	        return invocation.invoke();
	     }else {
	 		String script = null;
	        //查看session
	        Map<String,Object>  session = invocation.getInvocationContext().getSession();
	        AManagers user = (AManagers) session.get(sessionName);
	        if(user==null){
	    		HttpServletRequest request = ServletActionContext.getRequest();
	    		String contextPath = request.getContextPath();
				script = getGeneralScript().replace("{contextPath}", contextPath);
				System.out.println(script);
	    		return Action.LOGIN;
	        }else {
//				Map<String, Object> rj = new HashMap<String, Object>();
//				rj.put("code", Integer.valueOf(0));
//				rj.put("content", "您已经超时，请重新登陆！");
//				rj.put("login", contextPath);
//				script = getJSON(rj);
				script="已登录";
				System.out.println(script);
				return invocation.invoke(); 
	        }
	     }
	}

	public String getGeneralScript() {
		return generalScript;
	}

	public void setGeneralScript(String generalScript) {
		this.generalScript = generalScript;
	}

	public String getExcludeName() {
		return excludeName;
	}

	public void setExcludeName(String excludeName) {
		this.excludeName = excludeName;
	}

	public List<String> getList() {
		return list;
	}

	public void setList(List<String> list) {
		this.list = list;
	}

	public String getSessionName() {
		return sessionName;
	}

	public void setSessionName(String sessionName) {
		this.sessionName = sessionName;
	}
	
}
