package com.Lec.bbs.dto;

public class ProductBean {
	
	private String pcode;
	private String pname;
	private String pstock;
	private String pcost;
	private String compcode;
	
	public ProductBean(String pcode, String pname, String pstock, String pcost) {
		super();
		this.pcode = pcode;
		this.pname = pname;
		this.pstock = pstock;
		this.pcost = pcost;
	}
	
	public ProductBean(String pcode, String pname, String pstock, String pcost, String compcode) {
		super();
		this.pcode = pcode;
		this.pname = pname;
		this.pstock = pstock;
		this.pcost = pcost;
	}

	
	public String getCompcode() {
		return compcode;
	}

	public void setCompcode(String compcode) {
		this.compcode = compcode;
	}

	public String getPcode() {
		return pcode;
	}

	public void setPcode(String pcode) {
		this.pcode = pcode;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getPstock() {
		return pstock;
	}

	public void setPstock(String pstock) {
		this.pstock = pstock;
	}

	public String getPcost() {
		return pcost;
	}

	public void setPcost(String pcost) {
		this.pcost = pcost;
	}
	
	
	
	
}
