<%@page import="java.io.PrintWriter"%>
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
		String id =(String)session.getAttribute("user");
	
		if(id == null){
			PrintWriter ot = response.getWriter();
			ot.println("<script>");
			ot.println("alert('로그인해주세요')");
			ot.println("history.back();");
			ot.println("</script>");
			ot.close();
		}
	%>
	
	<form action="./M_DeletePro.me" method="post">
			<input type="text" value="<%=id %>" name="id">
			<input type="password" value="" name = "pass">
			<input type="submit" value="탈퇴">
			<input type="button" value="메인" onclick="location.href='./Main.me'">	
	</form>
	
	
</body>
</html>