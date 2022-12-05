<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isErrorPage="true" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Member Registry</title>
<jsp:include page="../topmenu.jsp" flush="false"/>
<style>

	input[type=text], select {
	  width: 100%;
	  padding: 12px 20px;
	  margin: 8px 0;
	  display: inline-block;
	  border: 1px solid #ccc;
	  border-radius: 4px;
	  box-sizing: border-box;
	}
	
	input[type=submit] {
	
	  width: 100%;
	  background-color: #4CAF50;
	  color: white;
	  padding: 16px 20px;
	  margin: 4px 0;
	  border: none;
	  border-radius: 4px;
	  cursor: pointer;
	}
	
	input[type=submit]:hover {
	  background-color: #45a049;
	}
	
	#memberwrite {
	  margin: 0 auto 40px;
	  width: 40%;
	  border-radius: 5px;
	  background-color: #f2f2f2;
	  padding: 20px;
	}

</style>
</head>

<body>

	<div id="menu">
	  	<%!String xid;%>
		<% xid = (String) session.getAttribute("id");
		if (xid!=null && xid.equals("admin")) {%>
			<a href="list">Member List</a>&nbsp;&nbsp;&nbsp;&nbsp;
		<%}%>
		
		<a href="/boardproc/">HOME</a><p>
	</div>
	<hr>

	<div id="memberwrite">
		<h3 align="center">Member Registry</h3>
	
		<form action="join" method="post">
		    <label for="id">Member ID</label>
		    <input type="text" id="id" name="id" placeholder="ID..">
		
		    <label for="pass">Password</label>
		    <input type="text" id="pass" name="pass" placeholder="Password..">
		    
		    <label for="name">Name</label>
		    <input type="text" id="name" name="name" placeholder="Name..">
		    
		    <label for="email">Email</label>
		    <input type="text" id="email" name="email" placeholder="Email..">
		    
		    <label for="tel">Phone</label>
			<input type="text" id="tel" name="tel" placeholder="Phone..">
			
		    <label for="age">Age</label>
		    <select id="age" name="age">
				<option value='10대'>10s</option>
				<option value='20대'>20s</option>
				<option value='30대'>30s</option>
				<option value='40대'>40s</option>
				<option value='50대'>50s</option>
				<option value='60대'>60s</option>
				<option value='70대이상'>70s up</option>
		    </select>
		    
		    <label for="job">Profession</label>    
		    <input type="text" id="job" name="job" placeholder="Profession..">
		    
		    <label for="hobby">Hobbies</label>    
		    <input type="text" id="hobby" name="hobby" placeholder="Hobbies..">
		
		    <input type="submit" value="Submit">
		
		</form>
	</div>

<!-- 
<form action="join" method="post">
	<table width="500" align="center" border="1">
		<tr>
			<th>Member ID</th>
			<td><input type="text" name="id" size="50"></td>
		</tr>
		
		<tr>
			<th>Password</th>
			<td><input type="password" name="pass" size="50"></td>
		</tr>
		
		<tr>
			<th>Email</th>
			<td><input type="text" name="email" size="50"></td>
		</tr>
		
		
		<tr>
			<th>Phone</th>
			<td><input type="text" name="tel" size="50"></td>
		</tr>
		
		<tr height='30'>
					<th>Age</th>
					<td width='350' align='center'><select name='age' style="width:387px;text-align:center">
							<option value='10대'>10s</option>
							<option value='20대'>20s</option>
							<option value='30대'>30s</option>
							<option value='40대'>40s</option>
							<option value='50대'>50s</option>
							<option value='60대'>60s</option>
							<option value='70대이상'>70s up</option>
					</select>
		</tr>
		
		<tr>
			<th>Profession</th>
			<td><input type="text" name="job" size="50"></td>
		</tr>
		
		<tr>
			<th>Hobbies</th>
			<td><input type="text" name="hobby" size="50"></td>
		</tr>
		
		<tr>
			<td colspan="2" align="center">
				<input type="submit" value="Register">&nbsp;&nbsp;&nbsp;&nbsp;
				
			
			</td>
		</tr>
		
	</table>
</form>
 -->


</body>

<%@include file="../footer.jsp"%>

</html>