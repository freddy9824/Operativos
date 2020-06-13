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
    
    private int id;
    private int productoEnCaja=3;
    private int productoEnEstante;

    public Empleado(int id) {
        this.id = id;
    }

    public void setProductoEnEstante(int productoEnEstante) {
        this.productoEnEstante = productoEnEstante;
    }
    
    
    
    @Override
    public void run() {
        traerCajas();
        try {
            sleep(5000); // 5minutos
        }catch (InterruptedException e){
            System.out.println("Error");
        }
        llenarEstante(productoEnEstante);
        try {
            sleep(1000); // 1 minuto
        }catch (InterruptedException e){
            System.out.println("Error");
        }
    }
    
    private void traerCajas() {
        System.out.println("Ire al almacen");
    }
    
    private int llenarEstante(int productoEnEstante) {
        return productoEnCaja+productoEnEstante;
    }
    
}
