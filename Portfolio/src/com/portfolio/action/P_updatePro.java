package com.portfolio.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.db.BoardDAO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.portfolio.db.P_folioBean;
import com.portfolio.db.P_folioDAO;

public class P_updatePro implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		String path = request.getRealPath("/fileupload");
		int filesize = 5 * 1024 * 1024;
		MultipartRequest multi = new MultipartRequest(request, path,filesize,"UTF-8",new DefaultFileRenamePolicy());
		
		String title = multi.getParameter("title");
		String contents = multi.getParameter("contents");
		int p_num = Integer.parseInt(multi.getParameter("p_num"));
		String file = multi.getFilesystemName((String)multi.getFileNames().nextElement());
	
		
		
		
		P_folioDAO pdao = new P_folioDAO();
		pdao.p_update(title,contents,p_num,file);
		
		
		forward.setPath("./P_listView.ad");
		return forward;
	}
	

}
