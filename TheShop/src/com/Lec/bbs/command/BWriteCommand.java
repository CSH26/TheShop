package com.Lec.bbs.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Lec.bbs.dao.BDao;

public class BWriteCommand implements BCommand {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		
		String userid = session.getAttribute("INSERT_ID").toString();
		String userpw = request.getParameter("userpw");
		String username = request.getParameter("username");
		String useradd = request.getParameter("useradd");
		String usertel = request.getParameter("usertel");
		
		BDao dao = new BDao();
		int ok = dao.write(userid, userpw, username, useradd, usertel);
		
		request.setAttribute("USER_INSERT_RESULT", ok);
	}

}
