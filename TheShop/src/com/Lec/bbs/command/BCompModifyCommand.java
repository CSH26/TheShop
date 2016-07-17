package com.Lec.bbs.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Lec.bbs.dao.BDao;

public class BCompModifyCommand implements BCommand {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		String compcode = request.getParameter("compcode");
		String comppw = request.getParameter("comppw");
		String compname = request.getParameter("compname");
		String compadd = request.getParameter("compadd");
		String comptel = request.getParameter("comptel");
	
		
		BDao dao = new BDao();
		int ok = dao.comp_modify(compcode, comppw, compname, compadd, comptel);
		request.setAttribute("COMP_MODIFY_RESULT", ok);
	}

}
