/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp4ej2;

import rInfo.*;
public class Tp4ej2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Area a1 = new AreaP(5,1,5,100);
        Area a2 = new AreaP(10,1,10,100);
        Area a3 = new AreaP(11,1,11,1);
        Area a4 = new AreaP(12,1,12,1);
        Area ac = new AreaC(50,50,50,50);
        
        Robot p1 = new Productor(1);
        a1.agregarRobot(p1);
        ac.agregarRobot(p1);
        Robot p2 = new Productor(2);
        a2.agregarRobot(p2);
        ac.agregarRobot(p2);
        Robot c1 = new Consumidor(3);
        a3.agregarRobot(c1);
        ac.agregarRobot(c1);
        Robot c2 = new Consumidor(4);
        a4.agregarRobot(c2);
        ac.agregarRobot(c2);
        
        a1.agregarFlores(70);
        a2.agregarFlores(70);
        
        p1.iniciar(5,1);
        p2.iniciar(10,1);
        c1.iniciar(11,1);
        c2.iniciar(12,1);
    }
    
}
