package common.models;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import common.base.BaseBean;

/**
 * AbGoods entity. @author MyEclipse Persistence Tools
 */

public class AbGoods implements java.io.Serializable {

	// Fields

	private String id;
	private ADicts ADicts;
	private AbTypes abTypes;
	private AbBrands abBrands;
	private Integer stock;
	private Double price;
	private String name;
	private String effect;
	private String spec;
	private String area;
	private String packing;
	private String mainpicture;
	private String secpicture;
	private String specifics;
	private Date createtime;
	private Date publishtime;

	// Constructors

	/** default constructor */
	public AbGoods() {
	}

	/** full constructor */
	public AbGoods(ADicts ADicts, AbTypes abTypes, AbBrands abBrands,
			String name, String effect, String spec, String area,
			String packing) {
		this.ADicts = ADicts;
		this.abTypes = abTypes;
		this.abBrands = abBrands;
		this.name = name;
		this.effect = effect;
		this.spec = spec;
		this.area = area;
		this.packing = packing;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public ADicts getADicts() {
		return this.ADicts;
	}

	public void setADicts(ADicts ADicts) {
		this.ADicts = ADicts;
	}

	public AbTypes getAbTypes() {
		return this.abTypes;
	}

	public void setAbTypes(AbTypes abTypes) {
		this.abTypes = abTypes;
	}

	public AbBrands getAbBrands() {
		return this.abBrands;
	}

	public void setAbBrands(AbBrands abBrands) {
		this.abBrands = abBrands;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEffect() {
		return this.effect;
	}

	public void setEffect(String effect) {
		this.effect = effect;
	}

	public String getSpec() {
		return this.spec;
	}

	public void setSpec(String spec) {
		this.spec = spec;
	}

	public String getArea() {
		return this.area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getPacking() {
		return this.packing;
	}

	public void setPacking(String packing) {
		this.packing = packing;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getMainpicture() {
		return mainpicture;
	}

	public void setMainpicture(String mainpicture) {
		this.mainpicture = mainpicture;
	}

	public String getSecpicture() {
		return secpicture;
	}

	public void setSecpicture(String secpicture) {
		this.secpicture = secpicture;
	}

	public String getSpecifics() {
		return specifics;
	}

	public void setSpecifics(String specifics) {
		this.specifics = specifics;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public Date getPublishtime() {
		return publishtime;
	}

	public void setPublishtime(Date publishtime) {
		this.publishtime = publishtime;
	}

}