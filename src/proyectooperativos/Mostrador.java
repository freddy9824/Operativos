/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectooperativos;

import java.util.concurrent.Semaphore;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 *
 * @author Sagasjan
 */
public class Mostrador {
    private int id;
    public volatile boolean ocupado = false;
    public volatile int cliente = 0;
    public volatile CopyOnWriteArrayList<Producto> productos = new CopyOnWriteArrayList<Producto>();
    public volatile boolean pago = false;
    
    public Mostrador(int id) {
        this.id = id;
    }
    
    public void clear(){
        this.ocupado = false;
        this.pago = false;
        this.cliente = -1;
        this.productos.clear();
    }
   
}
