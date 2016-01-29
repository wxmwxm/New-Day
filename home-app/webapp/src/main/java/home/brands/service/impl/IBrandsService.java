package home.brands.service.impl;

import java.util.List;

import common.models.AbBrands;

@SuppressWarnings("rawtypes")
public interface IBrandsService {

	public List list();
	public List listByPage(AbBrands abBrands, Integer currPage,Integer rows);
	public List listByType(AbBrands abBrands);
	public AbBrands merge(AbBrands abBrands);
}
