/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ej02;


public class Auto {
    private String nombre;
    private String patente;

    public Auto(String nombre, String patente) {
        this.setNombre(nombre);
        this.setPatente(patente);
    }

    
    
    private String getNombre() {
        return nombre;
    }

    private void setNombre(String nombre) {
        this.nombre = nombre;
    }

    private String getPatente() {
        return patente;
    }

    private void setPatente(String patente) {
        this.patente = patente;
    }
    
    @Override
    public String toString(){
        String str = String.format("patente: %s, dueño: %s", this.getPatente(),this.nombre);
        return str;
    }
}
