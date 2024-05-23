/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp3ej5;

import rInfo.*;
public class Tp3ej5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Area a1 = new AreaP(4, 1, 4, 100);
        Area a2 = new AreaP(6, 1, 6, 100);
        Area a3 = new AreaP(8, 1, 8, 100);
        Area a4 = new AreaP(10, 1, 10, 100);
        Area ac = new AreaPC(11, 11, 11,11);
        Area j = new AreaP(1, 1, 1, 1);
        
        Robot rt1 = new Recolector(1);
        a1.agregarRobot(rt1);
        ac.agregarRobot(rt1);
        Robot rt2 = new Recolector(2);
        a2.agregarRobot(rt2);
        ac.agregarRobot(rt2);
        Robot rt3 = new Recolector(3);
        a3.agregarRobot(rt3);
        ac.agregarRobot(rt3);
        Robot rt4 = new Recolector(4);
        a4.agregarRobot(rt4);
        ac.agregarRobot(rt4);
        Robot jefe = new Jefe(5);
        j.agregarRobot(jefe);
        
        ac.agregarFlores(11,11,76);
        
        rt1.iniciar(4, 1);
        rt2.iniciar(6, 1);
        rt3.iniciar(8, 1);
        rt4.iniciar(10, 1);
        jefe.iniciar(1,1);
    
    }}