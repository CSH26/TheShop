package com.Lec.bbs.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface BCommand {

	public void excute(HttpServletRequest request, HttpServletResponse response);
	
}
