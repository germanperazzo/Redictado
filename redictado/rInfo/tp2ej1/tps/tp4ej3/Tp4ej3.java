/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp4ej3;

import rInfo.*;
public class Tp4ej3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Area a1 = new AreaP(1,1,1,100);
        Area a2 = new AreaP(2,1,2,100);
        Area a3 = new AreaP(3,1,3,100);
        
        Robot rt1 = new Player(1);
        a1.agregarRobot(rt1);
        Robot rt2 = new Player(2);
        a2.agregarRobot(rt2);
        Robot rt3 = new Player(3);
        a3.agregarRobot(rt3);
        
        a1.agregarFlores(70);
        a2.agregarFlores(70);
        a3.agregarFlores(70);
        
        rt1.iniciar(1, 1);
        rt2.iniciar(2, 1);
        rt3.iniciar(3, 1);
    }
    
}
