<%@ page contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Spill</title>
    <link href="<c:url value='css/simple.css'/>" rel="stylesheet" type="text/css">
 	<script defer src="css/yatzy.js"></script>
</head>
<body>

<%--Dette inkluderer header, og lar oss gjøre endringer på header uten å måtte individuelt oppdatere alle sidene.--%>
<jsp:include page="header.jsp"/>

<p style="color:red">${redirectMessage}</p>

<c:set var="maksSpillere" value="3"> </c:set>

	<p>Du er logget inn som : ${bruker.brukernavn}</p><br>

<div>
    <table id="table">
        <tbody>
        <%-- Benytter meg av count istedenfor index, for at den skal begynne fra 1--%>
        <tr>
            <th>Spillere</th>
        	 <c:forEach var="spiller" items="${spillere}">
                <td>
                    ${spiller.brukerid.brukernavn}
                </td>
            </c:forEach>
        </tr>

        <tr>
            <th>Enere</th>
            <c:forEach var="spiller" items="${spillere}">
                <td>
                    ${spiller.resultat[0]}
                </td>
            </c:forEach>
        </tr>
        <tr>
            <th>Toere</th>
            <c:forEach var="spiller" items="${spillere}">
                <td>
                    ${spiller.resultat[1]}
                </td>
            </c:forEach>
        </tr>

        <tr>
            <th>Treere</th>
            <c:forEach var="spiller" items="${spillere}">
                <td>
                    ${spiller.resultat[2]}
                </td>
            </c:forEach>
        </tr>

        <tr>
            <th>Firere</th>
            <c:forEach var="spiller" items="${spillere}">
                <td>
                    ${spiller.resultat[3]}
                </td>
            </c:forEach>
        </tr>

        <tr>
            <th>Femmere</th>
            <c:forEach var="spiller" items="${spillere}">
                <td>
                    ${spiller.resultat[4]}
                </td>
            </c:forEach>
        </tr>

        <tr>
            <th>Seksere</th>
            <c:forEach var="spiller" items="${spillere}">
                <td>
                    ${spiller.resultat[5]}
                </td>
            </c:forEach>
        </tr>

        <tr>
            <th>Sum</th>
            <c:forEach var="spiller" items="${spillere}">
                <td>
                 NaN
                </td>
            </c:forEach>
        </tr>

        <tr>
            <th>Bonus</th>
            <c:forEach var="spiller" items="${spillere}">
                <td>
                   NaN
                </td>
            </c:forEach>
        </tr>

        <tr>
            <th>1 par</th>
            <c:forEach var="spiller" items="${spillere}">
                <td>
                    ${spiller.resultat[6]}
                </td>
            </c:forEach>
        </tr>

        <tr>
            <th>2 par</th>
            <c:forEach var="spiller" items="${spillere}">
                <td>
                    ${spiller.resultat[7]}
                </td>
            </c:forEach>
        </tr>

        <tr>
            <th>3 like</th>
            <c:forEach var="spiller" items="${spillere}">
                <td>
                    ${spiller.resultat[8]}
                </td>
            </c:forEach>
        </tr>

        <tr>
            <th>4 like</th>
            <c:forEach var="spiller" items="${spillere}">
                <td>
                    ${spiller.resultat[9]}
                </td>
            </c:forEach>
        </tr>

        <tr>
            <th>Liten straight</th>
            <c:forEach var="spiller" items="${spillere}">
                <td>
                    ${spiller.resultat[10]}
                </td>
            </c:forEach>
        </tr>

        <tr>
            <th>Stor straight</th>
            <c:forEach var="spiller" items="${spillere}">
                <td>
                    ${spiller.resultat[11]}
                </td>
            </c:forEach>
        </tr>

        <tr>
            <th>Hus</th>
            <c:forEach var="spiller" items="${spillere}">
                <td>
                    ${spiller.resultat[12]}
                </td>
            </c:forEach>
        </tr>

        <tr>
            <th>Sjanse</th>
            <c:forEach var="spiller" items="${spillere}">
                <td>
                    NaN
                </td>
            </c:forEach>
        </tr>

        <tr>
            <th>Yatzy</th>
            <c:forEach var="spiller" items="${spillere}">
                <td>
                    ${spiller.resultat[13]}
                </td>
            </c:forEach>
        </tr>

        <tr>
            <th>Totalsum</th>
            <c:forEach var="spiller" items="${spillere}">
                <td>
                    ${spiller.resultat[14]}
                </td>
            </c:forEach>
        </tr>


        </tbody>
    </table>
</div>

	<form action="spillet" method="post">
	  <fieldset>
	  		<p><input type="submit" value="spill runde" /></p>
	  </fieldset>
	</form>

<%-- Dette inkluderer footer--%>
<jsp:include page="footer.jsp"/>
</body>
</html>