package home.login.action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import home.manager.action.ManagerAction;
import home.manager.service.impl.IManagerService;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import common.base.BaseAction;
import common.models.AManagers;
import common.utils.BeanUtils;

@SuppressWarnings("serial")
public class LoginAction extends BaseAction {
	private static final Logger logger = Logger.getLogger(ManagerAction.class);

	private AManagers amanagers;
	@Autowired
	private IManagerService iManagerService;

	//登录
	public String login(){
		System.out.println("login");
		return SUCCESS;
	}
	//登录
	public void loginJson(){
		Map<String,String> map = new HashMap<String,String>();
//		String code = ServletActionContext.getRequest ().getParameter("amanagers.code");
//		System.out.println(code);
		if(BeanUtils.isObjectNotNull(amanagers)){
			HttpSession httpSession = getSession();
			// 首先判断session里面是否已经存在
			if(null == httpSession){
				map.put("errorInfo", "会话超时,请重新登录...");
				map.put("errorCode", "-1");
			}
			logger.info(amanagers.getCode()+"  "+amanagers.getPassword());
			AManagers login = iManagerService.login(amanagers);
			if(login !=null){
				httpSession.setAttribute("User", login);
				map.put("errorInfo", "登录成功。");
				map.put("errorCode", "0");
			}else{
				map.put("errorInfo", "登录信息\""+amanagers.getCode()+"\"不存在,或密码错误.");
				map.put("errorCode", "-1");
			}
		}else{
			Object login = getSession().getAttribute("User");
			if(login !=null){
				map.put("errorInfo", "登录成功。");
				map.put("errorCode", "0");
			}else{
				map.put("errorInfo", "登录信息错误.");
				map.put("errorCode", "-1");
			}
		}
		writeJson(map);
	}
	//注销
	public void logoutJson(){
		HttpSession httpSession = getSession();
		httpSession.removeAttribute("User");
	}
	public AManagers getAmanagers() {
		return amanagers;
	}
	public void setAmanagers(AManagers amanagers) {
		this.amanagers = amanagers;
	}
	
}
