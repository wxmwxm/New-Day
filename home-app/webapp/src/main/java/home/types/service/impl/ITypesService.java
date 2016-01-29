package home.types.service.impl;

import java.util.List;

import common.models.AbTypes;

@SuppressWarnings("rawtypes")
public interface ITypesService {
	public List list();
	public List listByPage(AbTypes abTypes, Integer currPage,Integer rows);
	public List listByType(AbTypes abTypes);
	public AbTypes merge(AbTypes abTypes);

}
