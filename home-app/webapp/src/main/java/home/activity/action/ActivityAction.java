package home.activity.action;

import java.util.List;

import home.activity.service.impl.IActivityService;

import org.springframework.beans.factory.annotation.Autowired;

import common.base.BaseAction;
import common.models.AbBrands;
import common.models.AcMallActivity;

@SuppressWarnings("unchecked")
public class ActivityAction extends BaseAction{
	private static final long serialVersionUID = 1L;
	
	private AcMallActivity acMallActivity;
	@Autowired
	private IActivityService iActivityService;
	public void list(){ 
		List<AbBrands> list = iActivityService.list();
		writeJson(list);
	}
	public void listByType(){
		List<AcMallActivity> list = iActivityService.listByType(acMallActivity);
		writeJson(list);
	}
	public void merge(){
		try{
			AcMallActivity activity = iActivityService.merge(acMallActivity);
			writeJson(activity);
		}catch(Exception e){
		}
	}
	public AcMallActivity getAcMallActivity() {
		return acMallActivity;
	}
	public void setAcMallActivity(AcMallActivity acMallActivity) {
		this.acMallActivity = acMallActivity;
	}
}
