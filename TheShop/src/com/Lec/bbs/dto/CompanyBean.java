package com.Lec.bbs.dto;

public class CompanyBean {

	private String compcode;
	private String comppw;
	private String compname;
	private String compadd;
	private String comptel;
	
	public CompanyBean(String compcode, String comppw, String compname, String compadd, String comptel) {
		this.compcode = compcode;
		this.comppw = comppw;
		this.compname = compname;
		this.compadd = compadd;
		this.comptel = comptel;
	}

	public String getCompcode() {
		return compcode;
	}

	public void setCompcode(String compcode) {
		this.compcode = compcode;
	}

	public String getComppw() {
		return comppw;
	}

	public void setComppw(String comppw) {
		this.comppw = comppw;
	}

	public String getCompname() {
		return compname;
	}

	public void setCompname(String compname) {
		this.compname = compname;
	}

	public String getCompadd() {
		return compadd;
	}

	public void setCompadd(String compadd) {
		this.compadd = compadd;
	}

	public String getComptel() {
		return comptel;
	}

	public void setComptel(String comptel) {
		this.comptel = comptel;
	}
	
	
	
	
}
