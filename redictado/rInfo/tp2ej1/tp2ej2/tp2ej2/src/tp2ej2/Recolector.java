/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp2ej2;

import rInfo.*;

import PaqueteLectura.GeneradorAleatorio;
public class Recolector extends Robot{
    
    public Recolector(int id) {
        super(id);
    }
    
    
    
    private int juntarF(){
        int f = 0;
        while (hayFlorEnLaEsquina()){
            tomarFlor();
            f++;
        }
            
        return f;
    }
    
    private void izq(){
        for (int i = 0; i < 3; i++) {
            derecha();
        }
    }
    
    
    private int juntarP(){
        int p = 0;
        while (hayPapelEnLaEsquina()){
        tomarPapel();
            p++;
        }
            
        return p;
    }
    
    private int escalera(){
        int x = 0;
        
        int altura = GeneradorAleatorio.generarInt(4)+1;
        for (int i = 0; i < 4; i++) {
            int f = 0;
            int p = 0; 
            for (int j = 0; j < altura; j++) {
               f = f+ juntarF();
               p = p + juntarP();
               mover(); 
            }
            derecha();
            f = f + juntarF();
            p = p + juntarP();
            mover();
            izq();

            if(f>p){
              x++;  
            }
        }
        return x;
    }
    
    
    @Override
    public void comenzar() {
        int x = escalera();
         enviarMensaje(4,x);
    }
    
}
