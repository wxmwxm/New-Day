package common.models;

import java.util.HashSet;
import java.util.Set;

import common.base.BaseBean;

/**
 * AbBrands entity. @author MyEclipse Persistence Tools
 */

public class AbBrands extends BaseBean implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	// Fields
	private Integer id;
	private ADicts ADicts;
	private String name;

	// Constructors

	/** default constructor */
	public AbBrands() {
	}

	/** full constructor */
	public AbBrands(ADicts ADicts, String name) {
		this.ADicts = ADicts;
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

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}