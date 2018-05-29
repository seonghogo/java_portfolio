<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript">
	function del() {
		var i = document.delf;
		
		if(i.pass.value == ""){
			alert('비밀번호 입력해주세요');
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
			ot.println("alert('로그인해주세요')");
			ot.println("history.back();");
			ot.println("</script>");
			ot.close();
		}
	%>
	
	<form action="./M_DeletePro.me" method="post" name="delf">
			<input type="text" value="<%=id %>" name="id" style="border: none"
			readonly="readonly"><br>
			<input type="password" value="" name = "pass"><br>
			<input type="button" value="탈퇴" onclick="del()">
			<input type="button" value="메인" onclick="location.href='./Main.me'">	
	</form>
	
	
</body>
</html>