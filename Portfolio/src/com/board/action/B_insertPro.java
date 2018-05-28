package com.board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.board.db.BoardDAO;

public class B_insertPro implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		
		HttpSession session = request.getSession();
		
		String id = (String)session.getAttribute("user");
		String title = request.getParameter("title");
		String contents = request.getParameter("contents");
		int check = 0;
		BoardDAO bdao = new BoardDAO();
		check = bdao.b_insert(id,title,contents);
		
		
		if(check == 1) {
			forward.setPath("./B_listView.bo");
		}
		
		
		
		
		// TODO Auto-generated method stub
		return forward;
	}
	

}
