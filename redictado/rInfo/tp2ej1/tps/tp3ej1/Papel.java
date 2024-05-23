/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp3ej1;

import rInfo.*;
import PaqueteLectura.GeneradorAleatorio;
public class Papel extends Robot {

    public Papel(int id) {
        super(id);
    }
    
     private void juntar(){
        while(hayPapelEnLaEsquina()){
            tomarPapel();
        }
    }
    
    private void depositar(){
        while(hayPapelEnLaBolsa()){
            depositarPapel();
        }
    }
    
    private void tpJuntar(int x,int y,int xa,int ya){
        bloquearEsquina(xa,ya);
        pos(xa,ya);
        juntar();
        pos(x,y);
        liberarEsquina(xa,ya);
    }
    
    private void tpDepositar(int x,int y,int xa,int ya){
        bloquearEsquina(xa,ya);
        pos(xa,ya);
        depositar();
        pos(x,y);
        liberarEsquina(xa,ya);
    }
    
    @Override
    public void comenzar() {
        int x = posAv();
        int y = posCa();
        for (int i = 0; i < 3; i++) {
            int xa = GeneradorAleatorio.generarInt(5)+5;
            int ya = GeneradorAleatorio.generarInt(9)+1;
            tpJuntar(x,y,xa,ya);
        }
        tpDepositar(x,y,10,10);
    }
    
}
