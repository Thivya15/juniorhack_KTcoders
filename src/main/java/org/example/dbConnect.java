package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbConnect {
        private static final String URL = "jdbc:mysql://localhost:3306/hmsystem";
        private static final String USER = "root";
        private static final String PASSWORD = "Thiya@1115";

        public static Connection getConnection() throws SQLException {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        }

    }
