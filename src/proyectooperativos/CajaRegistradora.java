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
public class CajaRegistradora extends Thread{
    int producto;
    int varGlobal;

    public void setProducto(int producto) {
        this.producto = producto;
    }

    public void setVarGlobal(int varGlobal) {
        this.varGlobal = varGlobal;
    }

    public int getVarGlobal() {
        return varGlobal;
    }
    
    
    @Override
    public void run() {
        leerProducto(producto);
        varGlobal++;
    }
    
    private void leerProducto(int producto) {
        for (int i = 0; i < producto; i++) {
            try {
                sleep(1000); // 1 minuto
            } catch(InterruptedException e) {
                System.out.println("Error");
            }
        }
    }
}
