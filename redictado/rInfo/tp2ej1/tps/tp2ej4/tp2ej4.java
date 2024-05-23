/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp2ej4;

import rInfo.*;
public class tp2ej4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Area a1 =  new AreaP(25,1,25,1);
        Area a2 =  new AreaP(30,1,30,1);
        Area a3 =  new AreaP(35,1,35,1);
        Area a4 =  new AreaP(40,1,40,1);
        Area a = new AreaPC(25,25,75,75);
        Area j = new AreaP(1,1,1,1);
        
        Robot rt1 = new Recolector(1);
        a1.agregarRobot(rt1);
        a.agregarRobot(rt1);
        Robot rt2 = new Recolector(2);
        a2.agregarRobot(rt2);
        a.agregarRobot(rt2);
        Robot rt3 = new Recolector(3);
        a3.agregarRobot(rt3);
        a.agregarRobot(rt3);
        Robot rt4 = new Recolector(4);
        a4.agregarRobot(rt4);
        a.agregarRobot(rt4);
        Robot jefe = new Jefe(5);
        j.agregarRobot(jefe);
        
        a.agregarFlores(500);
        a.agregarPapeles(500);
        
        rt1.iniciar(25, 1);
        rt2.iniciar(30, 1);
        rt3.iniciar(35, 1);
        rt4.iniciar(40, 1);
        jefe.iniciar(1,1);
    }
    
}
