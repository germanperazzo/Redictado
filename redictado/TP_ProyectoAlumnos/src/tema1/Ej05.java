
package tema1;

import PaqueteLectura.Lector;

public class Ej05 {

    public static void main(String[] args) {
        
        
        int aspectos = 4;
        int clientes = 5;
        
        int [][] v = new int[clientes][aspectos];
        
        for (int i = 0; i < clientes; i++) {
            for (int j = 0; j < aspectos; j++) {
                v[i][j] = Lector.leerInt();
            }
        }
        
        int [] v2 = new int[aspectos];
        
        for (int i = 0; i < aspectos; i++) {
            v2[i] = 0;
        }
        
        for (int i = 0; i < clientes; i++) {
            for (int j = 0; j < aspectos; j++) {
                v2[j] += v[i][j];
            }
        }
        
        for (int i = 0; i < aspectos; i++) {
            System.out.println((double)v2[i]/5);
        }
        
    }
    
}
