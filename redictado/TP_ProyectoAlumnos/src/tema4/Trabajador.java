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
public class Trabajador extends Persona {
    private String tarea;

    public Trabajador(String tarea, String unNombre, int unDNI, int unaEdad) {
        super(unNombre, unDNI, unaEdad);
        this.setTarea(tarea);
    }
    
    public String getTarea() {
        return tarea;
    }

    public void setTarea(String tarea) {
        this.tarea = tarea;
    }
    
    
    @Override
    public String toString(){
        String str = super.toString() + " soy " + this.getTarea();
        return str;
    }
}
