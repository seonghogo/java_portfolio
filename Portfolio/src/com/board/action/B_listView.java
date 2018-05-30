package com.board.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.board.db.BoardBean;
import com.board.db.BoardDAO;

public class B_listView implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		
		int ck = Integer.parseInt(request.getParameter("num"));
		System.out.println(ck);
		System.out.println("전체회원");
		int pageSize = 8;
		int pageBlock = 3;
		String pageNum = request.getParameter("pageNum");
		if(pageNum == null){
			pageNum = "1";
		}
		int currentpage = Integer.parseInt(pageNum);
		int startRow=(currentpage-1)*pageSize+1;
		int endRow=currentpage*pageSize;
		int count=ado.getBoardCount();
		
		int pageCount = count/pageSize + (count%pageSize == 0?0:1);
		int startPage=((currentpage-1)/pageBlock)*pageBlock+1;
		int endPage = startPage+pageBlock-1;
	       if(endPage > pageCount){
	        	endPage=pageCount;
	        
	        }
		
		
		BoardDAO bdao = new BoardDAO();
		ArrayList<BoardBean> list = new ArrayList<>();
		list = bdao.list();
		
		request.setAttribute("b_list", list);
		
		forward.setPath("./B_listAction.bo");
		

		return forward;
	}


}
