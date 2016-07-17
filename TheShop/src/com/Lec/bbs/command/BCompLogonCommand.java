package com.Lec.bbs.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Lec.bbs.dao.BDao;

public class BCompLogonCommand implements BCommand {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		
		String compcode = request.getParameter("compcode");
		String comppw = request.getParameter("comppw");
		
		BDao dao = new BDao();
		String compTemp = dao.complogonCheck(compcode, comppw);
	
		session.setAttribute("COMP_LOGIN_CHECK", compTemp);

	}

}
