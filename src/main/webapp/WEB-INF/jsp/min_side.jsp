<%--
  Created by IntelliJ IDEA.
  User: saele
  Date: 29.03.2023
  Time: 11:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="<c:url value= 'css/simple.css'/>">
</head>
<body>
<jsp:include page="header.jsp"/>

<form action="oppdaterbruker" method="post">
    <fieldset>
        <c:forEach var="item" items="${bruker}" varStatus="loop">


        <legend>Din info</legend>
        <p>Brukernavn: <input type="text" title="Forste bokstav skal vere stor, og resten liten" name="brukernavn"
                              value="${item.brukernavn}" required="required"/></p>
        <p style="color:red">
        <p>fornavn: <input type="text" title="Forste bokstav skal vere stor, og resten liten" name="fornavn"
                           value="${item.fornavn}" pattern="[A-ZÆØÅ]{1}[a-zæøå]{1,19}" required="required"/></p>
        <p style="color:red">
        <p>etternavn: <input type="text" title="Forste bokstav skal vere stor, og resten liten" name="etternavn"
                             value="${item.etternavn}" pattern="[A-ZæøåÆØÅ]{1}[a-zæøå]{1,19}"
                             required="required"/></p>
        <p style="color:red">
        <p>epost: <input type="text" title="Forste bokstav skal vere stor, og resten liten" name="epost"
                         value="${item.epost}" required="required"/></p>
        <p style="color:red">
        <p>passord: <input type="password" name="passord" placeholder="Fyll inn passord" required="required"/></p>
        <p style="color:red">
        <p>repassord: <input type="password" name="repassord" placeholder="Fyll inn passord igjen" required="required"/>
        </p>
        <p style="color:red">
        <p><input type="submit" value="Legg til deltager"/></p>
        </c:forEach>
    </fieldset>
</form>

</body>
</html>
