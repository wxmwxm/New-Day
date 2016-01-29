package common.models;

import java.util.Date;

import common.base.BaseBean;

/**
 * AMenus entity. @author MyEclipse Persistence Tools
 */

public class AMenus extends BaseBean implements java.io.Serializable {

	// Fields

	private Integer id;
	private AManagers AManagers;
	private String name;
	private String type;
	private Integer level;
	private Integer orderid;
	private Integer pid;
	private String status;
	private Date createtime;

	// Constructors

	/** default constructor */
	public AMenus() {
	}

	/** full constructor */
	public AMenus(AManagers AManagers, String name, String type, Integer level,
			Integer orderid, Integer pid, String status, Date createtime) {
		this.AManagers = AManagers;
		this.name = name;
		this.type = type;
		this.level = level;
		this.orderid = orderid;
		this.pid = pid;
		this.status = status;
		this.createtime = createtime;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public AManagers getAManagers() {
		return this.AManagers;
	}

	public void setAManagers(AManagers AManagers) {
		this.AManagers = AManagers;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getLevel() {
		return this.level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public Integer getOrderid() {
		return this.orderid;
	}

	public void setOrderid(Integer orderid) {
		this.orderid = orderid;
	}

	public Integer getPid() {
		return this.pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

}