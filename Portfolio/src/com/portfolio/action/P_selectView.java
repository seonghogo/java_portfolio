package com.portfolio.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.portfolio.db.P_folioBean;
import com.portfolio.db.P_folioDAO;

public class P_selectView implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		
		int num = Integer.parseInt(request.getParameter("p_num"));
		P_folioBean pb = new P_folioBean();
		P_folioDAO pdao = new P_folioDAO();
		
		pb = pdao.select(num);
		
		request.setAttribute("p_sel", pb);
		forward.setPath("./P_selectAction.ad");
		
		return forward;
	}
	

}
