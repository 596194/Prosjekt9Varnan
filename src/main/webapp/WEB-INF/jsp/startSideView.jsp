<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="<c:url value= 'css/simple.css'/>">
	<title>YATZY</title>
</head>
<body>
	
	<form action="startside" method="post">
		<fieldset><legend>YATZY</legend>
		
			 <input type="submit" name="bruker" value="logg inn"/><br>
			
			<input type="submit" name="bruker" value="lag bruker"/><br>
	
		</fieldset>
	</form>
	
</body>
</html>
