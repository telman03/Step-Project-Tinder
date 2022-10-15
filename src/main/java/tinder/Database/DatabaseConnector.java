package tinder.Database;

import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnector {
    @SneakyThrows
    public static void main(String[] args) {
        Connection conn = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/tinder",
                "postgres",
                "eden258"
        );
    }

    public static Connection getConnection() {
        return null;
    }
}
