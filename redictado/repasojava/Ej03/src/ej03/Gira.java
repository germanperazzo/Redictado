/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ej03;


public class Gira extends Recital{
    private String nombreRecital;
    private Fecha[] fechas;
    private int FechasMax;
    private int actual=0;
    private int dl = 0;

    public Gira(String nombreRecital, int FechasMax, String nombreBanda, int cantTemas) {
        super(nombreBanda, cantTemas);
        this.nombreRecital = nombreRecital;
        
        this.FechasMax = FechasMax;
        this.fechas = new Fecha[FechasMax];
    }
    
    public void agregarFecha(String ciudad,String dia){
        if(this.dl < this.FechasMax){
           this.fechas[dl] = new Fecha(ciudad,dia);
           dl++;
        }
    }
    
    @Override
    public void actuar() {
        if (this.actual < this.FechasMax) {
            
            System.out.println("Buenas noches " + this.fechas[actual].getCiudad() + ":");
            super.actuar();
            actual++;
        }
    }
    
    @Override
    public double calcularCosto() {
        return this.FechasMax * 30000;
    }
}
