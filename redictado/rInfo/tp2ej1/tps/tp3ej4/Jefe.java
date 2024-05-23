/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp3ej4;

import rInfo.*;
public class Jefe extends Robot {

    public Jefe(int id) {
        super(id);
    }
    
    
    
    @Override
    public void comenzar() {
        int a=0;
        for (int i = 0; i < 4; i++) {
            Mensaje m = recibirMensaje();
            a = m.getIDEmisor();
        }
        informar(a);
    }
    
}
