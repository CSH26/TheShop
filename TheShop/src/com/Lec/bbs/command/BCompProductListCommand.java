
package com.Lec.bbs.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Lec.bbs.dao.BDao;
import com.Lec.bbs.dto.ProductBean;

public class BCompProductListCommand implements BCommand {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String compcode = session.getAttribute("COMP_LOGIN_CHECK").toString();
		BDao dao = new BDao();
		ArrayList<ProductBean> productBeans = dao.companyProductList(compcode);
		
		request.setAttribute("COMP_PRODUCT_LIST", productBeans);
	}

}
