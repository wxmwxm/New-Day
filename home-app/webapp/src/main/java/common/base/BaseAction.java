package common.base;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.opensymphony.xwork2.ActionSupport;
import common.utils.DataGrid;

/**
 * BaseAction 基类
 * @use 1.主要用于获得分页条件
 * 		2.返回数据给客户端
 * 		3.设置编码 UTF-8
 * @author King.xw
 * @time 2013-08-08
 */
public class BaseAction extends ActionSupport  {
	private static final long serialVersionUID = 1L;
	
    protected Integer             page         = 1;             // 当前第几页
    protected Integer             rows         = 10;            // 每页数量
    protected String          sort         = "";            // 排序字段
    protected String          order        = "";            // 排序方式
    
    protected String          jsonString   = "";            // 返回给客户端的JSON字符包括消息字符串或JSON数据
    /**
     * 获取操作用户的IP
     * @type 192.168.0.1
     * @return 
     */
    public String getOptionIp(){
    	String IP = this.getRequest().getRemoteAddr();
    	return IP;
    }

	/**
     * 返回 request对象
     * @return
     */
    protected HttpServletRequest getRequest () {
        return ServletActionContext.getRequest ();
    }
    
    /**
     * 返回 response对象
     * @return
     */
    protected HttpServletResponse getResponse () {
        return ServletActionContext.getResponse ();
    }
    
    /**
     * 返回 session对象
     * @return
     */
    protected HttpSession getSession () {
        return ServletActionContext.getRequest ().getSession ();
    }
    /**
     * 使用阿里巴巴的返回json格式的数据，任务对象都行
     * @param object
     */
    public void writeJson_ALBB(Object object) {
		try {
			String json = JSON.toJSONStringWithDateFormat(object, "yyyy-MM-dd HH:mm:ss");
			ServletActionContext.getResponse().setContentType("text/html;charset=utf-8");
			ServletActionContext.getResponse().getWriter().write(json);
			ServletActionContext.getResponse().getWriter().flush();
			ServletActionContext.getResponse().getWriter().close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
    /**
     * 将对象转换JSON字符
     * @param object
     */
    protected String getJSON( Object object ) {
    	//过滤关联
    	/*JsonConfig config = new JsonConfig();
    	config.setJsonPropertyFilter(new PropertyFilter() {			
			public boolean apply(Object source, String name, Object value) {
				if(name.equalsIgnoreCase("tbProduct")||
						name.equalsIgnoreCase("tsEnterprise")||
						name.equalsIgnoreCase("tsUser")||
						name.equalsIgnoreCase("auditorUser")){
					return true;
				}else{
					return false;
				}
			}
		});
    	
    	config.setExcludes(new String[]{"tbProduct","tsEnterprise","tsUser","auditorUser"});
    	config.setIgnoreDefaultExcludes(false);
    	config.setCycleDetectionStrategy(CycleDetectionStrategy.LENIENT);*/
    	
        //return JSONArray.fromObject ( object ).toString ();
//    	System.out.println(JSON.toJSONString(object,SerializerFeature.DisableCircularReferenceDetect));
    	return JSON.toJSONString(object,SerializerFeature.DisableCircularReferenceDetect);
    }
    
    /**
     * 返回 JSON 字符串返回给客户端
     * @param jsonString
     */
    protected void printJsonString ( String jsonString ) {
        PrintWriter out = null;
        try {
        	HttpServletResponse response = getResponse();
        	response.setCharacterEncoding ( "UTF-8" );
            response.setContentType("text/html;charset=UTF-8");             
            out = response.getWriter ();
            out.print ( jsonString );
        }
        catch (IOException e) {
            e.printStackTrace ();
        }
        finally {
        	out.flush();
            out.close();
        }
    }
    /**
     * 返回 JSON 字符串返回给客户端
     * @param Object
     */
    public void writeJson(Object object) {
    	printJsonString(getJSON(object));
    }
    
    
    /**
     * 根据Pager对象，生成JSON 标准格式返回给 EasyUI
     * @param pager
     * @return
     */
    protected String createEasyUiJson(DataGrid<?> pager){
    	String jsonstr = "{\"total\":" + pager.getTotal() + ",\"rows\":"+ getJSON(pager.getRows()) + "}";
    	return jsonstr;
    }
    /**
     * 返回当前登录用户对象信息
     * @return
     * @Description:
    */ 
//    protected LoginUser getLoginUserInfo () {
//        return (LoginUser) ServletActionContext.getRequest ().getSession ().getAttribute ( "loginUser" );
//    } 
    
    public Integer getPage () {
        return page;
    }
    
    public void setPage ( Integer page ) {
        this.page = page;
    }
    
    
    public Integer getRows() {
		return rows;
	}

	public void setRows(Integer rows) {
		this.rows = rows;
	}

	public String getSort () {
        return sort;
    }
    
    public void setSort ( String sort ) {
        this.sort = sort;
    }
    
    public String getOrder () {
        return order;
    }
    
    public void setOrder ( String order ) {
        this.order = order;
    }
    
    public String getJsonString () {
        return jsonString;
    }
    
    public void setJsonString ( String jsonString ) {
        this.jsonString = jsonString;
    }
}
