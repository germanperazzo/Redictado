/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp5ej1;

import rInfo.*;
public class Tp5ej1 {

    
    public static void main(String[] args) {
        Area f1a = new AreaP (2,1,2,97);
        Area f1b = new AreaP (2,100,2,100);
        Area f2a = new AreaP (3,1,3,97);
        Area f2b = new AreaP (3,100,3,100);
        Area j = new AreaP(1,1,1,1);
        
        Area p1a = new AreaP (4,98,100,98);
        Area p1b = new AreaP(1,98,1,98);
        Area p2a = new AreaP (4,99,100,99);
        Area p2b = new AreaP(1,99,1,99);
        
        Area c1 = new AreaPC (2,98,2,98);
        Area c2 = new AreaPC (2,99,2,99);
        Area c3 = new AreaPC (3,98,3,98);
        Area c4 = new AreaPC (3,99,3,99);
        
        
        Robot rt1 = new Flores(1);
        f1a.agregarRobot(rt1);
        f1b.agregarRobot(rt1);
        c1.agregarRobot(rt1);
        c2.agregarRobot(rt1);
        Robot rt2 = new Flores(2);
        f2a.agregarRobot(rt2);
        f2b.agregarRobot(rt2);
        c3.agregarRobot(rt2);
        c4.agregarRobot(rt2);
        Robot rt3 = new Papeles(3);
        p1a.agregarRobot(rt3);
        p1b.agregarRobot(rt3);
        c1.agregarRobot(rt3);
        c3.agregarRobot(rt3);
        Robot rt4 = new Papeles(4);
        p2a.agregarRobot(rt4);
        p2b.agregarRobot(rt4);
        c2.agregarRobot(rt4);
        c4.agregarRobot(rt4);
        Robot jefe = new Jefe(5);
        j.agregarRobot(jefe);
        
        jefe.iniciar(1, 1);
        rt1.iniciar(2, 1);
        rt2.iniciar(3, 1);
        rt3.iniciar(1, 98);
        rt4.iniciar(1, 99);
    }
    
}
