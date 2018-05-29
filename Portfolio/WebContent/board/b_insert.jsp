<%@page import="java.io.PrintWriter"%>
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
	<form action="./B_insertPro.bo" method="post"><br>
		제목<input type="text" value="" name="title"><br>
		<textarea name="contents" cols="50" rows="13"></textarea>
		
		<input type="submit" value="글쓰기">
		<input type="reset" value="다시쓰기" >	
		<input type="button" value="취소" onclick="location.href='./B_listView.bo'">	
	
	
	</form>
</body>
</html>