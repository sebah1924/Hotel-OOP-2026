/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hotel;

/**
 *
 * @author sebah
 */
import servicios.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UsuarioDAO {

    public void guardar(Usuario usuario) throws SQLException, ClassNotFoundException {
     
        String sql = "INSERT INTO Usuario (id_usuario, nombre, cedula_completa, edad) VALUES (RIGHT(?, 4), ?, ?, ?)";
        Connection con = Conexion.obtener();
        
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, usuario.cedula);
            ps.setString(2, usuario.nombre);
            ps.setString(3, usuario.cedula); 
            ps.setInt(4, usuario.edad);
            
            ps.executeUpdate();
        } finally {
            Conexion.cerrar();
        }
    }
}

