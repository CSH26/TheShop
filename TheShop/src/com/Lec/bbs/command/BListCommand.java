package com.Lec.bbs.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Lec.bbs.dao.BDao;
import com.Lec.bbs.dto.UserBean;

public class BListCommand implements BCommand {

	public void excute(HttpServletRequest request, HttpServletResponse response) {
		
		BDao dao = new BDao();
		ArrayList<UserBean> userBeans = dao.list();
		
		request.setAttribute("list", userBeans);
		
	}
	
	/*
	public UserBean[] sort(UserBean[] tempArr){
		int end = tempArr.length-1;
		
		for(int i = end;i>0;i--){
			for(int k=0;k<i;k++){
				if(tempArr[k].getTotal() <= tempArr[k+1].getTotal()){
					UserBean temp = tempArr[k];
					tempArr[k] = tempArr[k+1];
					tempArr[k+1] = temp;
				}
			}
		}
		return tempArr;
	}*/
	
}
