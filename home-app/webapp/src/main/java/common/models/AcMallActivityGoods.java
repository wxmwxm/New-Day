package common.models;

import java.util.Date;

import common.base.BaseBean;

/**
 * AcMallActivityGoods entity. @author MyEclipse Persistence Tools
 */

public class AcMallActivityGoods extends BaseBean implements java.io.Serializable {

	// Fields

	private Integer id;
	private AcMallActivity acMallActivity;
	private AbGoods abGoods;
	private Date createtime;
	private String state;

	// Constructors

	/** default constructor */
	public AcMallActivityGoods() {
	}

	/** full constructor */
	public AcMallActivityGoods(AcMallActivity acMallActivity, AbGoods abGoods,
			Date createtime, String state) {
		this.acMallActivity = acMallActivity;
		this.abGoods = abGoods;
		this.createtime = createtime;
		this.state = state;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public AcMallActivity getAcMallActivity() {
		return this.acMallActivity;
	}

	public void setAcMallActivity(AcMallActivity acMallActivity) {
		this.acMallActivity = acMallActivity;
	}

	public AbGoods getAbGoods() {
		return this.abGoods;
	}

	public void setAbGoods(AbGoods abGoods) {
		this.abGoods = abGoods;
	}

	public Date getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

}