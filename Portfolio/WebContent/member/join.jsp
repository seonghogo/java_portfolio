<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
						 $("#idck").val("아이디중복").css({"color":"red","font-weight":"bold","font-size":"15px"});
						 ckid = 1;
					}else if(data == 2){
						 $("#idck").val("아이디 사용 가능").css({"color":"blue","font-weight":"bold","font-size":"15px"});
						 ckid = 0;
					}
				}
			});
	}else{
		 $("#idck").val("글자수 2~10로 해주세요").css({"color":"red","font-weight":"bold","font-size":"15px"});
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
						 $("#emailck").val("이메일중복").css({"color":"red","font-weight":"bold","font-size":"15px"});
						 ckemail = 1;
					}else if(data == 2){
						 $("#emailck").val("이메일 사용 가능").css({"color":"blue","font-weight":"bold","font-size":"15px"});
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
				$("#passck").val("비밀번호 6~12로 해주세요").css({"color":"red","font-weight":"bold","font-size":"15px"});
				ckrepass = 1;
			}
	});
});
$(document).ready(function(){
	$("#repass").keyup(function(e){
		var pass = $("#pass").val();
		var repass = $("#repass").val();
		if(repass != pass){
			$("#passck").val("비밀번호가 다릅니다.").css({"color":"red","font-weight":"bold","font-size":"15px"});
			ckpass = 1;
		}else if(repass == pass){
			$("#passck").val("비밀번호가 같습니다").css({"color":"blue","font-weight":"bold","font-size":"15px"});
			ckpass = 0;
		}
	});
});


	function joinck() {
		var i = document.joinf;
		var email = i.email.value;
		var exptext = /^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/;
		if(i.id.value == ""){
			alert('아이디를 입력해주세요');
			return;
		}else if(i.pass.value == ""){
			alert('비밀번호를 입력해주세요');
			return;
		}else if(i.repass.value == ""){
			alert('확인 용 비밀번호를 입력해주세요.');
			return;
		}else if(i.repass.value != i.pass.value){
			alert('입력하신 비밀번호가 다릅니다 다시 입력해주세요');
			return;
		}else if(i.name.value == ""){
			alert('이름을 입력해주세요');
			return;
		}else if(i.email.value == "" ){
			alert('이메일을 입력해주세요');
			return;
		}else if(i.email.value != ""){
					if(!exptext.test(email)){
						alert("이 메일형식이 올바르지 않습니다.");
						return;
					}else{
						if(ckid == 1){
				 			alert("중복된 아이디입니다 다시 확인해주세요.");
				 			return;
				 		}else if(ckemail == 1){
				 			alert("중복된 이메일입니다 다시 확인해주세요.");
				 			return;
				 		}else if(ckrepass == 1){
				 			alert("비밀번호 6~12로 해주세요 ");	
				 			return;
				 		}else if(ckpass == 1){
				 			alert("비밀번호가 다릅니다.");
				 			return;
				 		}else{
				 			document.joinf.submit();
				 		}
					}
		}
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
			readonly="readonly"> <input type="button" value="가입"
			onclick="joinck()"> <input type="button" value="메인"
			onclick="location.href='./Main.me'">

	</form>
</body>
</html>