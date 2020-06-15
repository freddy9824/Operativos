/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectooperativos;

import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.Random;
import java.util.concurrent.Semaphore;
import static proyectooperativos.App.duracionDeHora;
import java.util.Iterator;

/**
 *
 * @author Felix Castillo
 */
public class Cliente extends Thread {
    private volatile boolean termino = false;
    public volatile boolean atendido = false;
    public volatile boolean pago = false;
    public int id;
    public CopyOnWriteArrayList<Producto> productos = new CopyOnWriteArrayList<Producto>();
    private int cantidadDeProductos;
    private int tiempo;
    private CopyOnWriteArrayList<Number> recorridos = new CopyOnWriteArrayList<Number>();;
    Random random = new Random();
    
    Semaphore sCarrito;
    Semaphore sEstante;
    Semaphore sCajero;
    
    public Cliente(int id, Semaphore sCarrito, Semaphore sEstante, Semaphore sCajero) {
        this.id = id;
        
        /*
            ¡¡Importantísimo!! Debemos pasarle al cliente el semáforo de alguna
            manera para que pueda llamarlo. Si creamos un nuevo semáforo aquí
            adentro, ese semáforo será otro diferente del que creamos en App.
        */
        this.sCarrito = sCarrito;
        this.sEstante = sEstante;
        this.sCajero = sCajero;
    }
    
    @Override
    public void run() {
        while(!termino) {

                while(recorridos.size() < App.estantesDisponibles){
                    for(int i = 0; i < App.estantesDisponibles; i++){
                        if(!recorridos.contains(i)){
                            recorrerEstante();
                            if(App.gama.getEstantes().get(i).enUso == false){
                                agarrarProducto(i);
                                recorridos.add(i);
                            } 
                        }
                    }
                }

                pagar();
                regresarCarrito();

            /*
                Como es un while infinito, este código se repetirá una 
                y otra vez.
            */
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
            Thread.sleep( ( (5/60) *App.duracionDeHora) * 1000 );

        } catch (InterruptedException e) {
            System.out.println("El cliente no pudo recorrer estante.");
        }
    }
    
    private void agarrarProducto(int estante) {
        try {
            if(App.gama.getEstantes().get(estante).llenando == false){
                App.gama.getEstantes().get(estante).enUso = true;
            
                System.out.println("El cliente #" + this.id + " está agarrando productos del estante #" + estante);   
                /*
                    1 min para agarrar algo del estante
                */
                Thread.sleep( ( (1/60) *App.duracionDeHora) * 1000 );

                /*
                    Un cliente solo agarra entre 0 a 2 productos
                */   
                this.cantidadDeProductos = random.nextInt(2 - 0 + 1) + 0;
                if(cantidadDeProductos > 0 && App.gama.getEstantes().get(estante).getProductos().size() - cantidadDeProductos >= 0){
                    if(cantidadDeProductos == 1){
                        if(App.gama.getEstantes().get(estante).llenando == false){
                            Iterator<Producto> it = App.gama.getEstantes().get(estante).getProductos().iterator(); 
                            if(it.hasNext()){
                                Producto producto = it.next();
                                App.gama.getEstantes().get(estante).deleteProducto(producto);
                                this.productos.add(producto);
                            } else {
                                System.out.println("Oh no se acabaron los productos del estante #" + estante);
                            }
                        }  else {
                            System.out.println("Oh no se acabaron los productos del estante #" + estante);
                        }
                    } else if(cantidadDeProductos == 2) {
                        if(App.gama.getEstantes().get(estante).llenando == false){
                            Iterator<Producto> it = App.gama.getEstantes().get(estante).getProductos().iterator(); 
                            if(it.hasNext()){
                                Producto producto = it.next();
                                App.gama.getEstantes().get(estante).deleteProducto(producto);
                                this.productos.add(producto);
                            } else {
                                System.out.println("Oh no se acabaron los productos del estante #" + estante);
                            }
                        }  else {
                            System.out.println("Oh no se acabaron los productos del estante #" + estante);
                        }

                        if(App.gama.getEstantes().get(estante).llenando == false){
                           Iterator<Producto> it = App.gama.getEstantes().get(estante).getProductos().iterator(); 
                            if(it.hasNext()){
                                Producto producto = it.next();
                                App.gama.getEstantes().get(estante).deleteProducto(producto);
                                this.productos.add(producto);
                            } else {
                                System.out.println("Oh no se acabaron los productos del estante #" + estante);
                            }
                        }  else {
                            System.out.println("Oh no se acabaron los productos del estante #" + estante);
                        }
                    }
                }

                /*
                    El valor de cantidad de producto debe ser recorrido en el array de productos y además
                    debería ser restado de la cantidad de productos en dicho estante
                */
                System.out.println("El cliente #" + this.id + " agarró " + cantidadDeProductos + " productos");

                /*
                    Soltamos estante
                */
                App.gama.getEstantes().get(estante).enUso = false;
                sEstante.release();

                /*
                    Como es un while infinito, este código se repetirá una 
                    y otra vez.
                */
            } else {
                while(App.gama.getEstantes().get(estante).llenando == true){
                }
                //System.out.println("El cliente #" + this.id + " está acatando órdenes de distanciamiento social mientras se llena estante #" + estante);
                agarrarProducto(estante);
            }
        } catch (InterruptedException e) {
            System.out.println("El cliente no pudo recorrer estante #" + estante);
        }
    }
    
