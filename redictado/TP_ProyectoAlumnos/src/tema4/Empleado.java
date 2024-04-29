/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema4;

/**
 *
 * @author Chorizard
 */
public abstract class Empleado {
    private String nombre;
    private double sueldoBasico;
    private int antiguedad;

    public Empleado(String nombre, double sueldoBasico, int antiguedad) {
        this.setNombre(nombre);
        this.setSueldoBasico(sueldoBasico);
        this.setAntiguedad(antiguedad);
    }
    
    public double calcularSueldo(){
        return this.getSueldoBasico() + (this.getSueldoBasico() * (this.getAntiguedad() / 100));
    }
    
    @Override
    public String toString(){
        String str = String.format("mi es %s, mi sueldo es %.2f y mi efectividad es %f", this.getNombre(), this.calcularSueldoACobrar(), this.calcularEfectividad());
        
        return str;
    }
    
    public abstract double calcularEfectividad();
    public abstract double calcularSueldoACobrar();
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getSueldoBasico() {
        return sueldoBasico;
    }

    public void setSueldoBasico(double sueldoBasico) {
        this.sueldoBasico = sueldoBasico;
    }

    public int getAntiguedad() {
        return antiguedad;
    }

    public void setAntiguedad(int antiguedad) {
        this.antiguedad = antiguedad;
    }
    
    
}
