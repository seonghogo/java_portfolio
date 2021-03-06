package com.portfolio.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.portfolio.db.P_folioBean;
import com.portfolio.db.P_folioDAO;

public class P_listView implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		
		
		
		ArrayList<P_folioBean> list = new ArrayList<>();
		P_folioDAO pdao = new P_folioDAO();
		
		list = pdao.list();
		
		request.setAttribute("plist", list);
		forward.setPath("./P_listAction.ad");
		
		
		
		return forward;
	}
	

}
