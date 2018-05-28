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
		
//		int pageSize = 10;
//		String pageNum = request.getParameter("pageNum");
//		String col = request.getParameter("col");
//		
//		
//		
//		
//		if (pageNum == null) {
//			pageNum = "1";
//		}
//
//		// 가져올 페이지의 시작행 구하기 1페이지 1행 2페이지 11행 3페이지 21행
//		int currentPage = Integer.parseInt(pageNum);
//		int startRow = (currentPage - 1) * pageSize + 1;
//		// 게시판 디비에서 글가져오기 시작행 ,한페이지 가져올 글 개수
//		
//		int count = 0;
//		
//		int pageCount = count / pageSize + (count % pageSize == 0 ? 0 : 1);
//
//		int pageBlock = 10;
//
//		int startPage = ((currentPage - 1) / pageBlock) * pageBlock + 1;
//		int endPage = startPage + pageBlock - 1;
//		if (endPage > pageCount) {
//			endPage = pageCount;
//		}		

		
		
		BoardDAO bdao = new BoardDAO();
		ArrayList<BoardBean> list = new ArrayList<>();
		list = bdao.list();
		
		request.setAttribute("b_list", list);
		
		forward.setPath("./B_listAction.bo");
		

		return forward;
	}


}
