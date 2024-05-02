/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;

public class Investigador {
    private String nombre;
    private int categoria;
    private String especialidad;
    private Subsidio[] v;
    private int dl = 0;

    public Investigador(String nombre, int categoria, String especialidad) {
        this.setNombre(nombre);
        this.setEspecialidad(especialidad);
        this.setCategoria(categoria);
        this.v = new Subsidio[5];
    }
    
    public void agregarSubsidio(Subsidio unSubsidio){
        if(dl < 5){
            this.v[dl] = unSubsidio;
            dl++;
        }else{
            System.out.println("Maximo de sub pedidos"); 
        }
    }
    
    public Subsidio mostrarSubsidio(int i){
        return v[i];
    }
    
    public double SumarSubsidiosOtorgados(){
        double aux = 0;
        for (int i = 0; i < this.dl; i++) {
            if(v[i].isOtorgado()){
                aux += v[i].getMonto();
            }
        }
        return aux;
    }
    
    public void otorgarSubsidios(){
        for (int i = 0; i < dl; i++) {
            if(!v[i].isOtorgado()){
                v[i].setOtorgado(true);
            }
        }
    }
    
    @Override
    public String toString(){
        String str = String.format("Investigador: %s, categoria: %d, especialidad %s, y total de subsidios otorgados es %.2f", this.getNombre(), this.getCategoria(), this.getEspecialidad(), this.SumarSubsidiosOtorgados());
        return str;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
    
    
}
