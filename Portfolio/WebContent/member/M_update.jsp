<%@page import="java.io.PrintWriter"%>
<%@page import="com.member.db.MemberBean"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<script src="//code.jquery.com/jquery.js"></script>
<script type="text/javascript">
var ckemail = 0;
$(document).ready(function(){
	  $("#email").keyup(function (e) {
	var email = $("#email").val();
	
//	if(email.length>=2 && email.length<=10){
		 $.ajax({
				async:false,
				type:"post",
				url:"joinck.me",
				data:{"email" : email},
				dataType:"json",
				success:function(data){
					if(data == 1){
						 $("#emailck").val("�̸����ߺ�").css({"color":"red","font-weight":"bold","font-size":"15px"});
						 ckemail = 1;
					}else if(data == 2){
						 $("#emailck").val("�̸��� ��� ����").css({"color":"blue","font-weight":"bold","font-size":"15px"});
						 ckemail = 0;
					}
				}
			});
	  });
});

function update(ck) {
	var i = document.updatef;
	var email = i.email.value;
	var exptext = /^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/;
	if(i.pass.value == ""){
		alert('��й�ȣ�� �Է����ּ���');
		return;
	}else if(i.email.value != ""){
		if(ck != i.email.value){
			if(!exptext.test(email)){
				alert("�� ���������� �ùٸ��� �ʽ��ϴ�.");
				return;
			}else if(ckemail == 1){
				alert('�ߺ��� �̸����Դϴ�.');
				return;
			}else{
				i.submit();
			}
		}else{
			i.submit();
		}
	}
}

</script>
<body>
	<%
		String id = (String)session.getAttribute("user");
		MemberBean mb = (MemberBean)request.getAttribute("U_view");
	%>
	
	<%
		if(id == null){
			PrintWriter ot = response.getWriter();
			ot.println("<script>");
			ot.println("alert('�α������ּ���')");
			ot.println("history.back();");
			ot.println("</script>");
			ot.close();
		}
	%>
	
	<form action="./M_updatePro.me" method="post" name="updatef">
			ID<input type="text" value="<%=mb.getId() %>" name="id" style="border: none"
			readonly="readonly"><br>
			Name<input type="text" value="<%=mb.getName() %>" name="name"><br>
			Email<input type="email" value="<%=mb.getEmail() %>" name="email" id="email"><br>
			<input type="text" name="emailck" id="emailck" value="" style="border: none" readonly="readonly"><br>
			Join<input type="text" value="<%=mb.getJoindate() %>" style="border: none"
			readonly="readonly"><br>
			Login<input type="text" value="<%=mb.getLogindate() %>" style="border: none"
			readonly="readonly"><br>
			
			Pass<input type="password" value="" name="pass">
			
			
			<input type="button" value="����" onclick="update('<%=mb.getEmail()%>')">
			<input type="button" value="����" onclick="location.href='./Main.me'">
		
		</form>
	
	
</body>
</html>