package com.Lec.bbs.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Lec.bbs.dao.BDao;

public class BbuyOKCommand implements BCommand {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String userid = session.getAttribute("USER").toString();
		String pcode = request.getParameter("pcode");
		String pstock = request.getParameter("pstock");
		String pnum = request.getParameter("pnum");
		String pname = request.getParameter("pname");
		
		BDao dao = new BDao();
		dao.produpdate(pcode, pstock, pnum);
		dao.purchase(userid, pcode, pname, pnum);
	}

}
