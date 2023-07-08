package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class mysql2 {

    private static Connection connection;

    public static void createConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db5", "root", "200528100634@Vn");
        } catch (ClassNotFoundException | SQLException e) {
        }
    }

    public static ResultSet search(String query) throws Exception {

        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery(query);
        return resultSet;

    }

    public static int iud(String query) throws Exception {

        Statement statement = connection.createStatement();
        int result = statement.executeUpdate(query);
        return result;

    }
}
