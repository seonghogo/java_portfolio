<%@page import="com.member.db.MemberBean"%>
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
		/* ArrayList list = (ArrayList)request.getAttribute("userlist"); */
		ArrayList list = (ArrayList)session.getAttribute("list");
		MemberBean mb = null; 
			if(admin == null){
				PrintWriter ot = response.getWriter();
				ot.println("<script>");
				ot.println("alert('������ �̿ܿ� �����Ҽ������ϴ�.')");
				ot.println("history.back();");
				ot.println("</script>");
				ot.close();
			}
	%>
		<form action="./UserDelPro.us" method="post">
		<%
			for(int i =0 ; i<list.size();i++){
				mb = new MemberBean();
				mb = (MemberBean)list.get(i);
				String ad = mb.getId();
		%>
			<%
				if(!ad.equals("admin")){
			%>			
			<%=mb.getNum()%>
			<%=mb.getId() %>
			<%=mb.getJoindate() %>
			<%=mb.getLogindate() %>
			<input type="hidden" value="<%=mb.getId()%>" name="id">
			<input type="hidden" value="<%=mb.getNum()%>" name="num">
			<input type="submit" value="�߹�"	>
			<br>
			<%}%>
		<%} %>			
			<input type="button" value="����" onclick="location.href='./Main.me'">
		
		</form>
		
</body>
</html>