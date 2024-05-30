/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp5ej5;

import rInfo.*;
import PaqueteLectura.GeneradorAleatorio;
public class Server extends Robot {

    public Server(int id) {
        super(id);
    }
    
    
    
    @Override
    public void comenzar() {
        while(hayPapelEnLaEsquina()){
            tomarPapel();
        }
        
        int x = posAv();
        int y = posCa();
        
        
        for (int i = 0; i < 12; i++) {
            Mensaje m = recibirMensaje();
            int id = m.getIDEmisor();
            int random = GeneradorAleatorio.generarInt(5)+1;
            for (int j = 0; j < random; j++) {
                bloquearEsquina(100,1);
                pos(100,1);
                depositarPapel();
                pos(x,y);
                liberarEsquina(100,1);
            }
            enviarMensaje(id,random);
        }
    }
    
}
