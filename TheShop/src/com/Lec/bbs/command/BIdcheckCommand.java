package com.Lec.bbs.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Lec.bbs.dao.BDao;

public class BIdcheckCommand implements BCommand {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		
		String userid = request.getParameter("userid");
		session.setAttribute("INSERT_ID", userid);
		BDao dao = new BDao();
		String userTemp = dao.idCheckTest(userid);
		
		session.setAttribute("USER_ID_CHECK", userTemp);
		
	}

}
