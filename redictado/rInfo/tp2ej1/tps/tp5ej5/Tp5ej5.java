/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp5ej5;

import rInfo.*;


public class Tp5ej5 {

    
    public static void main(String[] args) {
        Area ac = new AreaC(100,1,100,1);
        Area a1 = new AreaP(10,1,10,1);
        Area a2 = new AreaP(11,1,11,1);
        Area a3 = new AreaP(12,1,12,1);
        Area a4 = new AreaP(13,1,13,1);
        
        Robot rt1 = new Cliente(1);
        ac.agregarRobot(rt1);
        a1.agregarRobot(rt1);
        Robot rt2 = new Cliente(2);
        ac.agregarRobot(rt2);
        a2.agregarRobot(rt2);
        Robot rt3 = new Cliente(3);
        ac.agregarRobot(rt3);
        a3.agregarRobot(rt3);
        Robot jefe = new Server(4);
        ac.agregarRobot(jefe);
        a4.agregarRobot(jefe);
        
        a4.agregarPapeles(100);
        
        rt1.iniciar(10, 1);
        rt2.iniciar(11, 1);
        rt3.iniciar(12, 1);
        jefe.iniciar(13, 1);
    }
    
}
