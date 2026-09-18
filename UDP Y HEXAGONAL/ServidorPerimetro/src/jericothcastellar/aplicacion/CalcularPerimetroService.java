/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jericothcastellar.aplicacion;

import jericothcastellar.dominio.Rectangulo;

/**
 * Servicio de aplicación que orquesta el cálculo del perímetro.
 */
public class CalcularPerimetroService {
        
    /**
     * Ejecuta el cálculo del perímetro de un rectángulo.
     * @param largo valor del lado largo
     * @param ancho valor del lado ancho
     * @return perímetro como String
     */
    public String ejecutar(double largo, double ancho) {
        Rectangulo r = new Rectangulo(largo, ancho);
        return String.valueOf(r.calcularPerimetro());
    }
}