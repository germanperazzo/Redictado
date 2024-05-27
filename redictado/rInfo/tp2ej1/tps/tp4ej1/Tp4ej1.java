/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp4ej1;

import rInfo.*;
public class Tp4ej1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Area a1 = new AreaPC(1,1,1,100);
        Area a2 = new AreaPC(2,1,2,100);
        Area a3 = new AreaPC(3,1,3,100);
        Area j = new AreaP(100,100,100,100);
        
        
        
        Robot rt1 = new Cliente(1);
        a1.agregarRobot(rt1);
        
        Robot rt2 = new Cliente(2);
        a2.agregarRobot(rt2);
        
        Robot rt3 = new Cliente(3);
        a3.agregarRobot(rt3);
  
        Robot jefe = new Servidor(4);
        a1.agregarRobot(jefe);
        a2.agregarRobot(jefe);
        a3.agregarRobot(jefe);
        j.agregarRobot(jefe);
        
        
        j.agregarFlores(300);
        rt1.iniciar(1, 1);
        rt2.iniciar(2, 1);
        rt3.iniciar(3, 1);
        jefe.iniciar(100, 100);
    }
    
}
