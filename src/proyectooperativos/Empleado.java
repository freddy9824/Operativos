/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectooperativos;

/**
 *
 * @author Felix Castillo
 */
public class Empleado extends Thread{
    
    private int cajas=3;
    private int producto;
    
    public void run() {
        
    }
    
    private void traerCajas() {
        System.out.println("Ire al almacen");
    }
    
    private int llenarEstante(int producto) {
        return cajas+producto;
    }
    

}
