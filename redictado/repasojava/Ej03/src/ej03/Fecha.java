/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ej03;

/**
 *
 * @author Chorizard
 */
public class Fecha {
    private String ciudad;
    private String dia;

    public Fecha(String ciudad, String dia) {
        this.ciudad = ciudad;
        this.dia = dia;
    }

    public String getCiudad() {
        return ciudad;
    }
}
