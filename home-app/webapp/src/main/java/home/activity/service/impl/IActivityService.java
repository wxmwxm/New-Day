package home.activity.service.impl;

import java.util.List;

import common.models.AcMallActivity;

@SuppressWarnings("rawtypes")
public interface IActivityService {

	public List list();
	public List listByType(AcMallActivity acMallActivity);
	public AcMallActivity merge(AcMallActivity acMallActivity);
}
