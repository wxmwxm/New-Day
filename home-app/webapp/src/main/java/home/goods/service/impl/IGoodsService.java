package home.goods.service.impl;

import java.util.List;

import common.models.AbGoods;


public interface IGoodsService {
	public List list();
	public AbGoods merge(AbGoods abGoods);
	public List listByPage(AbGoods abGoods, Integer currPage,Integer rows);
}
