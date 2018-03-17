package site001.service;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionManager {

    private static final String URL = "jdbc:postgresql://localhost:5432/Site 001";
    private static final String USUARIO = "postgres";
    private static final String SENHA = "postgres";

    public static Connection getConnection() throws Exception {
        Class.forName("org.postgresql.Driver");
        return DriverManager.getConnection(URL, USUARIO, SENHA);
    }
}
