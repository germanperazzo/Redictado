/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp3ej4;

import java.util.logging.Logger;
import rInfo.*;
public class Recolector extends Robot{

    public Recolector(int id) {
        super(id);
    }
    
    
    
    @Override
    public void comenzar() {
        int x = posAv();
        int y = posCa();
        boolean ok = true;
        while(ok){
            bloquearEsquina(10,10);
            pos(10,10);
            if(hayFlorEnLaEsquina()){
                tomarFlor();
            }else{
                ok= false;
            }
            if(ok){
                bloquearEsquina(11,11);
                pos(11,11);
                liberarEsquina(10,10);
                depositarFlor();
                pos(x,y);
                liberarEsquina(11,11);
            }else{
                pos(x,y);
                liberarEsquina(10,10);
            }
        }
        enviarMensaje(5,1);
    }
    
}
