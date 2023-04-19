<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>

	<link rel="stylesheet" href="<c:url value= 'css/simple.css'/>">
	<link rel="stylesheet" href="<c:url value= 'css/yatzy.css'/>">
	<script defer src="css/yatzy.js"></script>
	<title>Join Spill Side</title>
	
</head>

<body>
<jsp:include page="header.jsp"/>
	<p>Du er logget inn som : ${bruker.brukernavn}</p><br>
	
	<p>Liste av alle nye spill</p><br>
	<form action="joinspill" method="post">
	<table><tr>
		<th>SpillId</th>
			<th>Spill Status</th>
		
		</tr>
		<c:forEach var="spill" items="${spillene}"><tr>
			<td><c:out value = "${spill.spillid}"/></td>
			<td><c:out value = "${spill.status}"/></td>
			<td><button type="submit" name="joinSpill" value="${spill.spillid}"/>join spill</button></td>
		</tr></c:forEach>	
	</table><br>
	</form>
	
</body>

</html>