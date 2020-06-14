/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectooperativos;

import java.util.ArrayList;

/**
 *
 * @author Sagasjan
 */
public class Estante {
    private int id;
    private volatile ArrayList<Producto> productos = new ArrayList<Producto>();
    
    public Estante(int id) {
        this.id = id;
        /*
            Los productos tienen un precio random entre 1 y 10 $
        */
        for(int i = 0; i < App.maxCantidadDeProductosPorEstantes; i++){
            productos.add(new Producto(i));
        }
        System.out.println("El estante " + this.id  + " ha sido creado" );
    }
    
    public ArrayList<Producto> getProductos() {
        return productos;
    }
    
    public void addProducto(int id) {
        productos.add(new Producto(id));
    }
    
     public Producto deleteProducto(int id) {
        return productos.remove(id);
    }
    
}
