/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ej04;


public class Hileras extends Coro{
    private Corista[][] v;
    private int fila;
    private int columna;
    private int cantCoristas=0;
    private int maxCoristas;

    public Hileras(int fila, int columna, String nombreCoro, Director director) {
        super(nombreCoro, director);
        this.fila = fila;
        this.columna = columna;
        
        this.maxCoristas= this.fila*this.columna;
        this.v = new Corista[fila][columna];
    }
    
    
    
    
    @Override
    public void agregarCorista(Corista c) {
        this.v[this.cantCoristas/this.columna][this.cantCoristas%this.columna]= c;
        this.cantCoristas++;
    }

    @Override
    public boolean estaLleno() {
        return this.maxCoristas == this.cantCoristas;
    }

    @Override
    public boolean estaBienFormado() {
        return true;
    }
}
