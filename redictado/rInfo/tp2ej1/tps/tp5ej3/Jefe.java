/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp5ej3;

import rInfo.*;
public class Jefe extends Robot {

    public Jefe(int id) {
        super(id);
    }
    
    
    
    @Override
    public void comenzar() {
        int c = 2;
        int f;
        while (c != 0){
            Mensaje m = recibirMensaje();
            f = m.getMensajeInt();
            if(f == 6){
                c--;
            }else{
                
            }
        }
    }
    
}
