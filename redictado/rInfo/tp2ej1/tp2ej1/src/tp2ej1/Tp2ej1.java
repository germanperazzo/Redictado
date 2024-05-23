/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp2ej1;

import rInfo.*;
public class Tp2ej1 {

    
    public static void main(String[] args) {
        Area a1 = new AreaP(1,1,1,10);
        Area a2 = new AreaP(2,11,2,20);
        
        Robot rt1 = new Robot1(1);
        a1.agregarRobot(rt1);
        Robot rt2 = new Robot2(2);
        a2.agregarRobot(rt2);
        
        a1.agregarFlores(7);
        a2.agregarFlores(8);
        
        rt1.iniciar(1, 1);
        rt2.iniciar(2, 11);
    }
    
}
