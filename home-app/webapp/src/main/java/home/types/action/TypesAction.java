package home.types.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import home.types.service.impl.ITypesService;
import common.base.BaseAction;
import common.models.AbTypes;

@SuppressWarnings("unchecked")
public class TypesAction extends BaseAction{
	private static final long serialVersionUID = 1L;
	
	private AbTypes abTypes;
	@Autowired
	private ITypesService iTypeService;

	public void count(){
		List<AbTypes> list = iTypeService.list();
		writeJson(list.size());
	}
	public void list(){
		List<AbTypes> list = iTypeService.list();
		writeJson(list);
	}
	public void listByPage(){
		List<AbTypes> list = iTypeService.listByPage(abTypes,page,rows);
		writeJson(list);
	}
	public void listByType(){
		List<AbTypes> list = iTypeService.listByType(abTypes);
		writeJson(list);
	}
	public void merge(){
		try{
			AbTypes types = iTypeService.merge(abTypes);
			writeJson(types);
		}catch(Exception e){
		}
	}
	public AbTypes getAbTypes() {
		return abTypes;
	}
	public void setAbTypes(AbTypes abTypes) {
		this.abTypes = abTypes;
	}
}
