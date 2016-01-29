package home.manager.action;

import java.util.List;


import home.manager.service.impl.IManagerService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;


import common.base.BaseAction;
import common.models.AManagers;

@SuppressWarnings("serial")
public class ManagerAction extends BaseAction {
	@SuppressWarnings("unused")
	private static final Logger logger = Logger.getLogger(ManagerAction.class);

	private AManagers aManagers;
	@Autowired
	private IManagerService iManagerService;
	
	public void save() {
		this.iManagerService.save();
	}
	
	@SuppressWarnings("unchecked")
	public String list(){
		List<AManagers> list = this.iManagerService.list();
		System.out.println(list.size());
		writeJson(list);
		return SUCCESS;
	}

	public AManagers getaManagers() {
		return aManagers;
	}

	public void setaManagers(AManagers aManagers) {
		this.aManagers = aManagers;
	}
	
}