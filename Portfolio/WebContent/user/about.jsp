<%@page import="com.about.db.AboutBean"%>
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
		AboutBean ab = (AboutBean)request.getAttribute("about");
		int ck = 0;
	%>
	
		<form action="./Aboutin.us" method="post" enctype="multipart/form-data">
	<%
		if(ab == null){
			ck = 1;
	%>
	<%=ck %>
		<textarea name="contents1" cols="50" rows="13">내용이 없습니다 입력해주세요</textarea><br>
		<input type="file" name="file1"><br>
		<input type="button" value="메인"onclick="location.href='./Main.me'">
		<input type="hidden" value="<%=ck%>" name="check">
		<input type="submit" value="수정 및 등록">
		<%}else{
			ck = 2;	
		%>
				<textarea name="contents2" cols="50" rows="13"><%=ab.getA_contents() %></textarea><br>
				<img src="./fileupload/<%=ab.getImg()%>" />
		<input type="file" name="file2"><br>
		<input type="hidden" value="<%=ck %>" name="check">
		<input type="button" value="메인" onclick="location.href='./Main.me'">
		<input type="submit" value="수정 및 등록">
		<%} %>			
		</form>
</body>
</html>