/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema2;

import PaqueteLectura.GeneradorAleatorio;

public class Ej03 {
    
    
    public static void main(String[] args) {
        
        GeneradorAleatorio.iniciar();
        
        int dias = 5;
        int turno = 8;
        
        int maxInscriptos = dias * turno;
        int totalInscriptos = 0;
        
        Persona[][] casting = new Persona[dias][turno];
        
        String nombre = GeneradorAleatorio.generarString(3);
        
        while(totalInscriptos < maxInscriptos && !nombre.equals("zzz")){
            int edad = GeneradorAleatorio.generarInt(99);
            int dni = GeneradorAleatorio.generarInt(9999);
        
            Persona p = new Persona (nombre,dni,edad);
            
            casting [totalInscriptos/turno][totalInscriptos%turno] = p;
            
            totalInscriptos++;
            
            nombre = GeneradorAleatorio.generarString(3); 
        }
        
        int cant = 0;
        while(casting [cant/turno][cant%turno] != null){
            System.out.println("El turno de la hora" +(cant/turno) +" ;del dia "+ (cant%turno)+ " se llama" + casting[cant/turno][cant%turno].getNombre() );
            cant++;
        }
    }
        
}
