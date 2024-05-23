/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp2ej4;

import rInfo.*;
public class Recolector extends Robot{

    public Recolector(int id) {
        super(id);
    }
    
    private int juntar(){
        int x = 0;
        while(hayFlorEnLaEsquina()){
            tomarFlor();
            x++;
        }
        while(hayPapelEnLaEsquina()){
            tomarPapel();
            x++;
        }
        return x;
    }
    
    @Override
    public void comenzar() {
       int cant = 0;
       int x = posAv();
       int y = posCa();
       
       Mensaje m = recibirMensaje(5);
       boolean ok = m.getMensajeBoolean();
       
       while(ok){
            m = recibirMensaje();
            int xa = m.getMensajeInt();
            m = recibirMensaje();
            int ya = m.getMensajeInt();
            pos(xa,ya);
            cant += juntar();
            pos(x,y);
            enviarMensaje(5,true);
            m = recibirMensaje();
            ok = m.getMensajeBoolean(); 
       }
       enviarMensaje(5,cant);
       m = recibirMensaje();
       ok = m.getMensajeBoolean();
       if(ok){
           pos(50,50);
       }
    }
    
}
