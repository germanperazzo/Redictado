/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp4ej2;

import rInfo.*;

public class Productor extends Robot{

    public Productor(int id) {
        super(id);
    }
    
    
    
    @Override
    public void comenzar() {
        int f = 0;
        int x = posAv();
        int y= posCa();
        while(y != 100){
            while(hayFlorEnLaEsquina()){
               tomarFlor();
               f++;
               if(f==5){
                   bloquearEsquina(50,50);
                   pos(50,50);
                   for (int i = 0; i < 5; i++) {
                       depositarFlor();
                   }
                   pos(x,y);
                   liberarEsquina(50,50);
                   
                   f = 0;
               }
            }
            mover();
            y++;
        }
        bloquearEsquina(50,50);
        pos(50,50);
        for (int i = 0; i < 5; i++) {
            depositarFlor();
        }
        pos(x,y);
        liberarEsquina(50,50);
        f = 0;
    }
    
}
