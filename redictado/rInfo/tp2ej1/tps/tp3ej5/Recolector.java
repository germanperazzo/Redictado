/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp3ej5;

import rInfo.*;
public class Recolector extends Robot {

    public Recolector(int id) {
        super(id);
    }
    
    
    @Override
    public void comenzar() {
        int x = posAv();
        int y = posCa();
        boolean ok = true;
        while ((y<100) && (ok)) {
            bloquearEsquina(11, 11);
            pos(11, 11);
            if (hayFlorEnLaEsquina()) {
                tomarFlor();
                pos(x, y);
                liberarEsquina(11, 11);
                depositarFlor();
                mover();
                y = posCa();
            }
            else{
                ok = false; 
                pos(x, y);
                liberarEsquina(11, 11);
            }
            
        }
        enviarMensaje(5,y);
        
    }
    
}
