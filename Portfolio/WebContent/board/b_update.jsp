<%@page import="com.board.db.BoardBean"%>
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
		BoardBean bb = (BoardBean)request.getAttribute("b_update");
	%>
		
		<form action="./B_updatePro.bo" method="post">
		
		<input type="text" value="<%=bb.getB_title()%>">			
		<input type="text" value="<%=bb.getB_contents()%>">
		
		<input type="submit" value="수정" >
		<input type="button" value="삭제" >
		
		
		</form>
					
		



</body>
</html>