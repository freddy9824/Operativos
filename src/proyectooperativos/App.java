/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectooperativos;

import java.util.concurrent.Semaphore;
import javax.swing.CellEditor;

/**
 *
 * @author Sagasjan
 */
public class App {
    int cantCarritos = 1;
    int cantEstantes=1;
    int cantCajaRegistradora=4;
    Semaphore sCarrito;
    Semaphore sEstante;
    Semaphore sCajaRegistradora;
    public static int maxCantidadDeEstantes;
    public static int estantesDisponibles = 1;
    
     public App() {
        /*
            Creación de semáforos
        */
        this.sCarrito = new Semaphore(this.cantCarritos);
        this.sEstante = new Semaphore(this.cantEstantes);
        this.sCajaRegistradora = new Semaphore(this.cantCajaRegistradora);
    }

    public int getCantCarritos() {
        return cantCarritos;
    }

    public void setCantCarritos(int cantCarritos) {
        this.cantCarritos = cantCarritos;
    }

    public int getCantEstantes() {
        return cantEstantes;
    }

    public void setCantEstantes(int cantEstantes) {
        this.cantEstantes = cantEstantes;
    }

    public int getCantCajaRegistradora() {
        return cantCajaRegistradora;
    }

    public void setCantCajaRegistradora(int cantCajRegistradora) {
        this.cantCajaRegistradora = cantCajRegistradora;
    }

    


     
     
     public void iniciar(javax.swing.JTextField a) {
        
        /*
            Vamos a crear unos cuantos clientes, ve a Clientes para saber
            sobre los hilos y cómo usarlos.
        */
        int id = 1;
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
            String b = Integer.toString(id);
            a.setText(b);
            
        }
            /*
                Al hacer clientes[i].start() comenzamos a correr el hilo.
                Esto genera muchas confusiones porque la función que definimos
                en Cliente se llama run() pero bueno, es lo que hay, ¿no?
            */
            
        }
        
    }  
