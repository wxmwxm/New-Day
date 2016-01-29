package common.models;

import common.base.BaseBean;

/**
 * AUsers entity. @author MyEclipse Persistence Tools
 */

public class AUsers extends BaseBean implements java.io.Serializable {

	// Fields

	private String code;
	private String password;
	private String name;

	// Constructors

	/** default constructor */
	public AUsers() {
	}

	/** full constructor */
	public AUsers(String password, String name) {
		this.password = password;
		this.name = name;
	}

	// Property accessors

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}