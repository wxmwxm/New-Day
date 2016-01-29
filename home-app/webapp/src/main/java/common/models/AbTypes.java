package common.models;

import java.util.HashSet;
import java.util.Set;

import common.base.BaseBean;

/**
 * AbTypes entity. @author MyEclipse Persistence Tools
 */

public class AbTypes extends BaseBean implements java.io.Serializable {

	// Fields

	private Integer id;
	private ADicts ADicts;
	private Integer pid;
	private String name;

	// Constructors

	/** default constructor */
	public AbTypes() {
	}

	/** full constructor */
	public AbTypes(ADicts ADicts, Integer pid, String name) {
		this.ADicts = ADicts;
		this.pid = pid;
		this.name = name;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public ADicts getADicts() {
		return this.ADicts;
	}

	public void setADicts(ADicts ADicts) {
		this.ADicts = ADicts;
	}

	public Integer getPid() {
		return this.pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}