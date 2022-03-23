<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Réservation d'une location</title>
    <link href="css/style.css" rel="stylesheet">
    <script src="js/location.js"></script>
</head>
<body>
 <form action="bookLocation" method="post">
     <input type="hidden" name="id" value=${requestScope.LOCATION.id}>
     <fieldset>
         <legend>${requestScope.LOCATION.city} ${requestScope.LOCATION.zipCode}</legend>
         <table>
             <tbody>
                <tr>
                    <td>Date de début :</td>
                    <td><input type="date" name="startDate" required></td>
                </tr>
                <tr>
                    <td>Date de fin: </td>
                    <td><input type="date" name="endDate" required></td>
                </tr>
                <tr>
                    <td>Forfait ménage :</td>
                    <td><input type="checkbox" name="cleaning"></td>
                </tr>
                <tr>
                    <td>Assurance annulation :</td>
                    <td><input type="checkbox" name="cancelInsurance"></td>
                </tr>
             </tbody>
         </table>
     </fieldset>
     <input type="submit" value="Réserver">
 </form>
</body>
</html>
