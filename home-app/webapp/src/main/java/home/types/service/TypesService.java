package home.types.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import common.dao.AbTypesDAO;
import common.models.AbTypes;

import home.types.service.impl.ITypesService;

@Service("iTypeService")
@SuppressWarnings("rawtypes")
public class TypesService implements ITypesService{
	
	@Autowired
	private AbTypesDAO abTypesDAO;
	
	public List list(){
		return this.abTypesDAO.findAll();
	}
	public List listByPage(AbTypes abTypes, Integer currPage,Integer rows){
		String hql = "from AbTypes type";
		return this.abTypesDAO.findByPage(hql, currPage, rows);
	}
	public List listByType(AbTypes abTypes){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", abTypes.getADicts().getCode());
		String hql = "from AbTypes types where types.ADicts.code=:code";
		return abTypesDAO.find(hql,map);
	}
	public AbTypes merge(AbTypes abTypes){
		return this.abTypesDAO.merge(abTypes);
	}
}
