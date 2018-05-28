package com.member.action;


import java.security.MessageDigest;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.member.db.MemberBean;
import com.member.db.MemberDAO;


public class JoinPro implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		
		request.setCharacterEncoding("UTF-8");
		
		forward = new ActionForward();
		forward.setRedirect(true);
		
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		System.out.println(id+pass+name+email);
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
		System.out.println(SHA);
		MemberBean mb = new MemberBean();
		MemberDAO mdao = new MemberDAO();
		
		
		int check = mdao.join(id,SHA,name,email);
		
		if(check == 1) {
			forward.setPath("./Main.me");
		}else if(check == 2) {
			forward.setPath("./Main.me");
		}
		
		
		
		
		
		
		
		
		
		
		return forward;
	}
	
	

}
