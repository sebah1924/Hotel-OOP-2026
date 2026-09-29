/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hotel;

import java.util.Date;

/**
 *
 * @author sebah
 */
public class Alquiler {
    
    Usuario usuario;
    Date fecha;
    
    
    
    public int getTotalPrecio() {
        int tarifa=0;
      for (Habitacion habitacion : usuario.getHabitaciones()) {
   tarifa +=habitacion.getTarifa();
}
        return tarifa;
    }
    
    
    
}
