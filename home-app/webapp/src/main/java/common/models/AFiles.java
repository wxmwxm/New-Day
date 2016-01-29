package common.models;

/**
 * AFiles entity. @author MyEclipse Persistence Tools
 */

public class AFiles implements java.io.Serializable {

	// Fields

	private String id;
	private String filename;
	private String dir;
	private String type;

	// Constructors

	/** default constructor */
	public AFiles() {
	}

	/** minimal constructor */
	public AFiles(String filename) {
		this.filename = filename;
	}

	/** full constructor */
	public AFiles(String filename, String dir, String type) {
		this.filename = filename;
		this.dir = dir;
		this.type = type;
	}

	// Property accessors

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}


	public String getFilename() {
		return this.filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getDir() {
		return this.dir;
	}

	public void setDir(String dir) {
		this.dir = dir;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

}