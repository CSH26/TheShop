package com.Lec.bbs.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Lec.bbs.dao.BDao;
import com.Lec.bbs.dto.BDto;
import com.Lec.bbs.dto.CompListBean;

public class BAdminCompInfo implements BCommand {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		String compcode = request.getParameter("compcode");
		BDao dao = new BDao();
		CompListBean dto = dao.CompInfo(compcode);
		request.setAttribute("Comp_Info", dto);
		

	}

}
