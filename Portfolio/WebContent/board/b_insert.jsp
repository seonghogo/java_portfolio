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
		String id = (String)session.getAttribute("user");
	
			if(id == null){
				PrintWriter ot = response.getWriter();
				ot.println("<script>");
				ot.println("alert('�α����� ����� �ۼ�����')");
				ot.println("history.back();");
				ot.println("</script>");
				ot.close();
			}
	%>
	<form action="./B_insertPro.bo" method="post"><br>
		����<input type="text" value="" name="title"><br>
		<textarea name="contents" cols="50" rows="13"></textarea>
		
	

		<input type="submit" value="�۾���">
		<input type="reset" value="�ٽþ���" >	
		<input type="button" value="���" onclick="location.href='./B_listView.bo'">	
	
	
	</form>
</body>
</html>