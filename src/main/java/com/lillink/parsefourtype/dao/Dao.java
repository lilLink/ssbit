package com.lillink.parsefourtype.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public abstract class Dao {

    private static final String URL = "jdbc:postgresql://localhost:5433/parse";
    private static final String USER = "postgres";
    private static final String PASSWORD = "root";

    protected Connection connection;

    public Dao() {
        initConnection();
    }

    private void initConnection() {
        try {
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
