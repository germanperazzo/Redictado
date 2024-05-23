/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp2ej1;

import rInfo.*;
public class Robot1 extends Robot {

    public Robot1(int id) {
        super(id);
    }
    
    private int juntarF(){
        int f = 0;
        while(hayFlorEnLaEsquina()){
            tomarFlor();
            f++;
        }
        return f;
    }
    private int caminar(){
        int f = 0;
        for (int i = 0; i < 9; i++) {
            f += juntarF();
            mover();
        }
        f += juntarF();
        return f;
    }
    
    @Override
    public void comenzar() {
        int flores = caminar();
        enviarMensaje(2,flores);
        Mensaje m = recibirMensaje();
        int floresRecibidas = m.getMensajeInt();
        if (flores>floresRecibidas) {
            informar(this.getId() + " gane por tanto " + (flores-floresRecibidas));
            
        }else if(flores == floresRecibidas){
            informar("empatamos");
        }else{
            informar(this.getId()+" perdi");
        }
    }
    
}
