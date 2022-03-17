package edu.polytech.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/";

    private static final String LOGIN = "root";

    private static final String PASSWORD = "root";

    /**
     *
     * @return L'object {@link Connection} permettant de se connecter à la BDD.
     * @throws ClassNotFoundException S'il y a un problème au chargement du pilote
     *                                com.mysql.cj.jdbc.Driver.
     * @throws SQLException           S'il y a un problème à l'établissement de la
     *                                connexion.
     */
    public static Connection createDBConnexion() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        final Connection con = DriverManager.getConnection(URL, LOGIN, PASSWORD);
        return con;
    }
}
