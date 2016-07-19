package com.Lec.bbs.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.Lec.bbs.dao.BDao;

public class BLogonCommand implements BCommand {

	// 유저 테이블에 등록된 유저인지 확인
	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		
		String userid = request.getParameter("userid");
		String userpw = request.getParameter("userpw");
		
		BDao dao = new BDao();
		String userTemp = dao.logonCheck(userid, userpw);
		
		session.setAttribute("USER_LOGIN_CHECK", userTemp);
		
	}

}
