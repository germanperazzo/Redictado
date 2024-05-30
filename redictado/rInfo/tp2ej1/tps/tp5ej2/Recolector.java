/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp5ej2;

import rInfo.*;
public class Recolector extends Robot {

    public Recolector(int id) {
        super(id);
    }
    
    
    
    @Override
    public void comenzar() {
        int n = 0;
        int f = 0;
        int m;
        derecha();
        for (int i = 0; i < 10; i++) {
            m = 0;
            
            //empieza las etapas
            for (int j = 0; j < 10; j++) {
                while(hayFlorEnLaEsquina()){
                    tomarFlor();
                    f++;
                }
                while(hayPapelEnLaEsquina()){
                    tomarPapel();  
                }
                m++;
                if(m<10){
                    mover();
                }
            }
            
            // enviar mensajes a los otros 2 robots
            switch (this.getId()) {
                case 1 -> {
                    enviarMensaje(2,0);
                    enviarMensaje(3,0);
                }
                case 2 -> {
                    enviarMensaje(1,0);
                    enviarMensaje(3,0);
                }
                case 3 -> {
                    enviarMensaje(2,0);
                    enviarMensaje(1,0);
                }
            }
            
            //recibir los mensajes de los otroos 2
            for (int j = 0; j < 2; j++) {
                Mensaje t = recibirMensaje();
            }
            n++;
            if(n<10){
                mover();
            }
        }
        
        //depositar todas las flores juntadas de a 1
        int x = posAv();
        int y = posCa();
        for (int i = 0; i < f; i++) {
            bloquearEsquina(50,50);
            pos(50,50);
            depositarFlor();
            pos(x,y);
            liberarEsquina(50,50);
        }
        //informar al robot jefe
        enviarMensaje(4,f);    
    }
    
}
