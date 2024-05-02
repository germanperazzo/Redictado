/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ej02;

/**
 *
 * @author Chorizard
 */
public class Estacionamiento {
    private String nombre;
    private String direccion;
    private double horaApertura;
    private double horaCierre;
    private Auto[][] v;
    private int piso;
    private int plaza;
    
    //la matriz no la inicio en null por q java ya lo hace
    public Estacionamiento(String nombre, String direccion) {
        this.setDireccion(direccion);
        this.setNombre(nombre);
        this.setHoraApertura(8.0);
        this.setHoraCierre(21.0);
        this.v = new Auto[5][10];
        this.piso = 5;
        this.plaza = 10;
    }

    public Estacionamiento(String nombre, String direccion, double horaApertura, double horaCierre,int n, int m) {
        this.setNombre(nombre);
        this.setDireccion(direccion);
        this.setHoraApertura(horaApertura);
        this.setHoraCierre(horaCierre);
        this.v = new Auto[n][m];
        this.piso = n;
        this.plaza = m;
    }
    
    public void agregarAuto(Auto a, int n, int m){
        this.v[n-1][m-1]= a;
    }
    
    public void buscarAuto(String unaPatente){
        int max = this.piso * this.plaza;
        int cont = 0;
        boolean encontre = false;
        
        while (cont < max && !encontre){
            if(v[cont/this.plaza][cont%this.plaza] != null){
                if(v[cont/this.plaza][cont%this.plaza].equals(unaPatente)){
                    encontre = true;
                }
            }
            cont++;
        }
        
        
        if(encontre){
            System.out.println("el auto esta en el piso "+ cont/this.plaza + " y en la plaza "+ cont%this.plaza);
        }else{
            System.out.println("auto no encontrado");
        }
    }
    
    public int contarPlaza(int y){
        int x = 0;
        for (int i = 0; i < this.piso; i++) {
            if(v[i][y] != null){
                x++;
            }
        }
        return x;
    }
    
    @Override
    public String toString(){
        String str = String.format("Estacion %s en la direccion %s abre de %.2f a %.2f",this.getNombre(),this.getDireccion(),this.getHoraApertura(),this.getHoraCierre() );
        for (int i = 0; i < this.piso; i++) {
            for (int j = 0; j < this.plaza; j++) {
                if(v[i][j] == null){
                    str+= "\n"; 
                    str+= String.format("piso %d plaza %d: ",i,j);
                    str += v[i][j].toString();
                }else {
                    str+= "\n";
                    str+= String.format("piso %d plaza %d: libre",i,j);
                }
            }
        }
        return str;
    } 
    
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public double getHoraApertura() {
        return horaApertura;
    }

    public void setHoraApertura(double horaApertura) {
        this.horaApertura = horaApertura;
    }

    public double getHoraCierre() {
        return horaCierre;
    }

    public void setHoraCierre(double horaCierre) {
        this.horaCierre = horaCierre;
    }
    
    
}
