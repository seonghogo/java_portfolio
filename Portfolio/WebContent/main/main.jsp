<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String id = (String)session.getAttribute("user");
		String admin = (String)session.getAttribute("admin");
	%>
		<form>
			<%
			if(id==null && admin == null){
			%>
				<input type="button" value="로그인" onclick="location.href='./LoginAction.me'" >	
			<input type="button" value="회원가입" onclick="location.href='./JoinAction.me'">	
			<%

			}else if(id != null && admin == null){


			%>
				<input type="button" value="포트폴리오" onclick="location.href='./P_listView.ad'">
				<input type="button" value="코드 게시판" onclick="location.href='./B_listView.bo'">
				<input type="button" value="수정" onclick="location.href='./M_updateView.me'">
				<input type="button" value="로그아웃" onclick="location.href='./logout.me'">
				<input type="button" value="탈퇴" onclick="location.href='./M_deleteAction.me'">
				
			<%	

			}else if(id == null && admin != null){
			 %>
				<input type="button" value="자기소개 수정 및 등록" onclick="location.href='./AboutView.us'">
				<input type="button" value="회원관리" onclick="location.href='./UserList.us'">
				<input type="button" value="포트폴리오 관리" onclick="location.href='./P_listView.ad'">
				<input type="button" value="코드 게시판 관리" onclick="location.href='./B_listView.bo'">
			 	<input type="button" value="로그아웃" onclick="location.href='./logout.me'">
			<%
			}
			%>				
		</form>
</body>
</html>