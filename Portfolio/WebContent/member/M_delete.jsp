<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<script type="text/javascript">
	function del() {
		var i = document.delf;
		
		if(i.pass.value == ""){
			alert('��й�ȣ �Է����ּ���');
		}else{
			i.submit();
		}
	}

</script>
<body>
	<%
		String id =(String)session.getAttribute("user");
	
		if(id == null){
			PrintWriter ot = response.getWriter();
			ot.println("<script>");
			ot.println("alert('�α������ּ���')");
			ot.println("history.back();");
			ot.println("</script>");
			ot.close();
		}
	%>
	
	<form action="./M_DeletePro.me" method="post" name="delf">
			<input type="text" value="<%=id %>" name="id" style="border: none"
			readonly="readonly"><br>
			<input type="password" value="" name = "pass"><br>
			<input type="button" value="Ż��" onclick="del()">
			<input type="button" value="����" onclick="location.href='./Main.me'">	
	</form>
	
	
</body>
</html>