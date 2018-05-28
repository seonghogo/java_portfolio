<%@page import="com.board.db.BoardBean"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<script type="text/javascript">
	
	function ck() {
		if(document.slef.pass.value==""){
			alert("비밀번호 입력해주세요");
		}else{
			document.slef.submit();
		}
	}
	function passckdel(bb) {
		if(document.slef.pass.value==""){
			alert("비밀번호 입력해주세요");
		}else{
			document.slef.action= "./B_deletePro.bo?b_num="+bb; 
			document.slef.submit(); 

// 			location.href="B_deletePro.bo?b_num="+bb;
		}
	}
</script>
<body>
	<%
		BoardBean bb = (BoardBean)request.getAttribute("b_sel");
		String id = (String)session.getAttribute("user");
		String admin = (String)session.getAttribute("admin");
		
		String b_id = "";
		int ck = 0;
	%>
	
	
	<form action="./B_updateView.bo?b_num=<%=bb.getB_num()%>" method="post" name="slef">
		<input type="text" style="border: none" readonly="readonly"	value="<%=bb.getB_title()%>"><br>	
		<input type="text" style="border: none"	readonly="readonly" value="<%=bb.getB_contents()%>"><br>			
		<input type="text" style="border: none"	readonly="readonly" value="<%=bb.getB_id()%>"><br>			
		<input type="text" style="border: none"	readonly="readonly" value="<%=bb.getB_date()%>"><br>			
		<input type="text" style="border: none"	readonly="readonly" value="<%=bb.getB_count()%>"><br>
		
<!-- 		<input type="text" id="passck" value="" style="border: none" readonly="readonly">	<br>	 -->
	
		<%
			if(admin != null){
		%>	
		<input type="password" id="pass" name="pass" value="">	<br>
		<input type="button" value="수정" onclick="ck()">
		<input type="button" value="삭제" onclick="passckdel(<%=bb.getB_num()%>)">
		<%
		}else{
		%>
		<input type="button" value="목록" onclick="location.href='./B_listView.bo'">	
		<%} %>
	</form>
</body>
</html>