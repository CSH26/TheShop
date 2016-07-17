package com.Lec.bbs.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Lec.bbs.dao.BDao;

public class BModifyCommand implements BCommand {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		String userid = request.getParameter("userid");
		String userpw = request.getParameter("userpw");
		String username = request.getParameter("username");
		String useradd = request.getParameter("useradd");
		String usertel = request.getParameter("usertel");
	
		
		BDao dao = new BDao();
		dao.modify(userid, userpw, username, useradd, usertel);

	}

}
