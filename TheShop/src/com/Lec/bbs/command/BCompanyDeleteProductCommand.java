/**
 * 
 */
package com.Lec.bbs.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Lec.bbs.dao.BDao;

public class BCompanyDeleteProductCommand implements BCommand {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		
		String pcode = request.getParameter("pcode");
		
		BDao dao = new BDao();
		int resultCode = dao.deleteCompanyProduct(pcode);

		if(resultCode == 1){
			request.setAttribute("COMP_PRODUCT_DEL_RESULT", "SUCCESS");
		}
		else{
			request.setAttribute("COMP_PRODUCT_DEL_RESULT", "FAIL");
		}

	}

}
