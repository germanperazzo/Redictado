/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp4ej2;

import rInfo.*;
import PaqueteLectura.GeneradorAleatorio;
public class Consumidor extends Robot{

    public Consumidor(int id) {
        super(id);
    }

    @Override
    public void comenzar() {
        boolean ok = true;
        int c = 8;
        int x = posAv();
        int y = posCa();
        int n;
        int f;
        while(c != 0){
            n = GeneradorAleatorio.generarInt(3)+2;
            bloquearEsquina(50,50);
            pos(50,50);
            f =0;
            while((hayFlorEnLaEsquina())&&(n>f)){
                tomarFlor();
                f++;
            }
            if(f != n){
                for (int i = 0; i < f; i++) {
                    depositarFlor();
                }
                ok= false;
            }
            else{
                ok = true;
            }
            pos(x,y);
            liberarEsquina(50,50);
            if(ok){
                c = 8;
                for (int i = 0; i < n; i++) {
                    depositarFlor();
                }
            }
            else{
                c--;
            }
        }
    }
    
}
