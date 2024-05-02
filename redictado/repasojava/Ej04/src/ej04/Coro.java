/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ej04;


public abstract class Coro {
    private String nombreCoro;
    private Director director;

    public Coro(String nombreCoro, Director director) {
        this.nombreCoro = nombreCoro;
        this.director = director;
    }
    
    public abstract void agregarCorista(Corista c);
    
    public abstract boolean estaLleno();
    
    public abstract boolean estaBienFormado();
    
    @Override
    public String toString(){
        String str = "Coro " + this.nombreCoro + " a cargo de " + this.director.toString();
        return str;
    }
}
