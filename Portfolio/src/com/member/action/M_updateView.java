package com.member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sound.midi.Synthesizer;

import com.member.db.MemberBean;
import com.member.db.MemberDAO;

public class M_updateView implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		ActionForward forward = null;
		forward = new ActionForward();
		forward.setRedirect(false);
		System.out.println("수정");
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("user");
		System.out.println(id);
		MemberBean mb = new MemberBean();
		MemberDAO mdao = new MemberDAO();
		
		mb = mdao.dateview(id);
		
		request.setAttribute("U_view", mb);
		
		forward.setPath("./M_updateAction.me");
		
		
		
		
		
		
		
		return forward;
	}
	

}
