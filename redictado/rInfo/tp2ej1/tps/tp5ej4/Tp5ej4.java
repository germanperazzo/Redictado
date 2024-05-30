/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp5ej4;

import rInfo.*;
public class Tp5ej4 {
    
    public static void main(String[] args) {
        Area ac = new AreaPC(40,40,60,60);
        Area ac2 = new AreaPC(10,10,10,10);
        Area a1 = new AreaP(1,1,1,1);
        Area a2 = new AreaP(2,1,2,1);
        Area a3 = new AreaP(3,1,3,1);
        Area a4 = new AreaPC(4,1,4,1);
        
        Robot rt1 = new Recolector(1);
        ac.agregarRobot(rt1);
        ac2.agregarRobot(rt1);
        a1.agregarRobot(rt1);
        Robot rt2 = new Recolector(2);
        ac.agregarRobot(rt2);
        ac2.agregarRobot(rt2);
        a2.agregarRobot(rt2);
        Robot rt3 = new Recolector(3);
        ac.agregarRobot(rt3);
        ac2.agregarRobot(rt3);
        a3.agregarRobot(rt3);
        Robot jefe = new Jefe(4);
        a4.agregarRobot(jefe);
        
        rt1.iniciar(1, 1);
        rt2.iniciar(2, 1);
        rt3.iniciar(3, 1);
        jefe.iniciar(4, 1);
        
    }
    
}
