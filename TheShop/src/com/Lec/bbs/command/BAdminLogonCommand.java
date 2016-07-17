package com.Lec.bbs.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Lec.bbs.dao.BDao;

public class BAdminLogonCommand implements BCommand {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		
		String adminid = request.getParameter("adminid");
		String adminpw = request.getParameter("adminpw");
	
		BDao dao = new BDao();
		String adminTemp = dao.adminlogonCheck(adminid, adminpw);
		
		if(adminTemp.equals("WELCOME_ADMIN")){
			session.setAttribute("ADMIN_LOGIN_CHECK", "OK");
		}
		else if(adminTemp.equals("WHO ARE YOU?....")){
			session.setAttribute("ADMIN_LOGIN_CHECK", "DENY");
		}
		
	}

}
