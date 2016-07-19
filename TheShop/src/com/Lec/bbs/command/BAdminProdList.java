package com.Lec.bbs.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Lec.bbs.dao.BDao;
import com.Lec.bbs.dto.BDto;

public class BAdminProdList implements BCommand {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {

		BDao dao = new BDao();
		ArrayList<BDto> dtos = dao.AdminProductList();
		request.setAttribute("PRODUCTLIST", dtos);
	}

}
