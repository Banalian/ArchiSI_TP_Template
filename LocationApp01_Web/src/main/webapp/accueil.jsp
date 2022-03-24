<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Connection</title>
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
                        <td>
                            <label>
                                <input type="text" name="login">
                            </label>
                        </td>
                    </tr>
                </tbody>
            </table>
            <input type="submit" value="Connexion">
        </fieldset>
    </form>
</body>
</html>
