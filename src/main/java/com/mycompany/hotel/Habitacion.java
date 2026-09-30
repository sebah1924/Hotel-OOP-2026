/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hotel;

/**
 *
 * @author sebah
 */
public class  Habitacion {
    
    TipoHabitacion tipo;

    public Habitacion(TipoHabitacion tipo) {
        this.tipo = tipo;
    }
    
  public int getTarifa(){
      return tipo.getTarifaBase();
  }

    public TipoHabitacion getTipo() {
        return tipo;
    }

  
   
  
    
}
