/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;

/**
 *
 * @author Chorizard
 */
public class Subsidio {
    private double monto;
    private String motivo;
    private boolean otorgado = false;

    public Subsidio(double monto, String motivo) {
        this.setMonto(monto);
        this.setMotivo(motivo);
    }

    private void setMotivo(String motivo) {
        this.motivo = motivo;
    }
    
    
    
    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public boolean isOtorgado() {
        return otorgado;
    }

    public void setOtorgado(boolean otorgado) {
        this.otorgado = otorgado;
    }
    
    
}
