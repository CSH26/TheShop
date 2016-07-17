package com.Lec.bbs.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Lec.bbs.dao.BDao;
import com.Lec.bbs.dto.CompListBean;

public class BAdminCompList implements BCommand {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {

		BDao dao = new BDao();
		ArrayList<CompListBean> dtos = dao.CompList();
		request.setAttribute("CompList", dtos);
	}

}
