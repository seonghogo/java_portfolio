<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<!-- �������� �ʿ��� �迭 �� ��ȣȭ Ŭ������ ȣ�� -->
<%@page import="java.util.ArrayList"%>
<%@page import="java.security.MessageDigest"%>

<%
	// �׽�Ʈ�� �ʿ��� �迭 �� ������ ����
	ArrayList<String[]> result = new ArrayList();
	String SHA = "";
	String password = "";

	// �Է¹��� ��й�ȣ�� ��������� �б���
	if (request.getParameter("password") != null && !request.getParameter("password").equals("")) {

		//�Է¹��� ��й�ȣ�� String Ÿ������ ����
		password = request.getParameter("password").toString();

		//��ȣȭSHA-256 �ν��Ͻ� ����
		MessageDigest sh = MessageDigest.getInstance("SHA-256");

		//�Է¹��� ��й�ȣ�� ��ȣȭ�� ����
		sh.update(password.getBytes()); //������ ����Ʈ�� ����Ͽ� ����� �����մϴ�.
		byte[] byteData = sh.digest(); //�е��� ���� ���� �۵��� �����Ͽ� �ؽ� ����� �Ϸ��մϴ�.
		StringBuffer sb = new StringBuffer();

		//��ȣȭ�� �����͸� ������ ������ ����
		for (int i = 0; i < byteData.length; i++) {
			sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
		}
		//��ȣȭ�� �����͸� String Ÿ������ ����

		SHA = sb.toString();
	} else {
		SHA = "";
	}
%>
<!-- ��ȣȭ�� ��й�ȣ�� �Է¹ް� ȭ�鿡 ������ִ� HTML -->
<html>
<head>
<title>SHA2Sample</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
</head>
<body>
	<form name="pswd" method="POST" action="SHA2Sample.jsp" target="result">
		<table width="700">
			<tr valign="top">
				<td>��й�ȣ �Է� : <input type="password" name="password" size="40"></input>
					<input type="submit" value="��й�ȣ ��ȣȭ����"></input>
				</td>
			</tr>
			<tr>
				<td>��ȣȭ ��й�ȣ : <input type="text" name="SHA2" size="40"
					value="<%=SHA%>"></input>
				</td>
			</tr>
			</talbe>
			</form>
</body>
</html>
</html>