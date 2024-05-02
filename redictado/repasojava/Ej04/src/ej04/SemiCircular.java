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
public class SemiCircular extends Coro{
    private int dl=0;
    private int df;
    private Corista[] v;
    // no se inicia en nil el vector por q lo hace java
    public SemiCircular(int df, String nombreCoro, Director director) {
        super(nombreCoro, director);
        this.df = df;
        
        this.v = new Corista[df];
    }
    
    
    
    @Override
    public void agregarCorista(Corista c) {
        this.v[this.dl] = c;
        this.dl++;
    }

    @Override
    public boolean estaLleno() {
        return this.dl == this.df;
    }

    @Override
    public boolean estaBienFormado() {
        for (int i = 1; i < this.dl; i++) {
            if(v[i].getTono() < v[i-1].getTono()){
                return false;
            }
        }
        return true;
    }
    
    @Override
    public String toString(){
        String str= "";
        return str;
    }
}
