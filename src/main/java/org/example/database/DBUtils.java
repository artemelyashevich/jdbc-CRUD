package org.example.database;

import io.github.cdimascio.dotenv.Dotenv;

import java.sql.*;

public class DBUtils {
    public Connection getConnection() {
        Dotenv dotenv = Dotenv.load();
        Connection conn = null;
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection("jdbc:postgresql://0.0.0.0:5432/postgres", dotenv.get("USER"), dotenv.get("PASSWORD"));
            if (conn == null) {
                System.out.println("Failed");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return conn;
    }

    public boolean checkTables(Connection connection) throws SQLException {
        ResultSet rs = null;
        try {
            DatabaseMetaData databaseMetaData = connection.getMetaData();
            rs = databaseMetaData.getTables(null, null, null, new String[]{"TABLE"});
            return rs.next();
        } catch (Exception e) {
            System.out.println(e);
        }
        boolean b = false;
        return b;
    }
}
