<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
	<script type="text/javascript">
		function loginck() {
			var i = document.loginf;
			
			if(i.id.value==""){
				alert("���̵� �Է����ּ���");
				return;
			}else if(i.pass.value == ""){
				alert("��й�ȣ �Է����ּ���");
				return;
			}else{
				i.submit();
			}
		}
	
	</script>



<body>
		<form action="./LoginPro.me" method="post" name="loginf">
			<input type="text" value="" name="id">
			<input type="password" value="" name = "pass">
			<input type="button" value="�α���" onclick="loginck()">
			<input type="button" value="ȸ������" onclick="location.href='./JoinAction.me'">	
			<input type="button" value="����" onclick="location.href='./Main.me'">	
		</form>
</body>
</html>