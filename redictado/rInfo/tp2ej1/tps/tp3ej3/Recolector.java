/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp3ej3;

import rInfo.*;
public class Recolector extends Robot {

    public Recolector(int id) {
        super(id);
    }
    
    
    
    @Override
    public void comenzar() {
        int av = posAv();
        int ca = posCa();
        int x,y;
        int cant = 0;
        Mensaje m = recibirMensaje(5);
        x = m.getMensajeInt();
        m = recibirMensaje(5);
        y = m.getMensajeInt();
        boolean ok = true;
        while(ok){
            bloquearEsquina(x,y);
            pos(x,y);
            if (hayFlorEnLaEsquina()){
                tomarFlor();
                cant++;
            }else{
                ok = false;
            }
            pos(av,ca);
            liberarEsquina(x,y);
        }
        enviarMensaje(5,cant);
    }
    
}
