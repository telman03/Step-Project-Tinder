package tinder.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector {
    private static final String url = "jdbc:postgresql://localhost:5432/d2hmka3hjunhdn";
    private static final String username = "ygioxnmirpouev";
    private static final String password = "0f0ea151d3a0d12b6712395b40c1749092c2e83fae1eedcd14a4d812bae2ab49";

    private static Connection connection;

    public static Connection getConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(url, username, password);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }
}
