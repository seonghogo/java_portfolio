package com.portfolio.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.portfolio.db.P_folioBean;
import com.portfolio.db.P_folioDAO;

public class P_insertPro implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		P_folioBean pb = new P_folioBean();
		response.setContentType("text/html; charset=UTF-8");
//		String title = request.getParameter("title");
//		String contents = request.getParameter("contents");
//		String item = request.getParameter("item");
//		String file = request.getParameter("file");
		 String path = request.getRealPath("/fileupload");
		int filesize = 5 * 1024 * 1024;
		int check = 0;
		
		
		MultipartRequest multi = new MultipartRequest(request, path,filesize,"UTF-8",new DefaultFileRenamePolicy());
		pb.setP_title(multi.getParameter("title"));
		pb.setP_contents(multi.getParameter("contents"));
		pb.setItem(multi.getParameter("item"));
		pb.setImg(multi.getFilesystemName((String)multi.getFileNames().nextElement()));
		
		
		System.out.println(pb.getP_title());
		P_folioDAO pdao = new P_folioDAO();
		check = pdao.p_insert(pb);
		
		if(check == 0) {
			PrintWriter ot = response.getWriter();
			ot.println("<script>");
			ot.println("alert('관리자만 작성가능')");
			ot.println("history.back();");
			ot.println("</script>");
			ot.close();
			return null;
		}else {
			forward.setPath("./Main.me");
		}
		
		return forward;
	}

}
