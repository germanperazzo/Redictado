/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema1;

import PaqueteLectura.GeneradorAleatorio;
import PaqueteLectura.Lector;
//Paso 1. importar la funcionalidad para generar datos aleatorios

public class Ej03Matrices {

    public static void main(String[] args) {
        GeneradorAleatorio.iniciar();
	    //Paso 2. iniciar el generador aleatorio     
        int df = 5;    
        
        //Paso 3. definir la matriz de enteros de 5x5 e iniciarla con nros. aleatorios 
        int [][] v = new int[df][df]; 
        for (int i = 0; i < df; i++) {
            for (int j = 0; j < df; j++) {
                v[i][j] = GeneradorAleatorio.generarInt(10);
            }
        }
        //Paso 4. mostrar el contenido de la matriz en consola
        for (int i = 0; i < df; i++) {
            System.out.println("..............");
            for (int j = 0; j < df; j++) {
                System.out.print(v[i][j]);
            }
        }
        //Paso 5. calcular e informar la suma de los elementos de la fila 1
        int cant = 0;
        for (int i = 0; i < df; i++) {
            cant += v[0][i];
        }
        System.out.println("la cant es "+  " "+ cant);
        //Paso 6. generar un vector de 5 posiciones donde cada posición j contiene la suma de los elementos de la columna j de la matriz. 
        //        Luego, imprima el vector.
        
        int [] v2 = new int [df];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                v2[i] += v[i][j];
            }
        }
        
        for (int i = 0; i < 5; i++) {
            System.out.println(v2[i]);
        }
        
        //Paso 7. lea un valor entero e indique si se encuentra o no en la matriz. En caso de encontrarse indique su ubicación (fila y columna)
        //   y en caso contrario imprima "No se encontró el elemento".
        
         boolean enc= false;
        int posI=0, posJ=0, num;
        System.out.print("Ingresar un numero para buscar: ");num= Lector.leerInt();
        for (int i= 0; i<5; i++){
            for (int j= 0; j<5; j++){
                if (v[i][j] == num){
                    enc= true;
                    posI= i;
                    posJ= j;
                }
            }
        }
        if (enc == true){
            System.out.println("Se encontro el numero en la fila " + posI + " columna " + posJ);
        }
        else
            {
                System.out.println("No se encontro el elemento");
            }
        
    }
}
