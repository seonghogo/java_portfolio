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
		String admin = (String)session.getAttribute("admin");
	
			if(admin == null){
				PrintWriter ot = response.getWriter();
				ot.println("<script>");
				ot.println("alert('�����ڸ� �ۼ�����')");
				ot.println("history.back();");
				ot.println("</script>");
				ot.close();
			}
	%>
		<input type="submit" value="��Ʈ������ �߰�" onclick="location.href='p_insert.ad'">
</body>
</html>