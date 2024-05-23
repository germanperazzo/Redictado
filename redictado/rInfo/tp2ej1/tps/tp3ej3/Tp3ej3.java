/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp3ej3;

import rInfo.*;
public class Tp3ej3 {

    
    public static void main(String[] args) {
        Area ac = new AreaPC(2,2,10,10);
        Area a1 = new AreaP(2,1,2,1);
        Area a2 = new AreaP(3,1,3,1);
        Area a3 = new AreaP(4,1,4,1);
        Area a4 = new AreaP(5,1,5,1);
        Area j = new AreaP(1,1,1,1);
        
        Robot rt1 = new Recolector(1);
        ac.agregarRobot(rt1);
        a1.agregarRobot(rt1);
        Robot rt2 = new Recolector(2);
        ac.agregarRobot(rt2);
        a2.agregarRobot(rt2);
        Robot rt3 = new Recolector(3);
        ac.agregarRobot(rt3);
        a3.agregarRobot(rt3);
        Robot rt4 = new Recolector(4);
        ac.agregarRobot(rt4);
        a4.agregarRobot(rt4);
        Robot jefe = new Jefe(5);
        j.agregarRobot(jefe);
        
        ac.agregarFlores(500);
        
        rt1.iniciar(2, 1);
        rt2.iniciar(3, 1);
        rt3.iniciar(4, 1);
        rt4.iniciar(5, 1);
        jefe.iniciar(1, 1);
        
    }
    
}
