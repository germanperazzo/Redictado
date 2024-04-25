
package tema1;

//Paso 1: Importar la funcionalidad para lectura de datos
import PaqueteLectura.GeneradorAleatorio;
import PaqueteLectura.Lector;

public class Ej02Jugadores {

  
    public static void main(String[] args) {
        GeneradorAleatorio.iniciar(); 
        //Paso 2: Declarar la variable vector de double 
        int DF = 15;
        
        double [] vector = new double[DF];
        
        
        
        //Paso 3: Crear el vector para 15 double 
        
        //Paso 4: Declarar indice y variables auxiliares a usar
        int cant;
        double alturaPromedio, alturaTotal;        
        
        
        cant= 0;
        alturaTotal =0;
        
        for (int i = 0; i < DF; i++) {
            vector[i] = GeneradorAleatorio.generarDouble(10);
            alturaTotal +=   vector[i];
            System.out.println(i +":"+ vector[i]);
        }
        System.out.println(alturaTotal);
        System.out.println(alturaPromedio= alturaTotal/DF);
        cant = 0;
        for (int i = 0; i < 10; i++) {
            if(alturaPromedio > vector[i]){
                cant++;
            }
        }
        
        System.out.println(cant);
        //Paso 6: Ingresar 15 numeros (altura), cargarlos en el vector, ir calculando la suma de alturas
        
        //Paso 7: Calcular el promedio de alturas, informarlo
        
        //Paso 8: Recorrer el vector calculando lo pedido (cant. alturas que están por encima del promedio)
     
        //Paso 9: Informar la cantidad.
    }
    
}
