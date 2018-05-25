<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%
		String id = (String)session.getAttribute("user");
	%>
		<form>
			<%
			if(id==null){
			%>
				<input type="button" value="로그인" onclick="location.href='./LoginAction.me'" >	
			<input type="button" value="회원가입" onclick="location.href='./JoinAction.me'">	
			<%
			}else{
			%>
				<input type="button" value="게시판" onclick="location.href='./B_listView.bo'">
				<input type="button" value="수정" onclick="location.href='./M_updateView.me'">
				<input type="button" value="로그아웃" onclick="location.href='./logout.me'">
				<input type="button" value="탈퇴" onclick="location.href='./M_deleteAction.me'">
			<%	
			}
			 %>
		</form>
</body>
</html>