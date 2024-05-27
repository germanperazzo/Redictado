/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp4ej3;

import rInfo.*;
public class Player extends Robot {

    public Player(int id) {
        super(id);
    }
    
    private void juntar(){
        while(hayFlorEnLaEsquina()){
            tomarFlor();
        }
    }
    
    @Override
    public void comenzar() {
        int n = 0;
        int m;
        for (int i = 0; i < 20; i++) {
            m = 0;
            for (int j = 0; j < 5; j++) {
                juntar();
                m++;
                if (m<5) {
                    mover();
                }
            }
            n++;
            if(this.getId()==1){
                enviarMensaje(2,1);
                enviarMensaje(3,1);
            }else if (this.getId()==2){
                enviarMensaje(1,1);
                enviarMensaje(3,1);
            }else{
                enviarMensaje(1,1);
                enviarMensaje(2,1);
            }
            
            for (int j = 0; j < 2; j++) {
                Mensaje t = recibirMensaje();
            }
            if (n<20) {
                mover();
            }
        }
    }
    
}
