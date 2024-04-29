/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema4;


public class Jugador extends Empleado {
    private int partidosJugados;
    private int goles;

    public Jugador(int partidosJugados, int goles, String nombre, double sueldoBasico, int antiguedad) {
        super(nombre, sueldoBasico, antiguedad);
        this.setPartidosJugados(partidosJugados);
        this.setGoles(goles);
    }
    
    
    
    
    @Override
    public double calcularEfectividad() {
        return this.getGoles()/ this.getPartidosJugados();
    }

    @Override
    public double calcularSueldoACobrar() {
        double aux = this.calcularSueldo();
        
        if(this.calcularEfectividad() > 0.5){
            aux += this.getSueldoBasico();
        }
        return aux;
    }

    public int getPartidosJugados() {
        return partidosJugados;
    }

    public void setPartidosJugados(int partidosJugados) {
        this.partidosJugados = partidosJugados;
    }

    public int getGoles() {
        return goles;
    }

    public void setGoles(int goles) {
        this.goles = goles;
    }
    
    
    
}
