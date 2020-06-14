/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectooperativos;

import java.util.Random;

/**
 *
 * @author Felix Castillo
 */
class Producto {
    Random random = new Random();
    private int id;
    public int precio;

    public Producto(int id) {
        this.id = id;
        /*
            Los productos tienen un precio random entre 1 y 10 $
        */   
        this.precio = random.nextInt(10 - 1 + 1) + 1;
        System.out.println("El precio del producto " + this.id  + " creado es " + this.precio);
    }

    public int getId() {
        return id;
    }


    public int getPrecio() {
        return precio;
    }

    
    
}
