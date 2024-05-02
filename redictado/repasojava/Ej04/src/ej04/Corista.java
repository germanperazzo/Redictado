/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ej04;

/**
 *
 * @author Chorizard
 */
public class Corista extends Persona {
    private int tono;

    public Corista(int tono, String nombre, int dni, int edad) {
        super(nombre, dni, edad);
        this.tono = tono;
    }

    public int getTono() {
        return tono;
    }

    public void setTono(int tono) {
        this.tono = tono;
    }
    
    
    
    @Override
    public String toString(){
        String str = super.toString() + " tengo " +this.tono + " de tono ";
        return str;
    }
}
