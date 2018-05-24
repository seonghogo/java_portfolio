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
// 	function joinck() {
// 		var i = document.joinf;
// 		if(i.id.value == ""){
// 			alert('아이디를 입력해주세요');
// 			return;
// 		}else if(i.pass.value == ""){
// 			alert('비밀번호를 입력해주세요');
// 			return;
// 		}else if(i.repass.value == ""){
// 			alert('확인 용 비밀번호를 입력해주세요.');
// 			return;
// 		}else if(i.repass.value == i.pass.value){
// 			alert('입력하신 비밀번호가 다릅니다 다시 입력해주세요');
// 			return;
// 		}else if(i.name.value == ""){
// 			alert('이름을 입력해주세요');
// 			return;
// 		}else if(i.email.value == ""){
// 			alert('이메일을 입력해주세요');
// 			return;
// 		}else{
			
// 		}
		
// 	}
// 	function idck(){
// 		alert('asd');
// 		 var id = document.getElementById("id").value;
// 		if(id.length<6){
// 			var id = $("#id").val();
// 			$ajax({
// 				async:false,
// 				type:'post',
// 				url:"joinck.me",
// 				data:{"id" : id},
// 				dataType:"json",
// 				success:function(data){
// 					if(data==1){
// 						 $("#passck").val("비asd호일치").css({"color":"blue","font-weight":"bold","font-size":"15px"});
// 					}
// 				}
// 			});
// 		}
// 	}
	
	
// 	 $(document).ready(function () {
// 		   $("#repass").keyup(function (e) {
// 			   alert('a');
// 		    if($("#pass").val() == "") {
// 		     $("#passck").val("비밀번호가 공백입니다!").css({"color":"red","font-size":"15px"});
// 		     $("#pwd").focus();
// 		    } else {
// 		     if ($("#pass").val() == $("#repass").val()) {
// 		      $("#passck").val("비밀번호일치").css({"color":"blue","font-weight":"bold","font-size":"15px"});
// 		     } else {
// 		      $("#passck").val("비밀번호틀림").css({"color":"red","font-weight":"bold","font-size":"15px"});
// 		     }
// 		    }
// 		   })
// 		 });
	 
	$(document).ready(function(){
		  $("#id").keyup(function (e) {
		var id = $("#id").val();
		$.ajax({
			async:false,
			type:'post',
			url:"joinck.me",
			data:{"id" : id},
			dataType:"json",
			success:function(data){
				if(data == 1){
					 $(".idck").val("비asd호일치").css({"color":"blue","font-weight":"bold","font-size":"15px"});
				}else if(data == 2){
					 $("#idck").val("비asd호일치").css({"color":"red","font-weight":"bold","font-size":"15px"});
				}
			}
		});
		  });
	 });

</script>
<body>
		<form action="./JoinPro.me" method="post" name="joinf">
			id<input type="text" value="" name="id" id="id" ><br>
			<input type="text" id="idck" name="idck" id = "idck" value="" style="border: none" readonly="readonly">
			pass<input type="password" value="" name="pass" id="pass" ><br>
			repass<input type="password" value="" name="repass" id="repass"><br>
			<input type="text" id="passck" value="" style="border: none" readonly="readonly">
			name<input type="text" value="" name="name"><br>
			email<input type="email" value="" name="email"><br>
			
			<input type="button" value="가입" onclick="joinck()">
			<input type="button" value="메인" onclick="location.href='./Main.me'">
		
		</form>
</body>
</html>