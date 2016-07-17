package com.Lec.bbs.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Lec.bbs.dao.BDao;

public class BCompCheckCommand implements BCommand {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		
		String compcode = request.getParameter("compcode");
		session.setAttribute("INSERT_COMP", compcode);
		BDao dao = new BDao();
		String compTemp = dao.compidCheckTest(compcode);
		
		session.setAttribute("COMP_CODE_CHECK", compTemp);
	}

}
