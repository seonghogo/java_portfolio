<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
	<link href="fonts/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Open+Sans" rel="stylesheet">
    <link href="css/theme.css" rel="stylesheet">
<title>Insert title here</title>
</head>
<body>

	  <!-- header -->
      	 <jsp:include page="../INC/top.jsp"></jsp:include> 
      <!-- header -->
	<%
		String id = (String)session.getAttribute("user");
		String admin = (String)session.getAttribute("admin");
	%>
		<form>
			
			<div id="theme-carousel" class="carousel slide" data-ride="carousel">
	
	<!-- Wrapper for slides -->
	<div class="carousel-inner" role="listbox">
		<div class="item active">
			<img src="images/carousel1.jpg" alt="carousel1" style="width:100%; height:757px"/>
			
			<div class="carousel-caption">
	<%
			if(id==null && admin == null){
			%>
				<button class="button-more-white btn-lg" type="button" onclick="location.href='./LoginAction.me'"><i class="fa fa-info" aria-hidden="true"></i>&nbsp; 로그인</button>
				<button class="button-more-white btn-lg" type="button" onclick="location.href='./JoinAction.me'"><i class="fa fa-info" aria-hidden="true"></i>&nbsp; 회원가입</button>
					<%

			}
			%>
			</div>
		</div>
<!-- 		<div class="item"> -->
<!-- 			<img src="images/carousel3.jpg" alt="carousel3" style="width:100%"> -->
<!-- 			<div class="carousel-caption"> -->
<!-- 				<span class="hidden-xs" style="font-size:80px;"><br />Artisrtic<br /></span> -->
<!--                 <span class="visible-xs" style="font-size:40px;">Artisrtic</span> -->
<!-- 				<button class="button-more-white btn-lg" type="button"><i class="fa fa-info" aria-hidden="true"></i>&nbsp; MORE INFO</button> -->
<!-- 			</div> -->
<!-- 		</div> -->
<!-- 		<div class="item"> -->
<!-- 			<img src="images/carousel3.jpg" alt="carousel3" style="width:100%"> -->
<!-- 			<div class="carousel-caption"> -->
<!-- 				<span class="hidden-xs" style="font-size:80px;"><br />Imagination<br /></span> -->
<!--                 <span class="visible-xs" style="font-size:40px;">Imagination</span> -->
<!-- 				<button class="button-more-white btn-lg" type="button"><i class="fa fa-info" aria-hidden="true"></i>&nbsp; MORE INFO</button> -->
<!-- 			</div> -->
<!-- 		</div> -->
	</div>
	<!-- Controls -->
	<a class="left carousel-control" href="#theme-carousel" role="button" data-slide="prev">
        <div class="carousel-control-arrow">&#8249;</div>
	</a>
	<a class="right carousel-control" href="#theme-carousel" role="button" data-slide="next">
        <div class="carousel-control-arrow">&#8250;</div>
	</a>
</div>
					
		</form>
		
	  <!-- footer -->
     	 <jsp:include page="../INC/bottom.jsp"></jsp:include>
      <!-- footer -->
</body>
</html>