package tp5ej4;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import rInfo.*;
public class Recolector extends Robot {

    public Recolector(int id) {
        super(id);
    }
    
    
    
    @Override
    public void comenzar() {
        int x0 = posAv();
        int y0 = posCa();
        int f = 0;
        boolean ok,v;
        int x,y;
        
        Mensaje m = recibirMensaje();
        ok = m.getMensajeBoolean();
        
        while(ok){
            m = recibirMensaje();
            x = m.getMensajeInt();
            m = recibirMensaje();
            y = m.getMensajeInt();
            v = true;
            while(v){
                bloquearEsquina(x,y);
                pos(x,y);
                if(hayFlorEnLaEsquina()){
                    tomarFlor();
                    f++;
                }else{
                    v = false;
                }
                pos(x0,y0);
                liberarEsquina(x,y);
            }
            m = recibirMensaje();
            ok = m.getMensajeBoolean();
        }
        
        
        for (int i = 0; i < f; i++) {
            bloquearEsquina(10,10);
            pos(10,10);
            depositarFlor();
            pos(x0,y0);
            liberarEsquina(10,10);
        }
        
        enviarMensaje(4,f);
    }
    
}
