<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Confirmation de la réservation</title>
    <link href="css/style.css" rel="stylesheet">
    <script src="js/location.js"></script>
</head>
<body>
    <fieldset>
        <legend>Détail du tarif de la réservation</legend>
        <table>
            <tbody>
                <tr>
                    <td>Prix du logement( ${requestScope.RESERVATION.dureeEnJour} nuits) :</td>
                    <td>${requestScope.RESERVATION.prixLocation}</td>
                </tr>
                <tr>
                    <td>Ménage :</td>
                    <td>${requestScope.RESERVATION.prixMenage}</td>
                </tr>
                <tr>
                    <td>Prix de l'assurance :</td>
                    <td>${requestScope.RESERVATION.prixAssurance}</td>
                </tr>
                <tr>
                    <td>Réduction long séjour (plus de 7 jours) :</td>
                    <td>${requestScope.RESERVATION.reducSejourLong}</td>
                </tr>
                <tr>
                    <td>Réduction (plus de 500 euros) :</td>
                    <td>${requestScope.RESERVATION.reducSup500}</td>
                </tr>
                <tr>
                    <td>Réduction séjour lointain (dans plus de 30 jours) :</td>
                    <td>${requestScope.RESERVATION.reducSejourLointain}</td>
                </tr>
                <tr>
                    <td>Réduction fidélité (3ème réservation) :</td>
                    <td>${requestScope.RESERVATION.reducFidelite}</td>
                </tr>
                <tr>
                    <td><b>Prix total :</b></td>
                    <td>${requestScope.RESERVATION.prixTot}</td>
                </tr>
            </tbody>
        </table>
    </fieldset>
    <form action="confirmationServlet" method="post">
        <input type="hidden" name="id" value="${requestScope.RESERVATION.id}">
        <input type="hidden" name="finalPrice" value=${requestScope.RESERVATION.prixTot}>
        <input type="submit" value="Valider la réservation">
    </form>

</body>
</html>
