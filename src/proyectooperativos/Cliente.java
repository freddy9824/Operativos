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
public class Cliente extends Thread {
    private int id;
    
    public void run() {
        try {
            while(true) {

                
                
                /*
                    El cliente llega y toma inmediatamente un carrito disponible
                */
                Thread.sleep(1000);

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
                5 min para recorrer un estante
            */
            Thread.sleep(300000); // Multiplicamos por 1000 por son milisegundos

            /*
                Como es un while infinito, este código se repetirá una 
                y otra vez.
            */
        } catch (InterruptedException e) {
            System.out.println("El cliente no pudo recorrer estante.");
        }
    }
    
    private void agarrarAlgo(int estante) {
        try {

            /*
                1 min para agarrar algo del estante
            */
            Thread.sleep(100000); // Multiplicamos por 1000 por son milisegundos

            /*
                Como es un while infinito, este código se repetirá una 
                y otra vez.
            */
        } catch (InterruptedException e) {
            System.out.println("El cliente no pudo recorrer estante.");
        }
    }
    
    private void pagar() {
        try {

            /*
                0.5 segundos para agarrar algo del carrito y ponerlo en el mostrador para pagarlo
            */
            Thread.sleep(500); // Multiplicamos por 1000 por son milisegundos

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
            Thread.sleep(120000); // Multiplicamos por 1000 por son milisegundos

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
            Thread.sleep(1); // Multiplicamos por 1000 por son milisegundos

            /*
                Como es un while infinito, este código se repetirá una 
                y otra vez.
            */
        } catch (InterruptedException e) {
            System.out.println("El cliente no pudo recorrer estante.");
        }
    }
}
