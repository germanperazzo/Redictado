/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp4ej1;

import rInfo.*;
import PaqueteLectura.GeneradorAleatorio;

public class Cliente extends Robot{

    public Cliente(int id) {
        super(id);
    }
    
    private void juntar(int f){
        for (int i = 0; i < f; i++) {
            
            tomarFlor();
            
        }
    }
    
    private void depoMover(int f){
        int x = 0;
        for (int i = 0; i < f; i++) {
            x =posCa(); 
            if (x != 100) {
                depositarFlor();
                mover();
            }
            else{
                depositarFlor();
            }
        }
    }
    
    
    @Override
    public void comenzar() {
        int x = posAv();
        int y = posCa();
        while(y != 100){
            int f = GeneradorAleatorio.generarInt(4)+1;
            enviarMensaje(4,f);
            enviarMensaje(4,x);
            enviarMensaje(4,y+1);
            Mensaje m = recibirMensaje();
            int n = m.getMensajeInt();
            pos(x,y+1);
            juntar(n);
            pos(x,y);
            depoMover(n);
            y = posCa();
        }
        enviarMensaje(4,0);
    }
    
}
