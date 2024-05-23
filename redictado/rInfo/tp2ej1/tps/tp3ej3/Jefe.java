/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp3ej3;

import rInfo.*;
import PaqueteLectura.GeneradorAleatorio;
public class Jefe extends Robot{

    public Jefe(int id) {
        super(id);
    }
    
    
    
    @Override
    public void comenzar() {
        int x;
        int y;
        int max = -1;
        int aux;
        int ganador=0;
        
            
        
        for (int i = 1; i < 5; i++) {
            x = GeneradorAleatorio.generarInt(8)+2;
            enviarMensaje(i,x);
            y = GeneradorAleatorio.generarInt(8)+2;
            enviarMensaje(i,y);
        }
        for (int i = 0; i < 4; i++) {
            Mensaje m = recibirMensaje();
            aux = m.getMensajeInt();
            if(aux>max){
                max = aux;
                ganador = m.getIDEmisor();
            }
         
        }
        
        informar(ganador);   
    }
    
}