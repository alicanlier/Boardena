<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<jsp:include page="../topmenu.jsp" flush="false"/>
<style>
h2 {
    position: absolute;
    top: 25%;
    left: 50%;
    transform: translate(-50%, -50%);
    text-align: center; 
}
</style>
</head>

<body>
	<!-- 
	Invalid ID or password. <a href="/boardproc/member/loginForm">Back</a>
	 -->
	 
	<h2>Invalid ID or password!<br><br>Redirecting to login page...</h2>
	<script>setTimeout(() => {onload=window.location="/boardproc/member/loginForm"}, 2000);</script>	
	
</body>

<%@include file="../footer.jsp"%>

</html>