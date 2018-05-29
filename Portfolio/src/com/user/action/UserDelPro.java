package com.user.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.user.db.UserDAO;

public class UserDelPro implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		response.setContentType("text/html; charset=UTF-8");
		int num = Integer.parseInt(request.getParameter("num"));
		String id = request.getParameter("id");
		UserDAO udao = new UserDAO();
		int check = 0;
		check = udao.del(num,id);
		
		if(check == 1) {
			forward.setPath("./Main.me");
		}else if(check == 2) {
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('없는 정보입니다. 다시 확인해주세요.')");
			out.println("history.back();");
			out.println("</script>");
			out.close();
		}
		
		return forward;
	}
	

}
