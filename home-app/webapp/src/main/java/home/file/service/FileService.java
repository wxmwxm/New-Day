package home.file.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import common.dao.AFilesDAO;
import common.models.AFiles;

import home.file.service.impl.IFileService;

@Service("iFileService")
@SuppressWarnings("rawtypes")
public class FileService implements IFileService{
	@Autowired
	private AFilesDAO aFilesDAO;
	
	public List list(){
		return this.aFilesDAO.findAll();
	}
	//根据类型查询文件
//	public List listByType(AFiles aFiles){
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("type", aFiles.getType());
//		String hql = "from AFiles file where file.type=:type";
//		return this.aFilesDAO.findByExample(aFiles);
//	}
	public List listByFile(AFiles aFiles){
		return this.aFilesDAO.findByExample(aFiles);
	}
	//保存
	public AFiles merge(AFiles aFiles){
		return this.aFilesDAO.merge(aFiles);
	}
}
