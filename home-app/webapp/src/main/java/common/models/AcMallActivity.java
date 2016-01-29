package common.models;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import common.base.BaseBean;

/**
 * AcMallActivity entity. @author MyEclipse Persistence Tools
 */

public class AcMallActivity extends BaseBean implements java.io.Serializable {

	// Fields

	private Integer id;
	private AManagers AManagers;
	private String title;
	private String name;
	private ADicts ADicts;
	private String detailinfo;
	private Date createtime;
	private String state;
	private Set acMallActivityGoodses = new HashSet(0);

	// Constructors

	/** default constructor */
	public AcMallActivity() {
	}

	/** full constructor */
	public AcMallActivity(AManagers AManagers, String title, String name,
			ADicts ADicts, String detailinfo, Date createtime,String state,
			Set acMallActivityGoodses) {
		this.AManagers = AManagers;
		this.title = title;
		this.name = name;
		this.ADicts = ADicts;
		this.detailinfo = detailinfo;
		this.createtime = createtime;
		this.state = state;
		this.acMallActivityGoodses = acMallActivityGoodses;
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

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ADicts getADicts() {
		return ADicts;
	}

	public void setADicts(ADicts aDicts) {
		ADicts = aDicts;
	}

	public String getDetailinfo() {
		return this.detailinfo;
	}

	public void setDetailinfo(String detailinfo) {
		this.detailinfo = detailinfo;
	}

	public Date getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Set getAcMallActivityGoodses() {
		return this.acMallActivityGoodses;
	}

	public void setAcMallActivityGoodses(Set acMallActivityGoodses) {
		this.acMallActivityGoodses = acMallActivityGoodses;
	}

}