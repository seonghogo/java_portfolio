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
	%>
		<form>
			<%
			if(id==null){
			%>
				<input type="button" value="�α���" onclick="location.href='./LoginAction.me'" >	
			<input type="button" value="ȸ������" onclick="location.href='./JoinAction.me'">	
			<%
			}else{
			%>
				<input type="button" value="����" onclick="location.href='./M_updateView.me'">
				<input type="button" value="�α׾ƿ�" onclick="location.href='./logout.me'">
				<input type="button" value="Ż��" onclick="location.href='./M_deleteAction.me'">
			<%	
			}
			 %>
		</form>
</body>
</html>