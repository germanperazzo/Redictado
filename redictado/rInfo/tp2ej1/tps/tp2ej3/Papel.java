/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp2ej3;

import rInfo.*;
public class Papel extends Robot {

    public Papel(int id) {
        super(id);
    }
    
    
    
    private int juntarP(){
        int x = 0 ;
        while(hayPapelEnLaEsquina()){
            tomarPapel();
            x++;
        }
        return x;
    }
    
    private int recorrer(){
        int x = 0;
        derecha();
        for (int i = 0; i < 9; i++) {
            x +=juntarP();
            mover();
        }
        x+=juntarP();
        return x;
    }
    
    @Override
    public void comenzar() {
        int x; 
        if(this.getId() == 1){
            x = recorrer();
            enviarMensaje(2,x);
        }else{
           int y; 
           Mensaje m = recibirMensaje(1);
           x = recorrer();
           y = m.getMensajeInt() + x;
           informar(" equopo papel " + y);
        }
    }
    
}
