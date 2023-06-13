/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author virulnirmala
 */
public class database {

    private static Connection c;
    private static final String username = "root";
    private static final String Password = "200528100634@Vn";
    private static final String Database = "db5";

    public static Statement createConnection() throws Exception {
        if (c == null) {
            Class.forName("com.mysql.cj.jdbc.Driver");
             c = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + Database, username, Password);
        }
        Statement s = c.createStatement();
        return s;
    }

    public static void IUD(String query) {
        try {
            createConnection().executeUpdate(query);

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static ResultSet Search(String query) throws Exception {

        ResultSet rs = createConnection().executeQuery(query);
        return rs;

    }

}
