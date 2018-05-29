package com.user.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.about.db.AboutBean;
import com.user.db.UserDAO;

public class AboutView implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		ActionForward forward = new ActionForward();
		
		forward.setRedirect(false);
		
		AboutBean ab = new AboutBean();
		UserDAO dao = new UserDAO();
		int check =0;
		check = dao.about();
		
		if(check == 1) {
			ab = dao.aboutsel();
			request.setAttribute("about", ab);
		}else{
		}
		forward.setPath("./About.us");
		return forward;
	}
	 

}
