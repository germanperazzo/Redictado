/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp2ej2;

import rInfo.*;
public class Jefe extends Robot {

    public Jefe(int id) {
        super(id);
    }

    
    
    @Override
    public void comenzar() {
        int x = 0;
        for (int i = 0; i < 3; i++) {
          Mensaje m = recibirMensaje();
          int dif = m.getMensajeInt();
          x += dif;
        }
        informar("en total " + x);
        
    }
    
}
