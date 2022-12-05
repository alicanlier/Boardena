<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import = "org.vision.boardproc.model.*" %>   
<%@ page import = "org.vision.boardproc.serviceboard.*" %> 
<%@ page import = "java.util.*" %> 
  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Review List</title>
<jsp:include page="../topmenu.jsp" flush="false"/>
</head>

<body>
<div  id="body">
	<div id="menu">
		<h2>Hotel Reviews</h2>
		<a href="/boardproc/">HOME</a>
	</div>
	
	<hr>
	<table width="70%" border="1" align="center">
		<tr>
			<th>No</th>
			<th>Author</th>
			<th>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Subject&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
			<th>Upload date</th>
			<th>Hits</th>
			<th>Likes</th>
			<th>Details</th>
		</tr>
	
		<c:forEach items="${list}" var="vo">
			<tr>
				<td>${vo.num}</td>
				<td>${vo.writer}</td>
				<td><c:forEach begin="1" end="${vo.re_level}">-</c:forEach>${vo.subject}</td>
				<td>${vo.reg_date}</td>
				<td>${vo.hit}</td>
				<td>${vo.liked}</td>
				<td align="center">
					<button onclick="location.href='board_content_view?num=${vo.num}&writer=${vo.writer}'">View</button>&nbsp;&nbsp;
					
					<% String xid = (String) session.getAttribute("id");
					if (xid!=null && xid.equals("admin")) {%>
					<button onclick="location.href='delete?num=${vo.num}'">Delete</button>
					<%}%>
				</td>
			</tr>
		</c:forEach>
		<c:if test="${list[0] == null}">
			<tr><td colspan="9"align="center">No content yet.</td></tr>
		</c:if>
		<tr>
			<td colspan="9" align="center"> <button onclick="location.href='write_view'">Write Review</button> </td>
		</tr>
	</table>
</div>
</body>

<%@include file="../footer.jsp"%>

</html>