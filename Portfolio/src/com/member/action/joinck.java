package com.member.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.member.db.MemberDAO;

public class joinck implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		
		String id = request.getParameter("id");
		String email = request.getParameter("email");
		MemberDAO mdao = new MemberDAO();
		int check = 0;
		
		int ck = 0;
		System.out.println(id+email+"!!!!!!!!!!!!!!!!!!!!!!");
		if(id == null || email != null) {
			ck  = 1;
		}else if(email == null || id != null) {
			ck = 2;
		}
		if(ck == 1) {
			check = mdao.emailck(email);
			PrintWriter out = response.getWriter();
			if(check == 1) {
				System.out.println("check!!!! 1111");//중복
				out.println("1");
			}else if(check == 2) {
				System.out.println("check!!!! 2222");//중복아님11
				out.println("2");
			}
		}else if(ck == 2 ) {
			check = mdao.idck(id);
			PrintWriter out = response.getWriter();
			if(check == 1) {
				System.out.println("check!!!! 1111");//중복
				out.println("1");
			}else if(check == 2) {
				System.out.println("check!!!! 2222");//중복아님11
				out.println("2");
			}
		}
		return null;
	}
	

}
