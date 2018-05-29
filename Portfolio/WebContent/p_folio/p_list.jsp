<%@page import="com.portfolio.db.P_folioBean"%>
<%@page import="java.util.ArrayList"%>
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
		ArrayList list = (ArrayList)request.getAttribute("plist");
		P_folioBean pb = null;

	%>
		<form action="./B_selectView.bo" method="post">
		<%
			for(int i=0; i<list.size(); i++){
				pb = new P_folioBean();
				pb = (P_folioBean)list.get(i);
		%>
			<%=pb.getP_num() %>
			<a href="./P_selectView.ad?p_num=<%=pb.getP_num()%>"><%=pb.getP_title() %></a>
			<%=pb.getP_contents() %>
			<%=pb.getP_date() %>
			<%=pb.getItem() %>
			<br>
		<%} %>				
		
		<%
		if(admin != null){
		%>
		<input type="button" value="포트폴리오 추가" onclick="location.href='p_insert.ad'">
		<%} %>		
		<input type="button" value="메인" onclick="location.href='Main.me'">
		</form>
</body>
</html>