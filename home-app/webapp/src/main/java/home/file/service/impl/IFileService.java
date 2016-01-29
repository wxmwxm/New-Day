package home.file.service.impl;

import java.util.List;

import common.models.AFiles;

@SuppressWarnings("rawtypes")
public interface IFileService {
	public List list();

	public List listByFile(AFiles aFiles);
	public AFiles merge(AFiles aFiles);
}
