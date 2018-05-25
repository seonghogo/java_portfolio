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
		BoardBean bb = (BoardBean)request.getAttribute("b_sel");
	%>
	
	
	<form>
		<input type="text" style="border: none" readonly="readonly"	value="<%=bb.getB_title()%>">			
		<input type="text" style="border: none"	readonly="readonly" value="<%=bb.getB_contents()%>">			
		<input type="text" style="border: none"	readonly="readonly" value="<%=bb.getB_id()%>">			
		<input type="text" style="border: none"	readonly="readonly" value="<%=bb.getB_date()%>">			
		<input type="text" style="border: none"	readonly="readonly" value="<%=bb.getB_count()%>">		
		
		<input type="button" value="목록" onclick="location.href='./B_listView.bo'"> 	
		<input type="button" value="수정" onclick="location.href='./B_updateView.bo?b_num=<%=bb.getB_num()%>'"> 	
<!-- 		<input type="button" value="삭제" onclick="location.href='./B_listView.bo'"> 	 -->
	</form>
</body>
</html>