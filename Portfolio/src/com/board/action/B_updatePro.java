package com.board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.db.BoardDAO;

public class B_updatePro implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		
		String title = request.getParameter("title");
		String contents = request.getParameter("contents");
		int b_num = Integer.parseInt(request.getParameter("b_num"));
		BoardDAO bdao = new BoardDAO();
		
		bdao.b_update(title,contents,b_num);
		
		forward.setPath("./B_listView.bo");
		return forward;
	}
	

}
