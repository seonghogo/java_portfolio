package com.user.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.member.db.MemberBean;
import com.user.db.UserDAO;

public class UserList implements Action{
	ActionForward forward = new ActionForward();

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		ArrayList<MemberBean> list = new ArrayList<>();
		UserDAO udao = new UserDAO();
		
		list = udao.select();
		
//		request.setAttribute("userlist", list);
		
		HttpSession session = request.getSession();
		session.setAttribute("list", list);
		forward.setPath("./UserAction.us");
		return forward;
	}
	
	
	

}
