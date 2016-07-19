package com.Lec.bbs.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Lec.bbs.dao.BDao;
import com.Lec.bbs.dto.UserBean;

public class BContentCommand implements BCommand {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
	
		HttpSession session = request.getSession();
		String userid = session.getAttribute("USER").toString();
		BDao dao = new BDao();
		UserBean dto = dao.contentView(userid);
		
		request.setAttribute("CONTENT_VIEW", dto);

	}

}
