/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp2ej3;

import rInfo.*;
public class Flor extends Robot {
    
    public Flor(int id) {
        super(id);
    }
    
    private int juntarF(){
        int x = 0 ;
        while(hayFlorEnLaEsquina()){
            tomarFlor();
            x++;
        }
        return x;
    }
    
    private int recorrer(){
        int x = 0;
        derecha();
        for (int i = 0; i < 9; i++) {
            x +=juntarF();
            mover();
        }
        x+=juntarF();
        return x;
    }
    
    @Override
    public void comenzar() {
        int x; 
        if(this.getId() == 3){
            x = recorrer();
            enviarMensaje(4,x);
        }else{
           int y; 
           Mensaje m = recibirMensaje(3);
           x = recorrer();
           y = m.getMensajeInt() + x;
           informar(" equopo flor " + y);
        }
    }
    
}
