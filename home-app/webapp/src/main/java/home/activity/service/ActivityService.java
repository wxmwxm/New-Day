package home.activity.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import common.dao.AcMallActivityDAO;
import common.models.AcMallActivity;

import home.activity.service.impl.IActivityService;

@Service("iActivityService")
@SuppressWarnings("rawtypes")
public class ActivityService implements IActivityService{
	@Autowired
	private AcMallActivityDAO acMallActivityDAO;

	//所有活动
	public List list(){
		return this.acMallActivityDAO.findAll();
	}
	//根据类型查询活动信息
	public List listByType(AcMallActivity acMallActivity){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", acMallActivity.getADicts().getCode());
		String hql = "from AcMallActivity mall where mall.ADicts.code=:code";
		return acMallActivityDAO.find(hql,map);
	}
	//编辑活动
	public AcMallActivity merge(AcMallActivity acMallActivity){
		return this.acMallActivityDAO.merge(acMallActivity);
	}
}
