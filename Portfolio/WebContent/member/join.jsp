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
var i = document.joinf;
var ckid = 0;
var ckemail = 0;
var ckpass =0;
var ckrepass=0;


$(document).ready(function(){
	  $("#id").keyup(function (e) {
	var id = $("#id").val();
	
	if(id.length>=2 && id.length<=10){
		 $.ajax({
				async:false,
				type:"post",
				url:"joinck.me",
				data:{"id" : id},
				dataType:"json",
				success:function(data){
					if(data == 1){
						 $("#idck").val("���̵��ߺ�").css({"color":"red","font-weight":"bold","font-size":"15px"});
						 ckid = 1;
					}else if(data == 2){
						 $("#idck").val("���̵� ��� ����").css({"color":"blue","font-weight":"bold","font-size":"15px"});
						 ckid = 0;
					}
				}
			});
	}else{
		 $("#idck").val("���ڼ� 2~10�� ���ּ���").css({"color":"red","font-weight":"bold","font-size":"15px"});
	}
	  
	  });
});

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

$(document).ready(function(){
	$("#pass").keyup(function(e){
		var pass = $("#pass").val();
		var repass = $("#repass").val();
			if(pass.length>=6 && pass.length<=12){
				ckrepass = 0;
			}else{
				$("#passck").val("��й�ȣ 6~12�� ���ּ���").css({"color":"red","font-weight":"bold","font-size":"15px"});
				ckrepass = 1;
			}
	});
});
$(document).ready(function(){
	$("#repass").keyup(function(e){
		var pass = $("#pass").val();
		var repass = $("#repass").val();
		if(repass != pass){
			$("#passck").val("��й�ȣ�� �ٸ��ϴ�.").css({"color":"red","font-weight":"bold","font-size":"15px"});
			ckpass = 1;
		}else if(repass == pass){
			$("#passck").val("��й�ȣ�� �����ϴ�").css({"color":"blue","font-weight":"bold","font-size":"15px"});
			ckpass = 0;
		}
	});
});


	function joinck() {
		var i = document.joinf;
		if(i.id.value == ""){
			alert('���̵� �Է����ּ���');
			return;
		}else if(i.pass.value == ""){
			alert('��й�ȣ�� �Է����ּ���');
			return;
		}else if(i.repass.value == ""){
			alert('Ȯ�� �� ��й�ȣ�� �Է����ּ���.');
			return;
		}else if(i.repass.value != i.pass.value){
			alert('�Է��Ͻ� ��й�ȣ�� �ٸ��ϴ� �ٽ� �Է����ּ���');
			return;
		}else if(i.name.value == ""){
			alert('�̸��� �Է����ּ���');
			return;
		}else if(i.email.value == ""){
			alert('�̸����� �Է����ּ���');
			return;
		}
		else if(i.email.value != ""){
			var email = i.email.value;
			var exptext = /^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/;
					if(exptext.test(email)==false){

				//�̸��� ������ ���ĺ�+����@���ĺ�+����.���ĺ�+���� ������ �ƴҰ��			
				alert("�� ���������� �ùٸ��� �ʽ��ϴ�.");
				return;
				}
		}
		else{
			alert('asd');
// 			document.joinf.submit();
		}
// 		else if(ckid == 1){
// 			alert("�ߺ��� ���̵��Դϴ� �ٽ� Ȯ�����ּ���.");
// 			return;
// 		}else if(ckemail == 1){
// 			alert("�ߺ��� �̸����Դϴ� �ٽ� Ȯ�����ּ���.");
// 			return;
// 		}else if(ckrepass == 1){
// 			alert("��й�ȣ 6~12�� ���ּ��� ");	
// 			return;
// 		}else if(ckpass == 1){
// 			alert("��й�ȣ�� �ٸ��ϴ�.");
// 			return;
// 		}


	}
	
</script>
<body>
	<form action="./JoinPro.me" method="post" name="joinf">
		id<input type="text" value="" name="id" id="id"><br> <input
			type="text" name="idck" id="idck" value="" style="border: none"
			readonly="readonly"> pass<input type="password" value=""
			name="pass" id="pass"><br> repass<input type="password"
			value="" name="repass" id="repass"><br> <input
			type="text" id="passck" value="" style="border: none"
			readonly="readonly"> name<input type="text" value=""
			name="name"><br> email<input type="email" value=""
			name="email" id="email"><br> <input type="text"
			name="emailck" id="emailck" value="" style="border: none"
			readonly="readonly"> <input type="button" value="����"
			onclick="joinck()"> <input type="button" value="����"
			onclick="location.href='./Main.me'">

	</form>
</body>
</html>