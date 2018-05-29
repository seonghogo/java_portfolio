<%@page import="com.portfolio.db.P_folioBean"%>
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
	function passckdel(pb) {
		if(document.slef.pass.value==""){
			alert("비밀번호 입력해주세요");
		}else{
			document.slef.action= "./P_deletePro.ad?p_num="+pb; 
			document.slef.submit(); 

// 			location.href="B_deletePro.bo?b_num="+bb;
		}
	}
</script>
<body>
		<%
		P_folioBean pb = (P_folioBean)request.getAttribute("p_sel");
		String id = (String)session.getAttribute("user");
		String admin = (String)session.getAttribute("admin");
		
		String b_id = "";
		int ck = 0;
	%>
	<form action="./P_updateView.ad?p_num=<%=pb.getP_num()%>" method="post" name="slef">
		<img src="./fileupload/<%=pb.getImg()%>" />
		<%=pb.getP_num() %>
		<input type="text" style="border: none" readonly="readonly"	value=""><br>	
		<input type="text" style="border: none" readonly="readonly"	value="<%=pb.getP_title()%>"><br>	
		<input type="text" style="border: none"	readonly="readonly" value="<%=pb.getP_contents()%>"><br>			
		<input type="text" style="border: none"	readonly="readonly" value="<%=pb.getP_date()%>"><br>			
		
<!-- 		<input type="text" id="passck" value="" style="border: none" readonly="readonly">	<br>	 -->
	
		<%
			if(admin != null){
		%>	
		<input type="password" id="pass" name="pass" value="">	<br>
		<input type="button" value="수정" onclick="ck()">
		<input type="button" value="삭제" onclick="passckdel(<%=pb.getP_num()%>)">
		<%
		}else{
		%>
		<input type="button" value="목록" onclick="location.href='./P_listView.ad'">	
		<%} %>
	</form>
</body>
</html>