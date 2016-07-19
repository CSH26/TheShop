package com.Lec.bbs.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Lec.bbs.dao.BDao;
import com.Lec.bbs.dto.PurListBean;

public class BMylistCommand implements BCommand {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String userid = session.getAttribute("USER").toString();
		BDao dao = new BDao();
		ArrayList<PurListBean> dtos = dao.mylist(userid);
		
		request.setAttribute("MYLIST", dtos);
	}

}
