/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp5ej1;

import rInfo.*;
public class Papeles extends Robot {

    public Papeles(int id) {
        super(id);
    }
    
    private int juntar(){
        int p = 0;
        while(hayPapelEnLaEsquina()){
            tomarPapel();
            p++;
        }
        return p;
    }
    
    private int juntar96(){
        int p = 0;
        for (int i = 0; i < 96; i++) {
            while(hayPapelEnLaEsquina()){
                tomarPapel();
                p++;
            }
            mover();
        }
        return p;
    }
    
    @Override
    public void comenzar() {
        int p = 0;
        derecha();
        p += juntar();
        boolean ok = true;
         while(ok){
           bloquearEsquina(2,posCa());
           pos(2,posCa());
           if(hayPapelEnLaEsquina()){
               tomarPapel();
               p++;
               pos(1,posCa());
               liberarEsquina(2,posCa());
           }else{
               ok = false;
               pos(1,posCa());
               liberarEsquina(2,posCa());
           }
        }
        ok = true;
        while(ok){
           bloquearEsquina(3,posCa());
           pos(3,posCa());
           if(hayPapelEnLaEsquina()){
               tomarPapel();
               p++;
               pos(1,posCa());
               liberarEsquina(3,posCa());
           }else{
               ok = false;
               pos(1,posAv());
               liberarEsquina(3,posCa());
           }
        }
        pos(4,posCa());
        p += juntar96();
        p += juntar();
        enviarMensaje(5,p);
    }
    
}
