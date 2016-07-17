package com.Lec.bbs.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Lec.bbs.dao.BDao;
import com.Lec.bbs.dto.UserBean;

public class BAdminUserCommand implements BCommand {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		BDao dao = new BDao();
		ArrayList<UserBean> userBeans = dao.allUserList();
		
		request.setAttribute("ALL_USER_LIST", userBeans);

	}

}
