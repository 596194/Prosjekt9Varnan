<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <link rel="stylesheet" href="css/simple.css">
    <script defer src="js/PassordValidator.js"></script>
    <title>Registrer bruker</title>
</head>
<body>


<form action="nybruker" method="post">
    <fieldset>
        <legend>lag bruker</legend>
        <p>brukernavn: <input type="text" title="Forste bokstav skal vere stor, og resten liten" name="brukernavn"
                              placeholder="Fyll inn etternavn" required="required"/></p>
        <p style="color:red">
        <p>fornavn: <input type="text" title="Forste bokstav skal vere stor, og resten liten" name="fornavn"
                           placeholder="Fyll inn fornavn" pattern="[A-ZÆØÅ]{1}[a-zæøå]{1,19}" required="required"/></p>
        <p style="color:red">
        <p>etternavn: <input type="text" title="Forste bokstav skal vere stor, og resten liten" name="etternavn"
                             placeholder="Fyll inn etternavn" pattern="[A-ZæøåÆØÅ]{1}[a-zæøå]{1,19}"
                             required="required"/></p>
        <p style="color:red">
        <p>epost: <input type="text" title="Forste bokstav skal vere stor, og resten liten" name="epost"
                         placeholder="Fyll inn etternavn" required="required"/></p>
        <p style="color:red">
        <p>passord: <input type="password" name="passord" placeholder="Fyll inn passord" required="required"/></p>
        <p style="color:red">
        <p>repassord: <input type="password" name="repassord" placeholder="Fyll inn passord igjen" required="required"/>
        </p>
        <p style="color:red">
        <p><input type="submit" value="Legg til deltager"/></p>
    </fieldset>
</form>


</body>
</html>