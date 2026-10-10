/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

/**
 *
 * @author sebah
 */


import com.mycompany.hotel.Usuario; 
import  com.mycompany.hotel.UsuarioDAO;

public class Servicios {
    
    private UsuarioDAO usuarioDAO = new UsuarioDAO();

    
    public void alquilar(Usuario usuario) throws Exception {
       
        usuarioDAO.guardar(usuario);
        System.out.println("Controlador: Registro de usuario enviado exitosamente al DAO.");
    }
}

