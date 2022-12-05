<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Write Review</title>

<style type="text/css">
	th {text-align:left; width: 100px;}
	
	#body input[type=text], input[type=textarea], select {
		width: 100%;
		padding: 8px 3px;
		margin: 8px 0;
		display: inline-block;
		border: 1px solid black;
		border-radius: 4px;
		box-sizing: border-box;
	}
	
	#body input[type=submit], #body button {
		background-color: #4CAF50;
		color: white;
		padding: 10px 20px;
		margin: 4px 0;
		border: none;
		border-radius: 4px;
		cursor: pointer;
	}
	
	#body input[type=submit]:hover, #body button:hover {
		background-color: #008080;
	}
	
	#body input[type=submit]:active, #body button:active {
		transform: translateY(1px);
	}
	
</style>
<jsp:include page="../topmenu.jsp" flush="false"/>
</head>

<body>
<div  id="body">
	<div id="menu">
		<h2>Write Review</h2>
		<a href="/boardproc/">HOME</a>
	</div>
	<br>		
	
	<table board="1" align="center">
		<form action = "boardwrite" method="post">
		
		<input type="hidden" name="writer" value="${id}">
		<tr>
			<th>Author</th>
			<td>${id}</td>
		</tr>
		
		<tr>
			<th>Subject</th>
			<td><input type="text" name="subject" size="50"></td>
		</tr>
		<tr>
			<th>Content</th>
			<td><textarea  name="content" rows="10" cols="50"></textarea></td>
		</tr>
		<tr>
			<th></th>
			<td><input type="submit" value="Submit" width="30%"> &nbsp;&nbsp;
			<button type="button" onclick="location.href='list'" width="30%">Review List</button></td>
		</tr>
		
		</form>
	</table>
</div>
</body>

<%@include file="../footer.jsp"%>

</html>