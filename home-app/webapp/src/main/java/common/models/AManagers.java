package common.models;

import java.util.HashSet;
import java.util.Set;

/**
 * AManagers entity. @author MyEclipse Persistence Tools
 */

public class AManagers implements java.io.Serializable {

	// Fields

	private String code;
	private String password;
	private String name;

	// Constructors

	/** default constructor */
	public AManagers() {
	}
	/** full constructor */
	public AManagers(String password, String name){
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