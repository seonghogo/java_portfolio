<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<!-- 페이지에 필요한 배열 및 암호화 클래스를 호출 -->
<%@page import="java.util.ArrayList"%>
<%@page import="java.security.MessageDigest"%>

<%
	// 테스트에 필요한 배열 및 변수들 선언
	ArrayList<String[]> result = new ArrayList();
	String SHA = "";
	String password = "";

	// 입력받은 비밀번호가 있을경우의 분기점
	if (request.getParameter("password") != null && !request.getParameter("password").equals("")) {

		//입력받은 비밀번호를 String 타입으로 저장
		password = request.getParameter("password").toString();

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
%>
<!-- 암호화할 비밀번호를 입력받고 화면에 출력해주는 HTML -->
<html>
<head>
<title>SHA2Sample</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
</head>
<body>
	<form name="pswd" method="POST" action="SHA2Sample.jsp" target="result">
		<table width="700">
			<tr valign="top">
				<td>비밀번호 입력 : <input type="password" name="password" size="40"></input>
					<input type="submit" value="비밀번호 암호화실행"></input>
				</td>
			</tr>
			<tr>
				<td>암호화 비밀번호 : <input type="text" name="SHA2" size="40"
					value="<%=SHA%>"></input>
				</td>
			</tr>
			</talbe>
			</form>
</body>
</html>
</html>