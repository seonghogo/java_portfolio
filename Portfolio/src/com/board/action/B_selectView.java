package com.board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.db.BoardBean;
import com.board.db.BoardDAO;

public class B_selectView implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		System.out.println("B_selectView.bo-java");
		int num = Integer.parseInt(request.getParameter("b_num"));
		System.out.println(num);
		BoardBean bb = new BoardBean();
		BoardDAO bdao = new BoardDAO();
		
		bb = bdao.b_select(num);
		
		request.setAttribute("b_sel", bb);
		forward.setPath("./B_slelectAction.bo");
		
		return forward;
	}
	

}
