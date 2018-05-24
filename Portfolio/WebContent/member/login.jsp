<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
		<form action="./LoginPro.me" method="post">
			<input type="text" value="" name="id">
			<input type="password" value="" name = "pass">
			<input type="submit" value="로그인">
			<input type="button" value="회원가입" onclick="location.href='./JoinAction.me'">	
			<input type="button" value="메인" onclick="location.href='./Main.me'">	
		</form>
</body>
</html>