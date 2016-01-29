package common.utils;

/**
 * JSON 模型
 * 操作后台向前台返回的 JSON 对象.
 * @author King.xw
 * @time 2013-08-25
 * @参数1. success 是否成功 true or  false(默认).
 * @参数2. msg 返回的具体提示信息.
 * @参数3. Object 返回操作的对象,用于在前天进行相应操作. 
 */
public class Json implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private boolean success = false;  // 反映操作是否true or false or error
	private String msg = "";   // 返回具体提示信息
	private Object obj = null;   // 返回操作的对象

	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	public Object getObj() {
		return obj;
	}
	public void setObj(Object obj) {
		this.obj = obj;
	}
}
