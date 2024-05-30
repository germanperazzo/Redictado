/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp5ej2;

import rInfo.*;

public class Tp5ej2 {

    
    public static void main(String[] args) {
        Area a1 = new AreaP(1,1,100,1);
        Area a2 = new AreaP(1,2,100,2);
        Area a3 = new AreaP(1,3,100,3);
        Area c = new AreaC(50,50,50,50);
        Area j = new AreaP(1,4,1,4);
        
        Robot rt1 = new Recolector(1);
        a1.agregarRobot(rt1);
        c.agregarRobot(rt1);
        Robot rt2 = new Recolector(2);
        a2.agregarRobot(rt2);
        c.agregarRobot(rt2);
        Robot rt3 = new Recolector(3);
        a3.agregarRobot(rt3);
        c.agregarRobot(rt3);
        Robot jefe = new Jefe(4);
        j.agregarRobot(jefe);
        c.agregarRobot(jefe);
        
        rt1.iniciar(1, 1);
        rt2.iniciar(1, 2);
        rt3.iniciar(1, 3);
        jefe.iniciar(1, 4);
    }
    
}
