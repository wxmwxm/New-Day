package home.goods.service;

import java.util.List;

import home.goods.service.impl.IGoodsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import common.dao.AbGoodsDAO;
import common.models.AbGoods;


@Service("iGoodsService")
public class GoodsService implements IGoodsService{
	@Autowired
	private AbGoodsDAO abGoodsDAO;

	@SuppressWarnings("rawtypes")
	public List list(){
		return this.abGoodsDAO.findAll();
	}
	@SuppressWarnings("rawtypes")
	public List listByPage(AbGoods abGoods, Integer currPage,Integer rows){
		String hql = "from AbGoods goods";
		return this.abGoodsDAO.findByPage(hql, currPage, rows);
	}
	public AbGoods merge(AbGoods abGoods){
		return this.abGoodsDAO.merge(abGoods);
	}
}
