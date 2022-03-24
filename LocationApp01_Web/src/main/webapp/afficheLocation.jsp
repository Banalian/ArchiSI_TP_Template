<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Réservation d'une location</title>
    <link href="css/style.css" rel="stylesheet">
    <script src="js/location.js"></script>
</head>
<body>
 <form action="bookLocationServlet" method="post">
     <input type="hidden" name="id" value=${requestScope.LOCATION.idLocation}>
     <fieldset>
         <legend>${requestScope.LOCATION.city} ${requestScope.LOCATION.zipCode}</legend>
         <table>
             <tbody>
                <tr>
                    <td>Date de début :</td>
                    <td>
                        <label>
                            <input type="date" name="startDate" required>
                        </label>
                    </td>
                </tr>
                <tr>
                    <td>Date de fin: </td>
                    <td>
                        <label>
                            <input type="date" name="endDate" required>
                        </label>
                    </td>
                </tr>
                <tr>
                    <td>Forfait ménage :</td>
                    <td>
                        <label>
                            <input type="checkbox" name="cleaning">
                        </label>
                    </td>
                </tr>
                <tr>
                    <td>Assurance annulation :</td>
                    <td>
                        <label>
                            <input type="checkbox" name="cancelInsurance">
                        </label>
                    </td>
                </tr>
             </tbody>
         </table>
     </fieldset>
     <input type="submit" value="Réserver">
 </form>
</body>
</html>
