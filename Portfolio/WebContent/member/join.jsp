<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<script type="text/javascript">
	function joinck() {
		
	}

</script>
<body>
		<form action="./JoinPro.me" method="post">
			<input type="text" value="" name="id">
			<input type="password" value="" name="pass">
			<input type="password" value="" name="repass">
			<input type="text" value="" name="name">
			<input type="email" value="" name="email">
			
			<input type="submit" value="가입" onclick="joinck()">
			<input type="button" value="메인" onclick="location.href='./Main.me'">
		
		</form>
</body>
</html>