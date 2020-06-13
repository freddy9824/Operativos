/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectooperativos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.concurrent.Semaphore;
import javax.swing.JOptionPane;

/**
 *
 * @author Sagasjan
 */
public class App {
    Semaphore sCarrito;
    Semaphore sEstante;
    Semaphore sCajaRegistradora;
    public static int maxCantidadDeEstantes;
    public static int estantesIniciales = 1;
    public static int maxCantidadDeProductosPorEstantes = 10;
    public static int duracionDeHora;
    public static int cajasRegistradorasIniciales;
    public static int maxCantidadDeCajasRegistradoras;
    public static int carritosIniciales;
    public static int maxCantidadDeCarritos;
    public static Mercado gama;
    File archivoConfig = new File("archivoConfig.txt"); 
    public static volatile boolean iniciar = false;
    
     public App() {
        /*
            Creación de semáforos
        */
        this.sCarrito = new Semaphore(1);
        this.sEstante = new Semaphore(1);
        this.sCajaRegistradora = new Semaphore(1);
    }
     
     public void iniciar() {
         
        LeerArchivo();
        
         if(iniciar){
             
            /*
                Vamos a crear unos cuantos clientes, ve a Clientes para saber
                sobre los hilos y cómo usarlos.
            */
            gama = new Mercado();

            int id = 1;

            Empleado[] empleados = new Empleado[estantesIniciales];

            for (int i = 0; i < estantesIniciales; i++) {

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
     
     public void LeerArchivo(){
        String aux;
        String[] arrayAux;
        try{
            BufferedReader bf = new BufferedReader(new FileReader(archivoConfig));           
            aux = bf.readLine();
            arrayAux = aux.split(":");
            duracionDeHora = Integer.parseInt(arrayAux[1])*1000;
            aux = bf.readLine();
            arrayAux = aux.split(":");
            estantesIniciales = Integer.parseInt(arrayAux[1]);
            aux = bf.readLine();
            arrayAux = aux.split(":");
            maxCantidadDeEstantes = Integer.parseInt(arrayAux[1]);
            aux = bf.readLine();
            arrayAux = aux.split(":");
            maxCantidadDeProductosPorEstantes = Integer.parseInt(arrayAux[1]);
            aux = bf.readLine();
            arrayAux = aux.split(":");
            cajasRegistradorasIniciales = Integer.parseInt(arrayAux[1]);
            aux = bf.readLine();
            arrayAux = aux.split(":");
            maxCantidadDeCajasRegistradoras = Integer.parseInt(arrayAux[1]);
            aux = bf.readLine();
            arrayAux = aux.split(":");
            carritosIniciales = Integer.parseInt(arrayAux[1]);
            aux = bf.readLine();
            arrayAux = aux.split(":");
            maxCantidadDeCarritos = Integer.parseInt(arrayAux[1]);

            if ((estantesIniciales > maxCantidadDeEstantes) || estantesIniciales <= 0 || maxCantidadDeEstantes <= 2 || maxCantidadDeProductosPorEstantes < 3 || maxCantidadDeProductosPorEstantes > 10) {
                JOptionPane.showMessageDialog(null, "Inconsistencia de datos de configuración de estantes");
                System.exit(0);
            }else if((cajasRegistradorasIniciales > maxCantidadDeCajasRegistradoras) || cajasRegistradorasIniciales <= 0){
                JOptionPane.showMessageDialog(null, "Inconsistencia de datos de configuración de cajas registradoras");
                System.exit(0);
            }else if((carritosIniciales > maxCantidadDeCarritos) || carritosIniciales < 0){
                JOptionPane.showMessageDialog(null, "Inconsistencia de datos de configuración de carritos");
                System.exit(0);
            }else{
                iniciar = true;
            }
            bf.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "No se logró leer el archivo de configuración.\nRecuerda usar enteros y no decimales");
            System.exit(0);
        }
    }
}
