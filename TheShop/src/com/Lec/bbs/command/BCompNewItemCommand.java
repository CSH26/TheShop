package com.Lec.bbs.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Lec.bbs.dao.BDao;

public class BCompNewItemCommand implements BCommand {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		
		String compcode = session.getAttribute("COMP_LOGIN_CHECK").toString();
		String pname = request.getParameter("pname");
		String pstock = request.getParameter("pstock");
		String pcost = request.getParameter("pcost");
		
		BDao dao = new BDao();
		int ok = dao.compitemwrite(compcode, pname, pstock, pcost);
		
		request.setAttribute("COMP_ITEM_INSERT_RESULT", ok);

	}

}
