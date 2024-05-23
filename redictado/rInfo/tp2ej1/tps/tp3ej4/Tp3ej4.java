/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp3ej4;

import rInfo.*;
public class Tp3ej4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Area a10 = new AreaPC(10,10,10,10);
        Area a11 = new AreaPC(11,11,11,11);
        Area a1 = new AreaP(9,1,9,1);
        Area a2 = new AreaP(10,1,10,1);
        Area a3 = new AreaP(11,1,11,1);
        Area a4 = new AreaP(12,1,12,1);
        Area a5 = new AreaP(1,1,1,1);
        
        Robot rt1 = new Recolector(1);
        a1.agregarRobot(rt1);
        a10.agregarRobot(rt1);
        a11.agregarRobot(rt1);
        Robot rt2 = new Recolector(2);
        a2.agregarRobot(rt2);
        a10.agregarRobot(rt2);
        a11.agregarRobot(rt2);
        Robot rt3 = new Recolector(3);
        a3.agregarRobot(rt3);
        a10.agregarRobot(rt3);
        a11.agregarRobot(rt3);
        Robot rt4 = new Recolector(4);
        a4.agregarRobot(rt4);
        a10.agregarRobot(rt4);
        a11.agregarRobot(rt4);
        Robot jefe = new Jefe(5);
        a5.agregarRobot(jefe);
        
        
        a10.agregarFlores(23);
        
        
        rt1.iniciar(9, 1);
        rt2.iniciar(10, 1);
        rt3.iniciar(11, 1);
        rt4.iniciar(12, 1);
        jefe.iniciar(1, 1);
    }
    
}
