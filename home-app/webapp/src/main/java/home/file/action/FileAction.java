package home.file.action;

import home.file.service.impl.IFileService;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;


import common.base.BaseAction;
import common.models.AFiles;
import common.utils.CfgHelper;
import common.utils.StringUtil;

@SuppressWarnings("unchecked")
public class FileAction extends BaseAction{
	private static final long serialVersionUID = 1L;
	public static CfgHelper config = CfgHelper.getInstance();
	private static String realpath = config.getCfg("file.windows.dir");
	@Autowired
	private IFileService iFileService;
	private AFiles aFiles;
	
	private File file;
	private String fileFileName;
	private String type;
	
	public void list(){
		List<AFiles> list = iFileService.list();
		writeJson(list);
	}
	public void listByFile(){
		List<AFiles> list = iFileService.listByFile(aFiles);
		writeJson(list);
	}
	public void merge(){
		try{
			AFiles af = iFileService.merge(aFiles);
			writeJson(af);
		}catch(Exception e){
		}
	}
	
	public String getFileName(String uuid){
		int pos = fileFileName.lastIndexOf( "." ); 
		return uuid + fileFileName.substring(pos);  
	}
	
	//文件上传
	@SuppressWarnings("unused")
	public void upload(){
		//服务器的路径  //getRequest().getRealPath("/");          
        //例如-------D:\apache-tomcat-6.0.18\webapps\struts2_upload\images       
//        System.out.println("上传到服务器的地址realpath: "+realpath);   
        if(!StringUtil.isEmpty(type))
        	realpath += "\\" + type;
        
        InputStream is = null;
        OutputStream os = null;
		try {
			String uuid = UUID.randomUUID().toString();
			String realpathFileName = getFileName(uuid);
			is = new FileInputStream(file);
	        os = new FileOutputStream(new File(realpath, realpathFileName));
	        
	        // 因为file是存放在临时文件夹的文件，我们可以将其文件名和文件路径打印出来，看和之前的fileFileName是否相同
//	        System.out.println("file: " + file.getName());
//	        System.out.println("file: " + file.getPath());
	        
	        byte[] buffer = new byte[500];
	        int length = 0;
	        
	        while(-1 != (length = is.read(buffer, 0, buffer.length)))
	        {
	            os.write(buffer);
	        }
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
	        try {
	        	if(os != null) os.close();
	        	if(is != null) is.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public void down(){
		String fullFileName = realpath+"\\"+fileFileName;
        //System.out.println(fullFileName);  
        //读取文件  
        InputStream in = null ;
        OutputStream out = null;
		try {
			System.out.println("fullFileName: "+fullFileName);
			in = new FileInputStream(fullFileName);  
			out = getResponse().getOutputStream();
	        //写文件  
	        int b;  
	        while((b=in.read())!= -1)  
	        {  
	            out.write(b);  
	        }  
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
	        try {
				in.close();
		        out.close();  
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
		}
	}
	
	public File getFile() {
		return file;
	}
	public void setFile(File file) {
		this.file = file;
	}
	public String getFileFileName() {
		return fileFileName;
	}
	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
}
