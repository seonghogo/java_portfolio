<%@page import="java.util.ArrayList"%>
<%@page import="com.board.db.BoardBean"%>
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
		String admin = (String)session.getAttribute("admin");
		ArrayList list = (ArrayList)request.getAttribute("b_list");
		BoardBean bb = null;
	%>
		<form action="./B_selectView.bo" method="post">
	<%
					for(int i =0; i<list.size();i++){
						 bb = new BoardBean();
						bb = (BoardBean)list.get(i);
	%>
							<%=bb.getB_num() %>
							<%=bb.getB_id() %>
							<a href="./B_selectView.bo?b_num=<%=bb.getB_num()%>"><%=bb.getB_title()%></a>
							<%=bb.getB_count() %>
							<%=bb.getB_date() %>
							<br>
	<%				
					}
	%>
	
		
		<input type="hidden" value="<%=bb.getB_num() %>" name="b_num">
		<%
			if(admin != null){
		%>
		<input type="button" value="글쓰기" onclick="location.href='./B_insertAction.bo'">
		<%} %>		
			
			<input type="button" value="메인" onclick="location.href='./Main.me'">	
		</form>
		
	
</body>
</html>