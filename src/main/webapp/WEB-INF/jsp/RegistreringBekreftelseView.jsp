<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet" href="css/simple.css">
<link rel="stylesheet" href="css/yatzy.css">
<title>Bruker Registrering bekreftelse</title>
</head>
<body>
	<h2>Registrering bekreftelse</h2>
	
	<p>
		brukernavn: ${bruker.brukernavn} <br>
		Fornavn: ${bruker.fornavn} <br>
		Etternavn: ${bruker.etternavn} <br>
		epost: ${bruker.epost} <br>
	
	</p>
	
	<form action="bekreftelse" method="post">
	  <fieldset>
	  		<p><input type="submit" value="gå til Hovedsiden" /></p>
	  </fieldset>
	</form>
	
	<form action="logout" method="post">
	 
	  		<p><input class="loggut" type="submit" value="Logg ut" /></p>
	 
	</form>
</body></html>