package tema3;

import PaqueteLectura.GeneradorAleatorio;

public class Ej01 {

    public static void main(String[] args) {
        
        GeneradorAleatorio.iniciar();
        
        int ladoA = GeneradorAleatorio.generarInt(20)+1;      
        int ladoB = GeneradorAleatorio.generarInt(20)+1;  
        int ladoC = GeneradorAleatorio.generarInt(20)+1; 
        
        String colorRelleno = "Rojo";
        String colorLineas = "Azuul";
        
        Triangulo triangulo = new Triangulo(ladoA,ladoB,ladoC,colorRelleno,colorLineas);
        
        System.out.println(triangulo.calcularPerimetro());
        System.out.println(triangulo.calcularArea());
    }
    
}
