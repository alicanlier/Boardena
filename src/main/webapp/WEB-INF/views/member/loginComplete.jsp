<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login OK!</title>
<jsp:include page="../topmenu.jsp" flush="false"/>
</head>

<body>
<%String id = (String)session.getAttribute("id");%>
	<%=id %> logged in. <br>
	Welcome to Boardena! <br>
	<a href="/boardproc/">HOME</a>
</body>

<%@include file="../footer.jsp"%>

</html>