<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Member Registry Batch Form</title>
<jsp:include page="../topmenu.jsp" flush="false"/>
</head>

<body>
<div  id="body">
	<div id="menu">
		<h2>Member Registry Batch Form</h2>
		<a href="/boardproc/">HOME</a><p>
	</div>
	<hr>

	<form action="joinBatch" method="post">
		<table width="600" align="center" border="1">
			<tr>
				<th>Member ID</th>
				<th>Password</th>
				<th>Name</th>
				<th>Email</th>
				<th>Phone</th>
				<th>Age</th>
				<th>Profession</th>
				<th>Hobbies</th>
			</tr>
			<tr>
				<td colspan="8">
				<div align="center">순서에 맞춰 컴마로 나열하세요(여러줄 작성 가능)</div>
				예보기: hongGD,1234,honggildong,HGD@naver.com,010-2222-3333,30대,개발프리렌스,노래하기	
				</td>
			</tr>
			<tr>
				<td colspan="8">
					<textarea rows="10" cols="100" name="batchData"></textarea>
				</td>
			</tr>
			
			<tr>
				<td colspan="9">
					<input type="submit" value="Process batch">&nbsp;&nbsp;&nbsp;&nbsp;
					<a href="list">Member List</a>
				</td>
			</tr>
		</table>
	</form>
</div>
</body>

<%@include file="../footer.jsp"%>

</html>