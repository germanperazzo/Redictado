/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp5ej3;

import rInfo.*;
public class Recolector extends Robot{

    public Recolector(int id) {
        super(id);
    }
    
    
    
    @Override
    public void comenzar() {
        derecha();
        int f = 0;
        int a = 0;
        int cant = 1;
        int x;
        int y = posCa();
        boolean ok = true;
        while(ok){
            x = posAv();
            while(hayFlorEnLaEsquina()){
                tomarFlor();
                f++;
                if(f==5){
                    for (int i = 0; i < 5; i++) {
                        bloquearEsquina(10,10);
                        pos(10,10);
                        depositarFlor();
                        pos(x,y);
                        liberarEsquina(10,10);
                    }
                    enviarMensaje(3,5);
                    f = 0;
                }
            }
            if(posAv() != 100){
                mover();
            }
            a++;
            
            if(a ==10){
                if(f != 0){
                    for (int i = 0; i < f; i++) {
                        bloquearEsquina(10,10);
                        pos(10,10);
                        depositarFlor();
                        pos(x,y);
                        liberarEsquina(10,10);
                    }
                    enviarMensaje(3,f);
                }
                a = 0;
            }
            cant++;
            if((cant==100)&& !hayFlorEnLaBolsa()){
                ok= false;
            }
        }
        // nunca supero el 6 en el jefe tengo q preguntar si es un 6 si lo es pirdo una vida , sino busco flores en la esquina por el valor q me pasan.
        enviarMensaje(3,6);
    }
}
