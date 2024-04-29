/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema4;

import PaqueteLectura.GeneradorAleatorio;

public class Ej01 {

    
    public static void main(String[] args) {
        GeneradorAleatorio.iniciar();
        
        String colorRelleno = "Verde";
        String colorLinea = "Marron";
        
        double ladoA = GeneradorAleatorio.generarDouble(20)+10;
        double ladoB = GeneradorAleatorio.generarDouble(20)+10;
        double ladoC = GeneradorAleatorio.generarDouble(20)+10;
        
        double radio = GeneradorAleatorio.generarDouble(20)+10;
        
        Triangulo t = new Triangulo(ladoA,ladoB, ladoC,colorRelleno ,colorLinea);
        Circulo c = new Circulo(radio,colorRelleno ,colorLinea );
        
        System.out.println(t.toString());
        System.out.println(c.toString());
        
        c.desPintar();
        t.desPintar();
        
        System.out.println(t.toString());
        System.out.println(c.toString());
    }
    
}
