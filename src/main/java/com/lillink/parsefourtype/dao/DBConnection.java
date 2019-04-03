package com.lillink.parsefourtype.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public abstract class DBConnection {

    private static final String URL = "jdbc:postgresql://localhost:5432/parse";
    private static final String USER = "postgres";
    private static final String PASSWORD = "root";

    protected Connection connection;

    public DBConnection() {
        try {
            initConnection();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void initConnection() throws ClassNotFoundException {
        try {
        Class.forName("org.postgresql.Driver");

            Properties properties = new Properties();
            properties.setProperty("user", USER);
            properties.setProperty("password", PASSWORD);
            properties.setProperty("autoReconnect", "true");
            this.connection = DriverManager.getConnection(URL, properties);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
