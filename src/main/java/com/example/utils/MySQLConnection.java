package com.example.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MySQLConnection {

    public Connection getConnection() {
        final String DBNAME = "ventas",
                USERNAME = "root",
                PASSWORD = "root",
                TIMEZONE = "America/Mexico_City",
                USESSL = "false",
                PUBLICKEY = "true";

        String dataSource = String.format("jdbc:mysql://localhost:3306/%s?user=%s" +
                "&password=%s&serverTimezone=%s&useSSL=%s&allowPublicKeyRetrieval=%s",
                DBNAME, USERNAME, PASSWORD, TIMEZONE, USESSL, PUBLICKEY);

        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            return DriverManager.getConnection(dataSource);
        } catch (SQLException e) {
            System.out.println(this.getClass().getCanonicalName() + " -> " + e.getMessage());
        }
        return null;
    }

    public static void main(String[] args) {
        Connection conn = new MySQLConnection().getConnection();
        if (conn != null) {
            try {
                System.out.println("Conexión realizada :)");
                conn.close();
            } catch (SQLException e) {
                System.out.println(e);
            }
        } else {
            System.out.println("Conexión fallida :(");
        }
    }

    public void close(Connection conn, PreparedStatement pstm, ResultSet rs) {
        try {
            if (conn != null)
                conn.close();
            if (pstm != null)
                pstm.close();
            if (rs != null)
                rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
