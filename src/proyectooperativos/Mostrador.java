/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectooperativos;

import java.util.concurrent.Semaphore;
import java.util.ArrayList;

/**
 *
 * @author Sagasjan
 */
public class Mostrador {
    private int id;
    public volatile int cantidadDeProductos = 0;
    public volatile int precioTotalDeProductos = 0;
    public volatile ArrayList<Producto> productos = new ArrayList<Producto>();
    public volatile boolean ocupado = false;
    public volatile Cliente cliente = null;
    
    public Mostrador(int id) {
        this.id = id;
    }
    
    public void clear(){
        this.cantidadDeProductos = 0;
        this.precioTotalDeProductos = 0;
        this.ocupado = false;
    }
   
}
