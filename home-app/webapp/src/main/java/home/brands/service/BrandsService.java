package home.brands.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import home.brands.service.impl.IBrandsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import common.dao.AbBrandsDAO;
import common.models.AbBrands;

@Service("iBrandsService")
@SuppressWarnings("rawtypes")
public class BrandsService implements IBrandsService{

	@Autowired
	private AbBrandsDAO abBrandsDAO;

	public List list(){
		return this.abBrandsDAO.findAll();
	}
	public List listByPage(AbBrands abBrands, Integer currPage,Integer rows){
		String hql = "from AbBrands brands";
		return this.abBrandsDAO.findByPage(hql, currPage, rows);
	}
	public List listByType(AbBrands abBrands){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", abBrands.getADicts().getCode());
		String hql = "from AManagers manager where manager.ADicts.code=:code";
		return abBrandsDAO.find(hql,map);
	}
	public AbBrands merge(AbBrands abBrands){
		return this.abBrandsDAO.merge(abBrands);
	}
}
