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
	var i = document.insertf;
	function ck() {
		if(document.insertf.title.value == ""){
			alert("���� �Է����ּ���.");
			return;
		}else if(document.insertf.contents.value == ""){
			alert("���� �Է����ּ���.");
			return;
		}else{
			document.insertf.submit();
		}
	}

</script>
<body>
	<form action="./P_insertPro.ad" method="post" name="insertf" enctype="multipart/form-data">
		<select class="item" name="item">
     <option value="1" selected="selected">Java</option>
     <option value="2">Ruby</option>
     <option value="3">�׿�</option>
    </select>
		<input type="text" value="" name="title">
		<input type="text" value="" name="contents">
		<input type="file" name="file">
		<input type="button" value="�߰�" onclick="ck()">
		<input type="reset" value="�ٽþ���" >	
		<input type="button" value="���" onclick="location.href='./B_listView.bo'">	
	</form>
</body>
</html>