/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package com.mycompany.hotel;

/**
 *
 * @author sebah
 */
public enum TipoHabitacion {
    SENCILLA, DOBLE, SUITE;

    private int tarifaBase;

    public int getTarifaBase() { return tarifaBase; }
    public void setTarifaBase(int tarifaBase) { this.tarifaBase = tarifaBase; }
}
