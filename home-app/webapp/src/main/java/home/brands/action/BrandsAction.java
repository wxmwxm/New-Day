package home.brands.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import home.brands.service.impl.IBrandsService;
import common.base.BaseAction;
import common.models.AbBrands;
import common.models.AbTypes;

@SuppressWarnings("unchecked")
public class BrandsAction  extends BaseAction {
	private static final long serialVersionUID = 1L;
	
	private AbBrands abBrands;
	@Autowired
	private IBrandsService iBrandsService;

	public void count(){
		List<AbBrands> list = iBrandsService.list();
		writeJson(list.size());
	}
	public void list(){
		List<AbBrands> list = iBrandsService.list();
		writeJson(list);
	}
	public void listByPage(){
		List<AbBrands> list = iBrandsService.listByPage(abBrands,page,rows);
		writeJson(list);
	}
	public void listByType(){
		List<AbBrands> list = iBrandsService.listByType(abBrands);
		writeJson(list);
	}
	public void merge(){
		try{
			AbBrands abbrands = iBrandsService.merge(abBrands);
			writeJson(abbrands);
		}catch(Exception e){
		}
	}
	public AbBrands getAbBrands() {
		return abBrands;
	}
	public void setAbBrands(AbBrands abBrands) {
		this.abBrands = abBrands;
	}
	
}
