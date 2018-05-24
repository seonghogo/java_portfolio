package com.member.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.member.db.MemberDAO;

public class joinck implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		
		String id = request.getParameter("id");
		MemberDAO mdao = new MemberDAO();
		int check = 0;
		
		check = mdao.idck(id);
		
		PrintWriter out = response.getWriter();
		JSONObject obj = new JSONObject();
		if(check == 1) {
			obj.put("idck", check);
			out.println("1");
		}else if(check == 2) {
			obj.put("idck", check);
			out.println("2");
		}
			out.close();
				System.out.println(check);
		
		return null;
	}
	

}
