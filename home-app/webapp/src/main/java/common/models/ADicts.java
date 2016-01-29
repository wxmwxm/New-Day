package common.models;

import java.util.HashSet;
import java.util.Set;

import common.base.BaseBean;

/**
 * ADicts entity. @author MyEclipse Persistence Tools
 */

public class ADicts extends BaseBean implements java.io.Serializable {

	// Fields

	private String code;
	private String name;
	private String detailinfo;
	private String type;
	private String typedetail;

	// Constructors

	/** default constructor */
	public ADicts() {
	}

	/** full constructor */
	public ADicts(String name,String type, String detailinfo,String typedetail) {
		this.name = name;
		this.type = type;
		this.detailinfo = detailinfo;
		this.typedetail = typedetail;
	}

	// Property accessors

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDetailinfo() {
		return this.detailinfo;
	}

	public void setDetailinfo(String detailinfo) {
		this.detailinfo = detailinfo;
	}


	public String getTypedetail() {
		return typedetail;
	}

	public void setTypedetail(String typedetail) {
		this.typedetail = typedetail;
	}

}