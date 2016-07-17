package com.Lec.bbs.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Lec.bbs.dao.BDao;

public class BCompProductModifyCommand implements BCommand {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		String pcode = request.getParameter("pcode");
		String pname = request.getParameter("pname");
		String pstock = request.getParameter("pstock");
		String pcost = request.getParameter("pcost");
		
		BDao dao = new BDao();
		int ok = dao.comp_product_modify(pcode, pname, pstock, pcost);
		request.setAttribute("COMP_PRODUCT_MODIFY_RESULT", ok);
	}

}
