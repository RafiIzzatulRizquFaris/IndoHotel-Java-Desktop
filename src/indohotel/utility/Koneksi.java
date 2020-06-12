/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package indohotel.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author risqu
 */
public class Koneksi {
    Connection conn;
    Statement statement;
    ResultSet resultSet;
    private Connection Koneksi;

    public Connection getKoneksi() {
        try {
            String url = "jdbc:mysql://localhost:3306/indohoteldb";
            String user = "root";
            String pw = "";
            
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            Koneksi = DriverManager.getConnection(url, user, pw);
            System.out.println("Connection Success");
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return Koneksi;
    }
}
