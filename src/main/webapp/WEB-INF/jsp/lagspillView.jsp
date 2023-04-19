<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>

<head>
	<link rel="stylesheet" href="<c:url value= 'css/simple.css'/>">
	<link rel="stylesheet" href="<c:url value= 'css/yatzy.css'/>">
	<title>Spill Side</title>
</head>
<body>

<jsp:include page="header.jsp"/>


	<p>Du er logget inn som : ${bruker.brukernavn}</p><br>

	<form action="spillside" method="post">

		<fieldset><legend>Valg</legend>
			
			<input type="submit" name="valg"  value="nytt spill"/><br>

			<input type="submit" name="valg" value="join spill"/><br>
	
		</fieldset>
	</form>
</body>
</html>