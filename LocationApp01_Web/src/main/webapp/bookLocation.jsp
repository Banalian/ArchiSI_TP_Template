<%@ page contentType="text/html;charset=UTF-8" %>
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
                    <td>Prix du logement( ${requestScope.RESERVATION.dureeEnJours} nuits) :</td>
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

    <!--Hidden parameters to recreate the reservation on the next servlet-->
    <form action="confirmationServlet" method="post">
        <input type="hidden" name="idAppart" value="${requestScope.RESERVATION.appart.idLocation}">

        <input type="hidden" name="dateDebut" value="${requestScope.DATEDEBUT}">
        <input type="hidden" name="dateFin" value="${requestScope.DATEFIN}">

        <input type="hidden" name="dureeEnJours" value="${requestScope.RESERVATION.dureeEnJours}">

        <input type="hidden" name="prixLocation" value="${requestScope.RESERVATION.prixLocation}">
        <input type="hidden" name="prixMenage" value="${requestScope.RESERVATION.prixMenage}">
        <input type="hidden" name="prixAssurance" value="${requestScope.RESERVATION.prixAssurance}">

        <input type="hidden" name="reducSejourLong" value="${requestScope.RESERVATION.reducSejourLong}">
        <input type="hidden" name="reducSup500" value="${requestScope.RESERVATION.reducSup500}">
        <input type="hidden" name="reducSejourLointain" value="${requestScope.RESERVATION.reducSejourLointain}">
        <input type="hidden" name="reducFidelite" value="${requestScope.RESERVATION.reducFidelite}">

        <input type="hidden" name="idUser" value=${requestScope.RESERVATION.idUser}>

        <input type="hidden" name="prixTot" value=${requestScope.RESERVATION.prixTot}>
        <input type="submit" value="Valider la réservation">
    </form>

</body>
</html>
