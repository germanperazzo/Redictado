/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp2ej3;

import rInfo.*;
public class Tp2ej3 {

    
    public static void main(String[] args) {
        Area a1 = new AreaP(1,1,10,1);
        Area a2 = new AreaP(11,1,20,1);
        Area a3 = new AreaP(1,5,10,5);
        Area a4 = new AreaP(11,5,20,5);
        
        Robot rt1 = new Papel(1);
        a1.agregarRobot(rt1);
        Robot rt2 = new Papel(2);
        a2.agregarRobot(rt2);
        Robot rt3 = new Flor(3);
        a3.agregarRobot(rt3);
        Robot rt4 = new Flor(4);
        a4.agregarRobot(rt4);
        
        a1.agregarPapeles(100);
        a2.agregarPapeles(100);
        a3.agregarFlores(100);
        a4.agregarFlores(100);
        
        rt1.iniciar(1, 1);
        rt2.iniciar(11, 1);
        rt3.iniciar(1, 5);
        rt4.iniciar(11, 5);
    }
    
}
