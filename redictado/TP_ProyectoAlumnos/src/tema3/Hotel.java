/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema3;

import tema2.Persona;

public class Hotel {
    int df;
    
    Habitacion[]hotel;

    private void setIniciarHabitaciones(){
        for (int i = 0; i < this.df; i++) {
            this.hotel[i] = new Habitacion();
        }
    }
    
    public Hotel(int df) {
        this.df = df;
        this.hotel = new Habitacion[df];
        this.setIniciarHabitaciones();
    }
    
    public void ingresarCliente(Persona p,int i ){
        this.hotel[i-1].setCliente(p);
    }
    
    public void aumentarPrecios(double p){
        for (int i = 0; i < this.df; i++) {
            this.hotel[i].setCosto(this.hotel[i].getCosto() + p);
        }
    }

    @Override
    public String toString() {
        String aux = "El detalle del hotel es el siguiente:";
        for (int i = 0; i < this.df; i++) {
            boolean ocupada = this.hotel[i].isOcupada();
            
            aux +=String.format("\n - Habitacion %d: $%.2f %s", i+1, this.hotel[i].getCosto(), ocupada ? "ocupada" : "libre" );
            
            if (ocupada) {
                aux += String.format(", %s", this.hotel[i].getP());
            }
            
        }
        return aux;
    }
    
    
    
}
