/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectooperativos;

import java.util.concurrent.Semaphore;
import static proyectooperativos.App.duracionDeHora;

/**
 *
 * @author Felix Castillo
 */
public class Empleado extends Thread{
    
    private int id;
    private int productoEnCaja=3;
    private int productoEnEstante;
    private int tiempo;

    public Empleado(int id) {
        this.id = id;
    }

    public void setProductoEnEstante(int productoEnEstante) {
        this.productoEnEstante = productoEnEstante;
    }
    
    
    
    @Override
    public void run() {
        while(true) {
            traerCajas();
            llenarEstante();
        }
    }
   
    
    private void traerCajas() {
        try {
            if(App.gama.getEstantes().get(id).getProductos().size() < App.maxCantidadDeProductosPorEstantes){
                System.out.println("Ire al almacen, soy el empleado #" + id);
                sleep(App.duracionDeHora/60*4); // 4 minutos
            }
        }catch (InterruptedException e){
            System.out.println("Error");
        }
    }
    
    private void llenarEstante() {
        try {
            if(App.gama.getEstantes().get(id).getProductos().size() + 3 <= App.maxCantidadDeProductosPorEstantes){
                System.out.println("Llenaré un estante, soy el empleado #" + id);
                Mercado.estantes.get(id).llenando = true;
                sleep(App.duracionDeHora/60*1); // 1 minuto
                for(int i = Mercado.estantes.get(id).getProductos().size(); i < 3; i++){
                    Mercado.estantes.get(id).addProducto(i);
                }
                Mercado.estantes.get(id).llenando = false;
            }else {
                sleep(App.duracionDeHora/60*10);
                System.out.println("Intentaré llenar mi estante otra vez, soy el empleado #" + id);
                llenarEstante();
            }
        }catch (InterruptedException e){
            System.out.println("Error");
        }
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }
    
}
