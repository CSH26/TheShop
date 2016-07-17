package com.Lec.bbs.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Lec.bbs.dao.BDao;
import com.Lec.bbs.dto.CompanyBean;
import com.Lec.bbs.dto.UserBean;

public class BCompinfoCommand implements BCommand {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String compcode = session.getAttribute("COMP_LOGIN_CHECK").toString();
		BDao dao = new BDao();
		CompanyBean company = dao.companyinfo(compcode);
		
		request.setAttribute("COMP_INFO", company);

	}

}
