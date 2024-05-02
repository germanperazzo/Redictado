/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;


public class Proyecto {
    private String nombre;
    private int codigo;
    private String director;
    private Investigador[] v ;
    private int dl =0;

    public Proyecto(String nombre, int codigo, String director) {
        this.setNombre(nombre);
        this.setCodigo(codigo);
        this.setDirector(director);
        this.v = new Investigador[50];
    }

    public void agregarInvestigador(Investigador unInvestigador){
        if(dl < 50){
            v[dl] = unInvestigador;
            dl++;
        }else{
            System.out.println("maximo de investigadores por proyecto");
        }
    }
    
    public double dineroTotalOtorgado(){
        double aux =0;
        for (int i = 0; i < this.dl; i++) {
            aux += v[i].SumarSubsidiosOtorgados();
        }
        return aux;
    }
    
    public void otorgarTodos(String nombre_completo){
       boolean encontrado = false;
       int i = 0;
       while(!encontrado && i < this.dl){
            if(nombre_completo.equals(v[i].getNombre())){
               v[i].otorgarSubsidios();
               encontrado = true;
            }
            i++;
       }
       if(encontrado){
           System.out.println("Subsidios otorgados");
       }else{
           System.out.println("Investigador no encontrado");
       } 
    }
    
    @Override
    public String toString(){
        String str = String.format("Nombre: %s, Codigo %d, Nombre del Direcor: %s, y el total del proyecto es %.2f",this.getNombre(),this.getCodigo(),this.getDirector(),this.dineroTotalOtorgado());
        for (int i = 0; i < this.dl; i++) {
            str += "\n " + v[i].toString() ;
        }
        return str;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }
    
    
}
