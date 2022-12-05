<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Reply</title>
<jsp:include page="../topmenu.jsp" flush="false"/>
</head>

<body>
<div  id="body">
	<div id="menu">
		<h2>Reply</h2>
		<a href="/boardproc/">HOME</a>
	</div>
	<br>
	
	<table width="500" border="1" align="center">
		<form action="reply" method="post" >
		
			<input type="hidden" name="num" value="${reply_view.num}">
			<input type="hidden" name="ref" value="${reply_view.ref}">
			<input type="hidden" name="re_step" value="${reply_view.re_step}">
			<input type="hidden" name="re_level" value="${reply_view.re_level}">
			<input type="hidden" name="writer" value="${id}">
			
			<tr>
				<th>No</th>
				<td>${reply_view.num}</td>
			</tr>
			
			<tr>
				<th>Hits</th>
				<td>${reply_view.hit}</td>
			</tr>
			
			<tr>
				<th>Upload date</th>
				<td>${reply_view.reg_date}</td>
			</tr>
		
			<tr>
				<th>Author</th>
				<td>${id}</td>
				<!-- <td><input type="text" name="writer" size="50" value="${id}"></td>  -->
			</tr>
		 
			<tr>
				<th>Subject</th>
				<td><input border="hidden" type="text" name="subject" size="50" value="&lt;re&gt; ${reply_view.subject}"></td>
			</tr>
			<tr>
				<th>Content</th>
				<td><textarea  name="content" rows="10" cols="47">${reply_view.content}&#13;&#10;&lt;re&gt;</textarea></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
				<input type="submit" value="Send reply"> &nbsp;&nbsp;
				<button type="button" onclick="location.href='list'">Review List</button>
				</td>
			</tr>
		
		</form>
	</table>
</div>	
</body>

<%@include file="../footer.jsp"%>

</html>