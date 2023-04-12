<%--Dette er header som brukes på alle sider. Sett inn følgende for å importere den til en side

 <jsp:include page="header.jsp"/>

 plasser det helst øverst i '*.jsp' sin <body> --%>

<%--Brukes for å importere css for header --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="<c:url value='css/header.css'/>" rel="stylesheet" type="text/css">

<%-- Dette er innholdet til selve headeren--%>

<div class="header">
    <div class="header-right" >
        <a href="hovedside">Hovedside</a>
        <a href="min_side" >Min Side</a>
        <a href="logg_ut">Logg ut</a>
    </div>
</div>