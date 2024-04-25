
package tema1;

import PaqueteLectura.Lector;


public class Ej04 {

    
    public static void main(String[] args) {
       int piso, oficina;
       int pisodf = 8;
       int oficinadf = 4;
       
      
       
       int [][] edificio = new int [pisodf][oficinadf];
       
       
        for (int i = 0; i < pisodf; i++) {
            for (int j = 0; j < oficinadf ; j++) {
                edificio[i][j] = 0; 
            }
        }
      
        
        
       piso = Lector.leerInt();
       while (piso != 9){
           oficina =Lector.leerInt();
           edificio[piso - 1][oficina- 1]++;
           piso = Lector.leerInt();
       }
       
       
        for (int i = 0; i < pisodf; i++) {
            for (int j = 0; j < oficinadf ; j++) {
                System.out.println(edificio[i][j]);
            }
        }
       
       
    }
    
}
