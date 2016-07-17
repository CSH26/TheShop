package com.Lec.bbs.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Lec.bbs.dao.BDao;

public class BAdminProdDeleteCommand implements BCommand {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		String pcode = request.getParameter("pcode");
		String pname = request.getParameter("pname");
		String pcost = request.getParameter("pcost");
		String pstock = request.getParameter("pstock");

		BDao dao = new BDao();
		dao.AdminProdDelete(pcode, pname, pcost, pstock);
	}

}
