/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp5ej4;

import rInfo.*;
import PaqueteLectura.GeneradorAleatorio;
public class Jefe extends Robot {

    public Jefe(int id) {
        super(id);
    }
    
    
    
    @Override
    public void comenzar() {
        int f = 0;
        int id,x,y;
        for (int i = 0; i < 8; i++) {
            id = GeneradorAleatorio.generarInt(3)+1;
            x = GeneradorAleatorio.generarInt(20)+40;
            y = GeneradorAleatorio.generarInt(20)+40;
            enviarMensaje(id,true);
            enviarMensaje(id,x);
            enviarMensaje(id,y);
        }
        
        enviarMensaje(1,false);
        enviarMensaje(2,false);
        enviarMensaje(3,false);
        
        for (int i = 0; i < 3; i++) {
            Mensaje m = recibirMensaje();
            f += m.getMensajeInt();
        }
        informar(f);
    }
    
}
