/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp2ej4;

import rInfo.*;
import PaqueteLectura.GeneradorAleatorio;
public class Jefe extends Robot{

    public Jefe(int id) {
        super(id);
    }
    
    @Override
    public void comenzar() {
        int max = -1;
        int ganador = 0;
        int random = 0;
        for (int i = 0; i < 10; i++) {
            random = GeneradorAleatorio.generarInt(3)+1;
            int x = GeneradorAleatorio.generarInt(49)+25;
            int y = GeneradorAleatorio.generarInt(49)+25;
            enviarMensaje(random,true);
            enviarMensaje(random,x);        
            enviarMensaje(random,y);
            Mensaje m = recibirMensaje();
            boolean ok = m.getMensajeBoolean();
        }
        for (int i = 0; i < 4; i++) {
            enviarMensaje((i+1),false);
        }
        for (int i = 0; i < 4; i++) {
            Mensaje n = recibirMensaje();
            int aux = n.getMensajeInt();
            if(aux > max){
                max = aux;
                ganador = n.getIDEmisor();
            }
            
        }
        for (int i = 1; i <= 4; i++) {
            if(i==ganador){
                enviarMensaje(ganador,true);
            }else{
                enviarMensaje(i,false);
            }
        }
    }
    
}
