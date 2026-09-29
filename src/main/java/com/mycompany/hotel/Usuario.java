/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hotel;

import java.util.ArrayList;

/**
 *
 * @author sebah
 */
public class Usuario {
    
    String nombre;
    String cedula;
    int edad;
  private ArrayList<Habitacion>habitaciones= new ArrayList<>();
  
    
  public int getCantidadHabitaciones(){
      return habitaciones.size();
      
  }
    
  public void registroHabitacion(Habitacion h){
      habitaciones.add(h);
      System.out.println("Habitacion añadida correctamente" + h.getClass().getSimpleName());
  }

    public ArrayList<Habitacion> getHabitaciones() {
        return habitaciones;
    }
  
  
  
    
}
