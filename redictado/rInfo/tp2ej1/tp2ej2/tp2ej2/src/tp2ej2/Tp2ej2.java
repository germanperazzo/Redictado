/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp2ej2;

import rInfo.*;
public class Tp2ej2 {

    
    public static void main(String[] args) {
        Area a1 = new AreaP(2,1,6,21);
        Area a2 = new AreaP(7,1,11,21);
        Area a3 = new AreaP(12,1,16,21);
        Area a4 = new AreaP(1,1,1,1);
        
        Robot rt1 = new Recolector(1);
        a1.agregarRobot(rt1);
        Robot rt2 = new Recolector(2);
        a2.agregarRobot(rt2);
        Robot rt3 = new Recolector(3);
        a3.agregarRobot(rt3);
        Robot jefe = new Jefe(4);
        a4.agregarRobot(jefe);
        
        
        a1.agregarFlores(700);
        a2.agregarFlores(700);
        a3.agregarFlores(700);
        
        
        a1.agregarPapeles(70);
        a2.agregarPapeles(70);
        a3.agregarPapeles(70);
        
        rt1.iniciar(2, 1);
        rt2.iniciar(7, 1);
        rt3.iniciar(12, 1);
        jefe.iniciar(1, 1);
        
    }
    
}
