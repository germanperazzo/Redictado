/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema3;

import PaqueteLectura.GeneradorAleatorio;
import tema2.Persona;

public class Ej04 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         Hotel hotel = new Hotel(35);
        
        int maximaOcupacion = GeneradorAleatorio.generarInt(10) + 20;
        
        for (int i = 0; i < maximaOcupacion; i++) {
            String nombre = GeneradorAleatorio.generarString(20);
            int edad = GeneradorAleatorio.generarInt(60) + 20;
            int dni = GeneradorAleatorio.generarInt(39999999) + 10000000;
            
            Persona p = new Persona(nombre, dni, edad);
            
            int habitacion = GeneradorAleatorio.generarInt(34) + 1;
            
            hotel.ingresarCliente(p, habitacion);
        }
        
        System.out.println(hotel);
        
        double aumento = GeneradorAleatorio.generarDouble(500);
        System.out.println(String.format("\n-----\nSe aumentaran en $%.2f los precios de todas las habitaciones\n-----\n", aumento));
        
        hotel.aumentarPrecios(aumento);
        
        System.out.println(hotel);
    }
    
}
