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
// 			alert('���̵� �Է����ּ���');
// 			return;
// 		}else if(i.pass.value == ""){
// 			alert('��й�ȣ�� �Է����ּ���');
// 			return;
// 		}else if(i.repass.value == ""){
// 			alert('Ȯ�� �� ��й�ȣ�� �Է����ּ���.');
// 			return;
// 		}else if(i.repass.value == i.pass.value){
// 			alert('�Է��Ͻ� ��й�ȣ�� �ٸ��ϴ� �ٽ� �Է����ּ���');
// 			return;
// 		}else if(i.name.value == ""){
// 			alert('�̸��� �Է����ּ���');
// 			return;
// 		}else if(i.email.value == ""){
// 			alert('�̸����� �Է����ּ���');
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
// 						 $("#passck").val("��asdȣ��ġ").css({"color":"blue","font-weight":"bold","font-size":"15px"});
// 					}
// 				}
// 			});
// 		}
// 	}
	
	
// 	 $(document).ready(function () {
// 		   $("#repass").keyup(function (e) {
// 			   alert('a');
// 		    if($("#pass").val() == "") {
// 		     $("#passck").val("��й�ȣ�� �����Դϴ�!").css({"color":"red","font-size":"15px"});
// 		     $("#pwd").focus();
// 		    } else {
// 		     if ($("#pass").val() == $("#repass").val()) {
// 		      $("#passck").val("��й�ȣ��ġ").css({"color":"blue","font-weight":"bold","font-size":"15px"});
// 		     } else {
// 		      $("#passck").val("��й�ȣƲ��").css({"color":"red","font-weight":"bold","font-size":"15px"});
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
					 $(".idck").val("��asdȣ��ġ").css({"color":"blue","font-weight":"bold","font-size":"15px"});
				}else if(data == 2){
					 $("#idck").val("��asdȣ��ġ").css({"color":"red","font-weight":"bold","font-size":"15px"});
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
			
			<input type="button" value="����" onclick="joinck()">
			<input type="button" value="����" onclick="location.href='./Main.me'">
		
		</form>
</body>
</html>