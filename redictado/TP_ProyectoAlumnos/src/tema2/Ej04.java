package tema2;

import PaqueteLectura.GeneradorAleatorio;

public class Ej04 {
    
    public static void main(String[] args) {
        GeneradorAleatorio.iniciar();
        
        int dias = 5;
        int turno = 8;
        
        int maxInscriptos = dias * turno;
        int totalInscriptos = 0;
        
        Persona[][] casting = new Persona[dias][turno];
        int [] v = new int[dias];  
        
        for (int i = 0; i < dias; i++) {
            v[i]= 0;
        }
        
        
        String nombre = GeneradorAleatorio.generarString(3);
        
        while(totalInscriptos < maxInscriptos && !nombre.equals("zzz")){
            int edad = GeneradorAleatorio.generarInt(99);
            int dni = GeneradorAleatorio.generarInt(9999);
        
            Persona p = new Persona (nombre,dni,edad);
            
            int t = GeneradorAleatorio.generarInt(5);
            
            boolean diaValido = false;
            
            while(!diaValido){
                if(v[t] < turno){
                    casting[t][v[t]]= p;
                    v[t]++;
                    diaValido = true;
                }
                else{
                    System.out.println("turno ocupado");
                    t = GeneradorAleatorio.generarInt(5);
                }
            } 
            
            totalInscriptos++;
            nombre = GeneradorAleatorio.generarString(3); 
        }
    }
}
