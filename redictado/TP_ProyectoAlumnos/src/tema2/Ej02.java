/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema2;

import PaqueteLectura.GeneradorAleatorio;

public class Ej02 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GeneradorAleatorio.iniciar();
        
        int df =15;
        
        Persona [] v = new Persona[df];
        
        int edad = GeneradorAleatorio.generarInt(100);
        
        int dl = 0;
        
        while(edad !=0 && dl<15){
            String nombre = GeneradorAleatorio.generarString(5);
            int dni = GeneradorAleatorio.generarInt(4);
            
            v[dl]= new Persona(nombre,dni, edad);
            dl++;
            edad = GeneradorAleatorio.generarInt(100);
        } 
        
        int cant = 0;
        int minEdad = 999;
        int minPersona = 0;
        
        for (int i = 0; i < dl; i++) {
            if(v[i].getEdad()> 65){
                cant++;
            }
            if(v[i].getDNI()< minEdad){
                minPersona = v[i].getDNI();
            }
        }
        
        System.out.println(cant);
        System.out.println(v[minPersona].toString());
 
    }
    
}
