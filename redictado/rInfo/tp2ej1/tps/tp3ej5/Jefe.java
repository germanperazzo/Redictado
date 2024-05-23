/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp3ej5;

import rInfo.*;
public class Jefe extends Robot{

    public Jefe(int id) {
        super(id);
    }
    
    
    
    @Override
    public void comenzar() {
        int aux = 0;
        int max = -1;
        int ganador= 0;
        for (int i = 1; i < 5; i++) {
            Mensaje m = recibirMensaje();
            aux = m.getMensajeInt();
            if (aux>max) {
                max = aux;
                ganador = m.getIDEmisor();
            }
        }
        informar(ganador);
    }
    
}
