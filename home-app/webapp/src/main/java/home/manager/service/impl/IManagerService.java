package home.manager.service.impl;

import java.util.List;

import common.models.AManagers;


public interface IManagerService {

	public AManagers login(AManagers tbManagers);
	public abstract void save();
	@SuppressWarnings("rawtypes")
	public List list();
}