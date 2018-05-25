package com.board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.db.BoardBean;
import com.board.db.BoardDAO;

public class B_updateView implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		int num = Integer.parseInt(request.getParameter("b_num"));
		BoardBean bb = new BoardBean();
		BoardDAO bdao = new BoardDAO();
		
		bb= bdao.update(num);
		
		request.setAttribute("b_update", bb);
		
		forward.setPath("./B_updateAction.bo");
		
		return forward;
	}
	

}
