package com.member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class logoutPro implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		ActionForward forward = null;
		forward = new ActionForward();
		forward.setRedirect(false);
		HttpSession session = request.getSession();
		
		String id =(String)session.getAttribute("user");
		
		if(id != null) {
			session.invalidate();
			forward.setPath("./Main.me");
		}
		
		return forward;
	}
	

}
