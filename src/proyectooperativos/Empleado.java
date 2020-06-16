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
    private boolean esperando = false;

    public Empleado(int id) {
        this.id = id;
    }

    public void setProductoEnEstante(int productoEnEstante) {
        this.productoEnEstante = productoEnEstante;
    }
    
    
    
    @Override
    public void run() {
        while(true) {
            /*
                El empleado espera a que puede ponerse a llenar un estante en caso tener la caja en esus manos
           */
            if(!esperando){
                traerCajas();
            };
            llenarEstante();
        }
    }
   
    
    private void traerCajas() {
        try {
            if(App.gama.getEstantes().get(id).getProductos().size() < App.maxCantidadDeProductosPorEstantes){
                /*
                    Un empleado tarda 4 min en traer una caja de productos
               */
                Thread.sleep( (long) ( ( (4f/60f) *App.duracionDeHora) * 1000 ) ); // 4 minutos
            }
        }catch (InterruptedException e){
            System.out.println("Error");
        }
    }
    
    private void llenarEstante() {
        try {
            if(App.gama.getEstantes().get(id).getProductos().size() + 3 <= App.maxCantidadDeProductosPorEstantes){
                System.out.println("Llenaré un estante, soy el empleado #" + id);
                App.gama.estantes.get(id).llenando = true;
                /*
                    Un empleado tarda 1 min en llenar un estante que le falte producto
               */
                Thread.sleep( (long) ( ( (1f/60f) *App.duracionDeHora) * 1000) ); // 1 minuto
                for(int i = App.gama.estantes.get(id).getProductos().size(); i < 3; i++){
                    App.gama.estantes.get(id).addProducto(i);
                }
                App.gama.estantes.get(id).llenando = false;
                this.esperando = false;
            } 
        }catch (InterruptedException e){
            System.out.println("Error");
        }
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }
    
}
