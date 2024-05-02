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
public abstract class Persona {
    private String nombre;
    private int dni;
    private int edad;

    public Persona(String nombre, int dni, int edad) {
        this.nombre = nombre;
        this.dni = dni;
        this.edad = edad;
    }
    
    
   @Override
   public String toString(){
       String str = String.format("mi nombre es %s, mi dni es %d, tengo %d", this.nombre, this.dni, this.edad);
       return str;
   }
}
