/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema3;

import tema2.Persona;
import PaqueteLectura.GeneradorAleatorio;

public class Habitacion {
    private double costo;
    private Persona p;
    private boolean ocupada;

    public Habitacion() {
        this.costo = GeneradorAleatorio.generarDouble(6000) + 2000;
        this.ocupada = false;
    }

    public double getCosto() {
        return costo;
    }

    public Persona getP() {
        return p;
    }

    public boolean isOcupada() {
        return ocupada;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }
    
    public void setCliente(Persona p){
        if(!this.ocupada){
            this.p = p;
            this.ocupada = true;
        }
    }
    
}
