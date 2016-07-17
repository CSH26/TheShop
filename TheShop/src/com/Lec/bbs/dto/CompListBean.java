package com.Lec.bbs.dto;

public class CompListBean {
	String compcode;
	String comppw;
	String compname;
	String compadd;
	String comptel;

	public CompListBean() {
		super();
	}

	public CompListBean(String compcode, String comppw, String compname, String compadd, String comptel) {
		super();
		this.compcode = compcode;
		this.comppw = comppw;
		this.compname = compname;
		this.compadd = compadd;
		this.comptel = comptel;
	}

	public final String getCompcode() {
		return compcode;
	}

	public final void setCompcode(String compcode) {
		this.compcode = compcode;
	}

	public final String getComppw() {
		return comppw;
	}

	public final void setComppw(String comppw) {
		this.comppw = comppw;
	}

	public final String getCompname() {
		return compname;
	}

	public final void setCompname(String compname) {
		this.compname = compname;
	}

	public final String getCompadd() {
		return compadd;
	}

	public final void setCompadd(String compadd) {
		this.compadd = compadd;
	}

	public final String getComptel() {
		return comptel;
	}

	public final void setComptel(String comptel) {
		this.comptel = comptel;
	}
}
