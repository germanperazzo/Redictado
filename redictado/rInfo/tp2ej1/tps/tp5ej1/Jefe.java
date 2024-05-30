/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp5ej1;

import rInfo.*;
public class Jefe extends Robot {

    public Jefe(int id) {
        super(id);
    }
    
    
    
    @Override
    public void comenzar() {
        int f =0;
        int p = 0;
        for (int i = 0; i < 4; i++) {
            Mensaje m = recibirMensaje();
            int id = m.getIDEmisor();
            switch (id) {
                case 1:
                    f+= m.getMensajeInt();
                    break;
                case 2:
                    f+= m.getMensajeInt();
                    break;
                case 3:
                    p+= m.getMensajeInt();
                    break;
                case 4:
                    p+= m.getMensajeInt();
                    break;    
            }
        }
        if(f>p){
            informar("gano flores " + f );
        }else{
            informar("gano papeles " + p );
        }
        
  
    }
    
}
