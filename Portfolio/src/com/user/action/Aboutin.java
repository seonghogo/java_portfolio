package com.user.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.about.db.AboutBean;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.user.db.UserDAO;

public class Aboutin implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		ActionForward forward = new ActionForward();
		AboutBean ab =null;
		UserDAO udao = new UserDAO();
		response.setContentType("text/html; charset=UTF-8");
		 String path = request.getRealPath("/fileupload");
		int filesize = 5 * 1024 * 1024;
		MultipartRequest multi = new MultipartRequest(request, path,filesize,"UTF-8",new DefaultFileRenamePolicy());
//		int check = Integer.parseInt(request.getParameter("check"));
		int check = Integer.parseInt(multi.getParameter("check"));
		String fi = multi.getParameter("file2");
		if(check == 1) {
			ab = new AboutBean();
			ab.setImg(multi.getFilesystemName((String)multi.getFileNames().nextElement()));
			
		}else if(check == 2) {
			ab = new AboutBean();
			ab.setA_contents(multi.getParameter("contents2"));
			ab.setImg(multi.getFilesystemName((String)multi.getFileNames().nextElement()));
		}else if(check == 3) {
			ab = new AboutBean();
			ab.setA_contents(multi.getParameter("contents2"));
			ab.setImg(fi);
		}
		
		
		
		
		System.out.println(ab.getA_contents()+"1111");
		int ck = 0;
		
		ck = udao.aboutin(ab);
		
		if(ck == 1) {
			forward.setPath("./Main.me");
		}else {
			PrintWriter ot = response.getWriter();
			ot.println("<script>");
			ot.println("alert('관리자만 작성가능')");
			ot.println("history.back();");
			ot.println("</script>");
			ot.close();
		}
		
		
		return forward;
	}
	 

}
