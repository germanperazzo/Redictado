/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp5ej5;

import rInfo.*;
public class Cliente extends Robot {

    public Cliente(int id) {
        super(id);
    }
    
    
    
    @Override
    public void comenzar() {
        int x = posAv();
        int y = posCa();
        for (int i = 0; i < 4; i++) {
            enviarMensaje(4,1);
            Mensaje m = recibirMensaje(4);
            int random = m.getMensajeInt();
            for (int j = 0; j < random; j++) {
                bloquearEsquina(100,1);
                pos(100,1);        
                tomarPapel();
                pos(x,y);
                liberarEsquina(100,1);
            }
        }
    }
    
}
