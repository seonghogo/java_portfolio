<%@page import="com.portfolio.db.P_folioBean"%>
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
<script src="//code.jquery.com/jquery.js"></script>
<body>
	<%
		P_folioBean pb = (P_folioBean)request.getAttribute("p_update");
		int num = Integer.parseInt(request.getParameter("p_num"));
	%>
			<%
		String id = (String)session.getAttribute("admin");
	
			if(id == null){
				PrintWriter ot = response.getWriter();
				ot.println("<script>");
				ot.println("alert('�����ڸ� �ۼ�����')");
				ot.println("history.back();");
				ot.println("</script>");
				ot.close();
			}
	%>
		<form action="./P_updatePro.ad" method="post">
		
		<input type="text" value="<%=pb.getP_title()%>" name="title"><br>		
		<textarea name="contents" cols="50" rows="13"><%=pb.getP_contents() %></textarea>
		<input type="submit" value="����" >
<!-- 		<input type="button" value="����"> -->
	<input type="button" value="���" onclick="location.href='./P_listView.ad'">
		<input type="hidden" value="<%=num%>" name="p_num">
		
		</form>
					
		



</body>
</html>