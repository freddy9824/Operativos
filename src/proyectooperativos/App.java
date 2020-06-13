/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectooperativos;

import java.util.concurrent.Semaphore;

/**
 *
 * @author Sagasjan
 */
public class App {
    Semaphore sCarrito;
    Semaphore sEstante;
    Semaphore sCajaRegistradora;
    public static int maxCantidadDeEstantes;
    public static int estantesDisponibles = 1;
    public static int maxCantidadDeProductosPorEstantes = 10;
    public static Mercado gama;
    
     public App() {
        /*
            Creación de semáforos
        */
        this.sCarrito = new Semaphore(1);
        this.sEstante = new Semaphore(1);
        this.sCajaRegistradora = new Semaphore(1);
    }
     
     public void iniciar() {
        
        /*
            Vamos a crear unos cuantos clientes, ve a Clientes para saber
            sobre los hilos y cómo usarlos.
        */
        gama = new Mercado();

        int id = 1;
        
        Empleado[] empleados = new Empleado[estantesDisponibles];
        
        for (int i = 0; i < estantesDisponibles; i++) {
            
            gama.getEstantes().add(new Estante(i));
            
            empleados[i] = new Empleado(
                i          // Su ID
            );
            
            /*
                Al hacer clientes[i].start() comenzamos a correr el hilo.
                Esto genera muchas confusiones porque la función que definimos
                en Cliente se llama run() pero bueno, es lo que hay, ¿no?
            */
            empleados[i].start();
        }
        
        while (true) {
            try {
                Thread.sleep(2000);
            }catch(InterruptedException e) {
                System.out.println("Error");
            }
            Cliente cliente = new Cliente(
            id, this.sCarrito, this.sEstante, this.sCajaRegistradora);
            id++;
            cliente.start();
        }
        
        
    }  
}
