package com.Lec.bbs.dto;

import java.sql.Timestamp;

public class PurListBean {

	String userid;
	String pcode;
	String pname;
	String pnum;
	String pcost;
	Timestamp pdate;

	public final String getPname() {
		return pname;
	}

	public final void setPname(String pname) {
		this.pname = pname;
	}

	public final String getPcost() {
		return pcost;
	}

	public final void setPcost(String pcost) {
		this.pcost = pcost;
	}

	public PurListBean(String userid, String pcode, String pname, String pcost, String pnum, Timestamp pdate) {
		this.userid = userid;
		this.pcode = pcode;
		this.pname = pname;
		this.pnum = pnum;
		this.pcost = pcost;
		this.pdate = pdate;
	}

	public PurListBean(String userid, String pcode, String pname, String pnum, Timestamp pdate) {
		this.userid = userid;
		this.pcode = pcode;
		this.pname = pname;
		this.pnum = pnum;
		this.pdate = pdate;
	}
	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getPcode() {
		return pcode;
	}

	public void setPcode(String pcode) {
		this.pcode = pcode;
	}

	public String getPnum() {
		return pnum;
	}

	public void setPnum(String pnum) {
		this.pnum = pnum;
	}

	public Timestamp getPdate() {
		return pdate;
	}

	public void setPdate(Timestamp pdate) {
		this.pdate = pdate;
	}

}
