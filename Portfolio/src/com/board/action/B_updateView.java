package com.board.action;

import java.io.PrintWriter;
import java.security.MessageDigest;
import java.util.ArrayList;

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
		String pass = request.getParameter("pass");
		int check =0;
		BoardBean bb = new BoardBean();
		BoardDAO bdao = new BoardDAO();
		response.setContentType("text/html; charset=UTF-8");
		
		
		
		ArrayList<String[]> result = new ArrayList();
		String SHA = "";
		String password = "";

		// 입력받은 비밀번호가 있을경우의 분기점
		if (request.getParameter("pass") != null && !request.getParameter("pass").equals("")) {

			//입력받은 비밀번호를 String 타입으로 저장
			password = request.getParameter("pass").toString();

			//암호화SHA-256 인스턴스 생성
			MessageDigest sh = MessageDigest.getInstance("SHA-256");

			//입력받은 비밀번호의 암호화를 실행
			sh.update(password.getBytes()); //지정된 바이트를 사용하여 요약을 갱신합니다.
			byte[] byteData = sh.digest(); //패딩과 같은 최종 작동을 수행하여 해시 계산을 완료합니다.
			StringBuffer sb = new StringBuffer();

			//압호화된 데이터를 생성한 공간에 보관
			for (int i = 0; i < byteData.length; i++) {
				sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
			}
			//암호화된 데이터를 String 타입으로 저장

			SHA = sb.toString();
		} else {
			SHA = "";
		}
		
		
		check = bdao.updatepassck(SHA);
		
		if(check == 1) {
			
			bb= bdao.update(num);
			request.setAttribute("b_update", bb);
			forward.setPath("./B_updateAction.bo");
		}else {
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('비밀번호가 다릅니다.')");
			out.println("history.back();");
			out.println("</script>");
			out.close();
		}
		return forward;
	}
	

}
