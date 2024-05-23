/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp3ej1;

import rInfo.*;
public class Tp3ej1 {

    
    public static void main(String[] args) {
        
        Area aC = new AreaC(10,10,10,10);
        Area aF = new AreaPC(1,1,5,10);
        Area aP = new AreaPC(6,1,10,9);
        Area a1 = new AreaP(6,10,6,10);
        Area a2 = new AreaP(7,10,7,10);
        Area a3 = new AreaP(8,10,8,10);
        Area a4 = new AreaP(9,10,9,10);
        
        Robot f1 = new Flor(1);
        aC.agregarRobot(f1);
        aF.agregarRobot(f1);
        a1.agregarRobot(f1);
        Robot f2 = new Flor(2);
        aC.agregarRobot(f2);
        aF.agregarRobot(f2);
        a2.agregarRobot(f2);
        Robot p1 = new Papel(3);
        aC.agregarRobot(p1);
        aP.agregarRobot(p1);
        a3.agregarRobot(p1);
        Robot p2 = new Papel(4);
        aC.agregarRobot(p2);
        aP.agregarRobot(p2);
        a4.agregarRobot(p2);
        
        aF.agregarFlores(500);
        aP.agregarPapeles(500);
        
        f1.iniciar(6, 10);
        f2.iniciar(7, 10);
        p1.iniciar(8, 10);
        p2.iniciar(9, 10);
    }
    
}
