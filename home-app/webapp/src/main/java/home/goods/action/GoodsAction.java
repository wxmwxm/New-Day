package home.goods.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.druid.support.json.JSONUtils;

import home.goods.service.impl.IGoodsService;
import common.base.BaseAction;
import common.models.AbGoods;

@SuppressWarnings("unchecked")
public class GoodsAction extends BaseAction {
	private static final long serialVersionUID = 1L;

	private AbGoods abGoods;
	@Autowired
	private IGoodsService iGoodsService;

	public void count(){
		List<AbGoods> list = iGoodsService.list();
		writeJson(list.size());
	}
	public void list(){
		List<AbGoods> list = iGoodsService.list();
		writeJson(list);
	}
	public void listByPage(){
		List<AbGoods> list = iGoodsService.listByPage(abGoods,page,rows);
		writeJson(list);
	}
	public void merge(){
		try{
			AbGoods goods = iGoodsService.merge(abGoods);
			writeJson(goods);
		}catch(Exception e){
		}
	}
	public AbGoods getAbGoods() {
		return abGoods;
	}
	public void setAbGoods(AbGoods abGoods) {
		this.abGoods = abGoods;
	}
	
}
