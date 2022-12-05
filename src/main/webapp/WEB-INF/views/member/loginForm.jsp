<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<style>

body {
  font-family: Arial, Helvetica, sans-serif;
}

.outer {
  position: absolute;
  top: 40%;
  left: 50%;
  transform: translate(-50%,-50%);
  /*transform: translate(-20px, -50px) rotate(30deg);
  transform: translate3d(12px, -50%, 3em);
  padding: 5px;*/
  text-align:center;  
}

.inner {
  background: #0080ff;
  border: hidden;
  border-radius: 7px;
  margin: 5px auto 15px;
  padding: 5px;
}


.logButton{
  border: hidden;
  border-radius: 5px;
  background: #03b6fc;
  font-size: 16px;
  font-weight: bold;
  height:20px;
  margin:10px 10px 5px 0;
  cursor: pointer;
}

.logButton:active {
  transform: translateY(1px);
}

table {
  width: 500;
  border: hidden;
  table-layout: fixed;
}

td {
  text-align: left;
  padding: 0 3px;

}

#id, #pw {
  width: 97%;
  height: 20px;
  margin: 5px 0;
  border: hidden;
  border-radius: 5px;
}

</style>
</head>
<body>

<div class='outer'> 
	<div class='inner'>
		<h3>Enter ID and password to login.</h3>
		<form action='/boardproc/member/loginProc' method='post'>
		<table>
			<tr>
				<td>ID</td>
				<td><input type='input' name='id' id='id' size='40' "></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type='password' name='pass' id='pw' size='40'></td>
			</tr>

			<tr>
				<td></td><td>
					<input type='submit' value='Login' class='logButton'>
					<input type="checkbox" name="cookieSave" value="쿠키저장">Save cookies
				</td>
			</tr>
			
		</table>
		</form>
	</div>
	<div><a href="/boardproc/">HOME</a></div>
</div>
</body>
</html>