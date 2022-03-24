<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Connextion</title>
    <link href="css/style.css" rel="stylesheet">
    <script src="js/location.js"></script>
</head>
<body>
    <form action="connexionServlet" method="post">
        <fieldset>
            <legend>Connexion</legend>
            <table>
                <tbody>
                    <tr>
                        <td>Nom d'utilisateur</td>
                        <td><input type="text" name="login"></td>
                    </tr>
                </tbody>
            </table>
            <input type="submit" value="Connexion">
        </fieldset>
    </form>
</body>
</html>
