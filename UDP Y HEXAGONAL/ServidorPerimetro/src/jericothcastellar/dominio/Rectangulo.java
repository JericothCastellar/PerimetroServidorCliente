/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jericothcastellar.dominio;

/**
 * Clase de dominio que representa un rectángulo
 * y permite calcular su perímetro.
 */
public class Rectangulo {

    private final double largo;
    private final double ancho;

    public Rectangulo(double largo, double ancho) {
        this.largo = largo;
        this.ancho = ancho;
    }

    public double calcularPerimetro() {
        return 2 * (largo + ancho);
    }

}
