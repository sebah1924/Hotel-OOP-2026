/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicios;

/**
 *
 * @author sebah
 */


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private static Connection con = null;
    
    
    private static final String URL = "jdbc:mysql://localhost:3306/hotel_db";
    private static final String USER = "root";
    private static final String PASSWORD = ""; 

   
    public static Connection obtener() throws SQLException, ClassNotFoundException {
        if (con == null || con.isClosed()) {
         
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            con = DriverManager.getConnection(URL, USER, PASSWORD);
        }
        return con;
    }

    
    public static void cerrar() throws SQLException {
        if (con != null && !con.isClosed()) {
            con.close();
        }
    }
}
