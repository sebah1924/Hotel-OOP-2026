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
    
      public boolean eliminar(String id_usuario) throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM Usuario WHERE id_usuario = ?";
        Connection con = Conexion.obtener();
        
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, id_usuario);
            
            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0;
        } finally {
            Conexion.cerrar();
        }
    }
    
     public boolean actualizar(String id_actual, Usuario usuarioNuevo) throws SQLException, ClassNotFoundException {
        
        String sql = "UPDATE Usuario SET "
                   + "nombre = ?, "
                   + "edad = ?, "
                   + "id_usuario = CASE WHEN cedula_completa <> ? THEN RIGHT(?, 4) ELSE id_usuario END, "
                   + "cedula_completa = ? "
                   + "WHERE id_usuario = ?";
                   
        Connection con = Conexion.obtener();
        
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, usuarioNuevo.nombre);
            ps.setInt(2, usuarioNuevo.edad);
            ps.setString(3, usuarioNuevo.cedula); 
            ps.setString(4, usuarioNuevo.cedula); 
            ps.setString(5, usuarioNuevo.cedula);
            ps.setString(6, id_actual);           
            
            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0;
        } finally {
            Conexion.cerrar();
        }
    }
    
}

