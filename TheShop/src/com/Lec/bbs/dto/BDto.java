package com.Lec.bbs.dto;

import java.sql.Timestamp;

public class BDto {

	String pcode;
	String pname;
	String pcost;
	String pstock;

	public BDto(String pcode, String pname, String pcost, String pstock) {
		super();
		this.pcode = pcode;
		this.pname = pname;
		this.pstock = pstock;
		this.pcost = pcost;
	}

	public final String getPcost() {
		return pcost;
	}

	public final void setPcost(String pcost) {
		this.pcost = pcost;
	}

	public BDto() {
		super();
	}

	public final String getPstock() {
		return pstock;
	}

	public final void setPstock(String pstock) {
		this.pstock = pstock;
	}

	public final String getPcode() {
		return pcode;
	}

	public final void setPcode(String pcode) {
		this.pcode = pcode;
	}

	public final String getPname() {
		return pname;
	}

	public final void setPname(String pname) {
		this.pname = pname;
	}
}