    private void pagar() {
        try {
            sCajero.acquire();
            System.out.println("El cliente #" + this.id + " entró en la cola para pagar" );
            int i = 0;
            if(productos.size() > 0){
                Iterator<Mostrador> it = App.gama.mostradores.iterator(); 
                while(it.hasNext()){
                    if(it.next().ocupado == false){
                        App.gama.mostradores.get(i).cliente = this.id;
                        App.gama.mostradores.get(i).productos = this.productos;
                        App.gama.mostradores.get(i).ocupado = true;
                        //System.out.println("El cliente #" + this.id + " pagará en el mostrador #" + i + App.gama.mostradores.get(i).cliente + App.gama.mostradores.get(i).productos.get(0).precio + App.gama.mostradores.get(i).ocupado );
                        break;
                    }
                    i++;
                }
                int indexProductos = 0;
                for(Producto producto : this.productos) {
                    Thread.sleep( ( ((1/120)/60)*App.duracionDeHora) * 1000 );
                    System.out.println("El cliente #" + this.id + " colocó en el mostrador su producto #" + (indexProductos + 1) );
                    indexProductos++;
                }
                while(App.gama.mostradores.get(i).ocupado){
                    //Chequeando Instagram mientras le cobran
                    Thread.sleep( ( (2/60) *App.duracionDeHora) * 1000 );
                }
            }
            sCajero.release();
        } catch (InterruptedException e) {
            System.out.println("El cliente no pudo recorrer estante.");
        }
    }
    
    private void regresarCarrito() {
        try {

            /*
                2 min para regresar carrito a su lugar
            */
            Thread.sleep(((2/60) *App.duracionDeHora) * 1000);
            this.sCarrito.release();
            App.carritosDisponibles = this.sCarrito.availablePermits();
            System.out.println("El cliente #" + this.id + " ha regresado su carrito");
            /*
                Termino ejecución, este cliente no volverá
            */
            System.out.println("El cliente #" + this.id + " dice que aún quedan " + (App.nroClientesEnSistema - 1) + " por atender" );
            App.nroClientesEnSistema = App.nroClientesEnSistema - 1;
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
    
      public boolean exists(Cliente cliente) {
        boolean itemExists = App.clientesEnColaParaPagar.stream().anyMatch(c -> c.equals(cliente));
        return itemExists;
    }
    
    
}
