package com.Lec.bbs.dto;

import java.sql.Timestamp;

public class UserBean {

	private String userid;
	private String userpw;
	private String username;
	private String useradd;
	private String usertel;
	Timestamp userdate;

	public UserBean() {
		
	}

	
	public UserBean(String userid, String userpw, String username, String useradd, String usertel, Timestamp userdate) {
		
		this.userid = userid;
		this.userpw = userpw;
		this.username = username;
		this.useradd = useradd;
		this.usertel = usertel;
		this.userdate = userdate;
	}


	public Timestamp getUserdate() {
		return userdate;
	}


	public void setUserdate(Timestamp userdate) {
		this.userdate = userdate;
	}


	public UserBean(String userid, String userpw, String username, String useradd, String usertel) {
		
		this.userid = userid;
		this.userpw = userpw;
		this.username = username;
		this.useradd = useradd;
		this.usertel = usertel;
	}


	public String getUserid() {
		return userid;
	}


	public void setUserid(String userid) {
		this.userid = userid;
	}


	public String getUserpw() {
		return userpw;
	}


	public void setUserpw(String userpw) {
		this.userpw = userpw;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getUseradd() {
		return useradd;
	}


	public void setUseradd(String useradd) {
		this.useradd = useradd;
	}


	public String getUsertel() {
		return usertel;
	}


	public void setUsertel(String usertel) {
		this.usertel = usertel;
	}


	
	
}
