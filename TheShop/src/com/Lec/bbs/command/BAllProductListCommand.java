package com.Lec.bbs.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Lec.bbs.dao.BDao;
import com.Lec.bbs.dto.ProductBean;
import com.Lec.bbs.dto.UserBean;

public class BAllProductListCommand implements BCommand {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		
		BDao dao = new BDao();
		ArrayList<ProductBean> productBeans = dao.allProductList();
		
		request.setAttribute("ALL_PRODUCT_LIST", productBeans);

	}

}
