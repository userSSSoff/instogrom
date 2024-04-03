package org.example.main.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// TODO: 27.06.2023
//  Если захочешь используй мою конфигурацию, либо напиши свой!!!
public class Config {
public static final String URL = "jdbc:postgresql://localhost:5432/postgres";
public static  final String USER_NAME = "postgres";
public static  final String PASSWORD = "999777";
    public  static Connection getConnection(){
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL,USER_NAME,PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);}
        return connection;
    }
    }
