package com.Lec.bbs.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Lec.bbs.dao.BDao;
import com.Lec.bbs.dto.ProductBean;
import com.Lec.bbs.dto.UserBean;

public class BCompDetailProductListCommand implements BCommand {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		String pcode = request.getParameter("pcode");

		BDao dao = new BDao();
		ProductBean pro = dao.productView(pcode);
		
		request.setAttribute("PRODUCT_UPDATE_VIEW", pro);
	}

}
