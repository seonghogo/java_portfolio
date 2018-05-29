<%@page import="java.io.PrintWriter"%>
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
		int b_num = Integer.parseInt(request.getParameter("b_num"));
	%>
			<%
		String id = (String)session.getAttribute("admin");
	
			if(id == null){
				PrintWriter ot = response.getWriter();
				ot.println("<script>");
				ot.println("alert('관리자만 작성가능')");
				ot.println("history.back();");
				ot.println("</script>");
				ot.close();
			}
	%>
		<form action="./B_updatePro.bo" method="post">
		
		<input type="text" value="<%=bb.getB_title()%>" name="title"><br>		
		<textarea name="contents" cols="50" rows="13"><%=bb.getB_contents() %></textarea>
		<input type="submit" value="수정" >
		<input type="button" value="삭제" >
	<input type="button" value="목록" onclick="location.href='./B_listView.bo'">
		<input type="hidden" value="<%=b_num%>" name="b_num">
		
		</form>
					
		



</body>
</html>