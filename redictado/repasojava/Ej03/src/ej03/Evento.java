/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ej03;

/**
 *
 * @author Chorizard
 */
public class Evento extends Recital{
    private String motivo;
    private String nombreContratante;
    private String diaEvento;

    public Evento(String motivo, String nombreContratante, String diaEvento, String nombreBanda, int cant) {
        super(nombreBanda, cant);
        this.motivo = motivo;
        this.nombreContratante = nombreContratante;
        this.diaEvento = diaEvento;
    }

    @Override
    public double calcularCosto() {
        double s;
        if (this.getMotivo().equals("beneficio")){
            s =0;
        }else if (this.getMotivo().equals("show de TV ")){
            s=0;
        }else
            s=0;
        return s;
    }
    
    

    
    

    @Override
    public void actuar() {
        String s;
        if (this.getMotivo().equals("beneficio")){
            s ="Recuerden colaborar con…" + this.getNombreContratante();
        }else if (this.getMotivo().equals("show de TV ")){
            s="Saludos amigos televidentes";
        }else
            s="Un feliz cumpleaños para…" + this.getNombreContratante();
        System.out.print(s);
        super.actuar(); 
    }

    
    
    
    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getNombreContratante() {
        return nombreContratante;
    }

    public void setNombreContratante(String nombreContratante) {
        this.nombreContratante = nombreContratante;
    }

    public String getDiaEvento() {
        return diaEvento;
    }

    public void setDiaEvento(String diaEvento) {
        this.diaEvento = diaEvento;
    }
    
}
