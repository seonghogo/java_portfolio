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
		String admin = (String)session.getAttribute("admin");
	%>
		<form>
			<%
			if(id==null && admin == null){
			%>
				<input type="button" value="濡�洹몄��" onclick="location.href='./LoginAction.me'" >	
			<input type="button" value="����媛���" onclick="location.href='./JoinAction.me'">	
			<%

			}else if(id != null && admin == null){


			%>

				<input type="button" value="��Ʈ���" onclick="location.href='./P_listView.ad'">
				<input type="button" value="�ڵ� �Խ���" onclick="location.href='./B_listView.bo'">
				<input type="button" value="���" onclick="location.href='./M_updateView.me'">
				<input type="button" value="�α׾ƿ�" onclick="location.href='./logout.me'">
				<input type="button" value="Ż��" onclick="location.href='./M_deleteAction.me'">
				

			<%	

			}else if(id == null && admin != null){
			 %>

			 
				<input type="button" value="�ڱ�Ұ� ��� �� ���" onclick="location.href='./AboutView.us'">
				<input type="button" value="ȸ���" onclick="location.href='./UserList.us'">
				<input type="button" value="��Ʈ����" onclick="location.href='./P_listView.ad'">
				<input type="button" value="�ڵ� ��" onclick="location.href='./B_listView.bo'">
			 	<input type="button" value="�α׾ƿ�" onclick="location.href='./logout.me'">

			 
			<%
			}
			%>				
		</form>
</body>
</html>