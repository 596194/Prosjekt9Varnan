<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>

<head>
	<link rel="stylesheet" href="<c:url value= 'css/simple.css'/>">
	<link rel="stylesheet" href="<c:url value= 'css/yatzy.css'/>">
	<title>Hovedside</title>
</head>
<body>

<jsp:include page="header.jsp"/>


	<p>Du er logget inn som : ${bruker.brukernavn}</p><br>

	<form action="http://localhost:8080/yatzy/hovedside" method="post">

		<fieldset><legend>Valg</legend>
			
			<input type="submit" name="valg" id="spill" value="Spill"/><br>

			<%--TODO legge til ID for disse under så de også gjøre noe.--%>

			<input type="submit" name="valg" value="Mine aktive"/><br>
			
			<input type="submit" name="valg" value="Historikk"/><br>
	
		</fieldset>
	</form>
</body>
</html>