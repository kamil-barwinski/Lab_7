package pl.lublin.wsei.java.cwiczenia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
import java.util.Properties;

import com.mysql.jdbc.Driver;

public class MyDB {

    public String host = "localhost";
    public String dbName = "mydb";
    public Number port = 3306;
    Connection conn = null;
    private String user = "root";
    private String password = "root";

    public String setUser(String user) {
        return user;
    }

    public String setPassword(String password) {
        return password;
    }

    public MyDB(String host, String dbName, Number port){

    }


    private void connect() {
        Properties connectionProps = new Properties();
        connectionProps.put("user", user);
        connectionProps.put("password", password);
        connectionProps.put("serverTimezone", "Europe/Warsaw");

        String jdbcString = "jdbc:mysql://" + host + ":" + port + "/" + dbName;

        try {
            conn = DriverManager.getConnection(
                    jdbcString, connectionProps);
        }
        catch (SQLException e) {
            System.out.println("Błąd połączenia do bazy: " +jdbcString);
            System.out.println("Komunikat błędu: " +e.getMessage());
            conn = null;
        }
        System.out.println("Connected to database " +dbName);
    }
    public Connection getConnection() {
        if (conn == null)
            connect();
        return conn;
    }

    public void closeConnection() {
        if (conn != null)
            try {
                conn.close();
            } catch (SQLException e) {
                System.out.println("Błąd przy zamykaniu połączenia bazodanowego: " + e.getMessage());
            }
        conn = null;

    }
}

