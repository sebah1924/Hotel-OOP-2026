/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hotel;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author sebah
 */
public class Alquiler {
    
    Usuario usuario;
    Date fecha;
     private ArrayList<Habitacion>habitaciones= new ArrayList<>();
    
    
    public void addRoom(Habitacion h){
        habitaciones.add(h);
        System.out.println("El huesped ha reservado la habitacion"+ h.getTipo()+ "con valor " +
                h.getTarifa());
    
}
    
    
    public int getCantidadHabitaciones(){
      return habitaciones.size();
      
  }
    
    
    
    
    
    public int getTotalPrecio() {
        int tarifa=0;
      for (Habitacion habitacion : habitaciones) {
   tarifa +=habitacion.getTarifa();
}
        return tarifa;
    }
    
    
    
}
