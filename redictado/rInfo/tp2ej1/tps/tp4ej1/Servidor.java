/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp4ej1;

import rInfo.*;

public class Servidor extends Robot{

    public Servidor(int id) {
        super(id);
    }
    
    private void juntar(){
        while(hayFlorEnLaEsquina()){
            tomarFlor();
        }
    }
    
    private void depo(int f){
        for (int i = 0; i < f; i++) {
            depositarFlor();
        }
    }
    
    @Override
    public void comenzar() {
       juntar();
       int c = 0;
       int x0 = posAv();
       int y0 = posCa();
       while(c !=3){
           
           Mensaje m = recibirMensaje();
           int id = m.getIDEmisor();
           int f = m.getMensajeInt();
           if(f == 0){
               c++;
           }
           else{
               m = recibirMensaje(id);
               int x = m.getMensajeInt();
               m = recibirMensaje(id);
               int y = m.getMensajeInt();
               pos(x,y);
               depo(f);
               pos(x0,y0);
               enviarMensaje(id,f);
           }
       }
    }
    
}
