package com.portfolio.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.db.BoardDAO;
import com.portfolio.db.P_folioBean;
import com.portfolio.db.P_folioDAO;

public class P_updatePro implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		
		String title = request.getParameter("title");
		String contents = request.getParameter("contents");
		int p_num = Integer.parseInt(request.getParameter("p_num"));
		
		P_folioDAO pdao = new P_folioDAO();
		pdao.p_update(title,contents,p_num);
		
		
		forward.setPath("./P_listView.ad");
		return forward;
	}
	

}
