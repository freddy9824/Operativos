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
    private volatile boolean termino = false;
    private int id;
    private int productos;
    private int cantidadDeProductos;
    private int tiempo;
    Random random = new Random();
    
    Semaphore sCarrito;
    Semaphore sEstante;
    Semaphore sCajaRegistradora;
    
    public Cliente(int id, Semaphore sCarrito, Semaphore sEstante, Semaphore sCajaRegistradora) {
        this.id = id;
        
        /*
            ¡¡Importantísimo!! Debemos pasarle al cliente el semáforo de alguna
            manera para que pueda llamarlo. Si creamos un nuevo semáforo aquí
            adentro, ese semáforo será otro diferente del que creamos en App.
        */
        this.sCarrito = sCarrito;
        this.sEstante = sEstante;
        this.sCajaRegistradora = sCajaRegistradora;
    }
    
    @Override
    public void run() {
        try {
            while(!termino) {

                
                
                /*
                    El cliente llega y toma inmediatamente un carrito disponible
                */
                    tomarCarrito();
                    Thread.sleep(1000);
                    
                    for(int i = 0; i < App.estantesIniciales; i++){
                        recorrerEstante();
                        agarrarProducto(0);
                    }
                    
                    pagar();
                    regresarCarrito();

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
            System.out.println("El cliente #" + this.id + " está recorriendo un estante");
            /*
                5 min para recorrer un estante
            */
            Thread.sleep(300);

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

            System.out.println("El cliente #" + this.id + " está agarrando productos");   
            /*
                1 min para agarrar algo del estante
            */
            Thread.sleep(1000);
            
            /*
                Un cliente solo agarra entre 0 a 2 productos
            */   
            this.cantidadDeProductos = random.nextInt(2 - 0 + 1) + 0;
            
            if(cantidadDeProductos > 0 && App.gama.getEstantes().get(estante).getProductos().size() - cantidadDeProductos >= 0){
                for(int i = 0; i < cantidadDeProductos; i++){
                    App.gama.getEstantes().get(estante).deleteProducto(i);
                }
                System.out.println("Se han eliminado " + cantidadDeProductos + " productos de manera exitosa");
            }
            
            /*
                El valor de cantidad de producto debe ser recorrido en el array de productos y además
                debería ser restado de la cantidad de productos en dicho estante
            */
            System.out.println("El cliente #" + this.id + " agarró " + cantidadDeProductos + " productos");
            
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
            sCajaRegistradora.acquire();
            System.out.println("El cliente #" + this.id + " está pagando sus productos");
            /*
                0.5 segundos para agarrar algo del carrito y ponerlo en el mostrador para pagarlo
            */
            for(int i = 0; i < this.cantidadDeProductos; i++){
                Thread.sleep(500);
                System.out.println("El cliente #" + this.id + " colocó en el mostrador su producto #" + (i + 1) );
            }
            
            sCajaRegistradora.release();

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
            Thread.sleep(1200);
            this.sCarrito.release();
            System.out.println("El cliente #" + this.id + " ha regresado su carrito");
            /*
                Termino ejecución, este cliente no volverá
            */
            this.termino = true;
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
            System.out.println("El cliente #" + this.id + " ha tomando un carrito");

            /*
                Como es un while infinito, este código se repetirá una 
                y otra vez.
            */
        } catch (InterruptedException e) {
            System.out.println("El cliente no pudo tomar carrito.");
        }
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }
    
    
}
