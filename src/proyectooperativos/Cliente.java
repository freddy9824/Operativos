/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectooperativos;

import java.util.Random;
import java.util.concurrent.Semaphore;

/**
 *
 * @author Felix Castillo
 */
public class Cliente extends Thread {
    private int id;
    private int productos;
    private int cantidadDeProductos;
    Random random = new Random();
    
    Semaphore sCarrito;
    Semaphore sEstante;
    Semaphore sCajaRegistradora;
    
    public Cliente(int id, Semaphore sCarrito) {
        this.id = id;
        
        /*
            ¡¡Importantísimo!! Debemos pasarle al cliente el semáforo de alguna
            manera para que pueda llamarlo. Si creamos un nuevo semáforo aquí
            adentro, ese semáforo será otro diferente del que creamos en App.
        */
        this.sCarrito = sCarrito;
    }
    
    public void run() {
        try {
            while(true) {

                
                
                /*
                    El cliente llega y toma inmediatamente un carrito disponible
                */
                    tomarCarrito();
                    Thread.sleep(1000);

                    recorrerEstante();
                    pagar();

                /*
                    Como es un while infinito, este código se repetirá una 
                    y otra vez.
                */
            }
        } catch (InterruptedException e) {
            System.out.println("El cliente se volvió loco.");
        }
    }
    
    
    private void recorrerEstante() {
        try {
            /*
                Ocupamos estante
            */
            sEstante.acquire();
            
            /*
                5 min para recorrer un estante
            */
            Thread.sleep(300000);

            /*
                Como es un while infinito, este código se repetirá una 
                y otra vez.
            */
        } catch (InterruptedException e) {
            System.out.println("El cliente no pudo recorrer estante.");
        }
    }
    
    private void agarrarProducto(int estante) {
        try {

            /*
                1 min para agarrar algo del estante
            */
            Thread.sleep(100000);
            
            this.cantidadDeProductos = random.nextInt(2 - 0 + 1) + 0;
            
            /*
                El valor de cantidad de producto debe ser recorrido en el array de productos y además
                debería ser restado de la cantidad de productos en dicho estante
            */
            System.out.println("El cliente agarró " + cantidadDeProductos + " productos");
            
            /*
                Soltamos estante
            */
            sEstante.release();

            /*
                Como es un while infinito, este código se repetirá una 
                y otra vez.
            */
        } catch (InterruptedException e) {
            System.out.println("El cliente no pudo recorrer estante #" + estante);
        }
    }
    
    private void pagar() {
        try {

            /*
                0.5 segundos para agarrar algo del carrito y ponerlo en el mostrador para pagarlo
            */
            for(int i = 0; i < this.cantidadDeProductos; i++){
                Thread.sleep(500);
                System.out.println("El cliente #" + this.id + " está colocó en el mostrador su producto #" + i);
            }

            /*
                Como es un while infinito, este código se repetirá una 
                y otra vez.
            */
        } catch (InterruptedException e) {
            System.out.println("El cliente no pudo recorrer estante.");
        }
    }
    
    private void regresarCarrito() {
        try {

            /*
                2 min para regresar carrito a su lugar
            */
            Thread.sleep(120000);

            /*
                Como es un while infinito, este código se repetirá una 
                y otra vez.
            */
        } catch (InterruptedException e) {
            System.out.println("El cliente no pudo recorrer estante.");
        }
    }
    
    private void tomarCarrito() {
        try {

            /*
                Se toma carrito de manera inmediata IGNORAR EL TIEMPO DE ABAJO
            */
            this.sCarrito.acquire();

            /*
                Como es un while infinito, este código se repetirá una 
                y otra vez.
            */
        } catch (InterruptedException e) {
            System.out.println("El cliente no pudo tomar carrito.");
        }
    }
}
