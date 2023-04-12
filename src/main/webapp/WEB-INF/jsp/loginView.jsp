<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="<c:url value= 'css/simple.css'/>">
	<title>Login</title>
</head>
<body>
	<p style="color:red">${redirectMessage}</p>
	
	<form action="login" method="post">
		<fieldset><legend>Logg Inn</legend>
		
			Brukernavn: <input type="text" name="brukernavn"/><br>
			Passord: <input type="password" name="passord"/><br>
			<input type="submit" value="Logg inn"/><br>
			
		</fieldset>
	</form>
	
	<form action="logout" method="post">
	  <fieldset>
	  		<p><input type="submit" value="go tilbake" /></p>
	  </fieldset>
	</form>
</body>
</html>

