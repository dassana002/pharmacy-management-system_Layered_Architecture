package org.example.pharmacypos_layered.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
    private final String URL = "jdbc:mysql://localhost:3306/pharmacy";
    private final String USER = "root";
    private final String PASSWORD = "DAka@24381";

    private final Connection connection;
    private static DbConnection dbConnection;

    private DbConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        this.connection = DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static DbConnection getInstance() throws SQLException, ClassNotFoundException {
        if (dbConnection == null) return new DbConnection();
        return dbConnection;
    }

    public Connection getConnection() {
        return connection;
    }
}
