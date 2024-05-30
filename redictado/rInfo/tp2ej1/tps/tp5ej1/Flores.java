/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp5ej1;

import rInfo.*;
public class Flores extends Robot {

    public Flores(int id) {
        super(id);
    }
    
    private int juntar(){
        int f = 0;
        while(hayFlorEnLaEsquina()){
            tomarFlor();
            f++;
        }
        return f;
    }
    
    private int juntar96(){
        int f = 0;
        for (int i = 0; i < 96; i++) {
            while(hayFlorEnLaEsquina()){
                tomarFlor();
                f++;
            }
            mover();
        }
        return f;
    }
    
    @Override
    public void comenzar() {
        int f = 0;
        f = juntar96();
        f += juntar();
        boolean ok = true; 
        while(ok){
           bloquearEsquina(posAv(),98);
           pos(posAv(),98);
           if(hayFlorEnLaEsquina()){
               tomarFlor();
               f++;
               pos(posAv(),97);
               liberarEsquina(posAv(),98);
           }else{
               ok = false;
               pos(posAv(),97);
               liberarEsquina(posAv(),98);
           }
        }
        ok = true;
        while(ok){
           bloquearEsquina(posAv(),99);
           pos(posAv(),99);
           if(hayFlorEnLaEsquina()){
               tomarFlor();
               f++;
               pos(posAv(),97);
               liberarEsquina(posAv(),99);
           }else{
               ok = false;
               pos(posAv(),97);
               liberarEsquina(posAv(),99);
           }
        }
        
        pos(posAv(),100);
        f += juntar();
        enviarMensaje(5,f);
    }
    
}
