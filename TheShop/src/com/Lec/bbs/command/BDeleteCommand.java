package com.Lec.bbs.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Lec.bbs.dao.BDao;

public class BDeleteCommand implements BCommand {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String userid = session.getAttribute("USER").toString();
		String userpw = request.getParameter("userpw");
		
		BDao dao = new BDao();
		int resultCode = dao.delete(userid, userpw);

		if(resultCode == 1){
			session.setAttribute("USER_DEL_RESULT", "success");
		}
		else{
			session.setAttribute("USER_DEL_RESULT", "fail");
		}
	}

}
