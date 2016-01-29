package home.manager.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import home.manager.service.impl.IManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import common.dao.AManagersDAO;
import common.models.AManagers;

@SuppressWarnings("unchecked")
@Service("iManagerService")
public class ManagerService implements IManagerService {
	@Autowired
	private AManagersDAO aManagersDAO;
	public AManagers login(AManagers aManagers){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", aManagers.getCode());
		map.put("password", aManagers.getPassword());
		String hql = "from AManagers manager where manager.code=:code and manager.password=:password";
		return (AManagers) aManagersDAO.get(hql,map);
	}
	
	@SuppressWarnings("rawtypes")
	public List list(){
		return this.aManagersDAO.findAll();
	}
	public void save() {
		System.out.println("save-----");
		// Test test = new Test("wxm1", "123", "王爷");
		List<AManagers> list = this.aManagersDAO.findAll();
		for (AManagers object : list) {
			System.out.println(object.getCode());
		}
	}

}