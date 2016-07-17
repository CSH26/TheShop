package com.Lec.bbs.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Lec.bbs.dao.BDao;

public class BWriteCompCommand implements BCommand {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		
		String compcode = session.getAttribute("INSERT_COMP").toString();
		String comppw = request.getParameter("comppw");
		String compname = request.getParameter("compname");
		String compadd = request.getParameter("compadd");
		String comptel = request.getParameter("comptel");
		
		BDao dao = new BDao();
		int ok = dao.writeComp(compcode, comppw, compname, compadd, comptel);
		
		request.setAttribute("COMP_INSERT_RESULT", ok);

	}

}
