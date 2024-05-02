/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ej04;


public class Director extends Persona{
    private int antiguedad;

    public Director(int antiguedad, String nombre, int dni, int edad) {
        super(nombre, dni, edad);
        this.antiguedad = antiguedad;
    }
    
    @Override
    public String toString(){
        String str = super.toString() + " tengo " +this.antiguedad + " de antiguedad ";
        return str;
    }
}
