/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 *
 * @author Mun Chan
 */
public class DBConnection {
    Connection con = null;
    public static Connection openConnection() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/crm?useSSL=false";
        String user = "root";
        String password = "";
        Connection con = (Connection) DriverManager.getConnection(url, user, password);
        
        try {
            System.out.println("connection!");
        } catch (Exception e) {
            System.out.println("not connect");
        }
        return con;
    }
}
