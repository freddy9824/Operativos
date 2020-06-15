/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectooperativos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.concurrent.Semaphore;
import javax.swing.JOptionPane;
import javax.*;

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
    public static int maxCantidadDeEstantes;
    public static int estantesIniciales = 1;
    public static int estantesDisponibles = 1;
    public static int maxCantidadDeProductosPorEstantes = 10;
    public static int duracionDeHora;
    public static int cajasRegistradorasIniciales;
    public static int maxCantidadDeCajasRegistradoras;
    public static int carritosIniciales = 1;
    public static int maxCantidadDeCarritos;
    public static int carritosDisponibles;
    public static int nroClientesEnColaParaEntrar = 0;
    public static int nroClientesEnColaParaPagar = 0;
    public static int nroClientesEnSistema = 0;
    public static int horasAbierto = 0;
    public static int gananciasTotales = 0;
    public static Mercado gama;
    javax.swing.JTextField estantes;
    javax.swing.JTextField cajeros;
    javax.swing.JTextField carritos;
    File archivoConfig = new File("archivoConfig.txt"); 
    public static volatile boolean iniciar = false;
    public static volatile ArrayList<Cliente> clientesEnColaParaEntrar;
    public static volatile ArrayList<Cliente> clientesEnColaParaPagar;
    public static volatile ArrayList<CajaRegistradora> cajaRegistradora;
    public static volatile ArrayList<Mostrador> mostradores;
    public static Empleado[] empleados;
    public static Supervisor supervisor;
    
     public App() {
        LeerArchivo();
        /*
            Creación de semáforos
        */
        this.sCarrito = new Semaphore(App.carritosIniciales);
        this.sEstante = new Semaphore(this.cantEstantes);
    }

    public int getCantCarritos() {
        return carritosDisponibles;
    }

    public void setCantCarritos(int cantCarritos) {
        this.sCarrito.release(cantCarritos);
        App.carritosDisponibles = this.sCarrito.availablePermits();
    }
    
    public void eliminarCantCarritos(int cantCarritos) {
        try{
            this.sCarrito.acquire(cantCarritos);
        }   catch(Exception e){
        }
        App.carritosDisponibles = this.sCarrito.availablePermits();
    }

    public int getCantEstantes() {
        return estantesDisponibles;
    }

    public void setCantEstantes(int cantEstantes) {
        int largo = estantesDisponibles;
        App.estantesDisponibles = estantesDisponibles + 1;
        gama.getEstantes().add(new Estante(largo));

        new Empleado(
            largo         // Su ID
        ).start();

        /*
            Al hacer clientes[i].start() comenzamos a correr el hilo.
            Esto genera muchas confusiones porque la función que definimos
            en Cliente se llama run() pero bueno, es lo que hay, ¿no?
        */
        //empleados[largo].start();
        this.sEstante.release(1);
    }

    public int getCantCajaRegistradora() {
        return cantCajaRegistradora;
    }

    public void setCantCajaRegistradora(int cantCajRegistradora) {
        this.cantCajaRegistradora = cantCajRegistradora;
    }

    


     
     public void iniciar(
             javax.swing.JTextField shelves,
             javax.swing.JTextField clientSist,
             javax.swing.JTextField cashRegisters,
             javax.swing.JTextField shoppingCart,
             javax.swing.JTextField waitingPeople,
             javax.swing.JTextField workingHours,
             javax.swing.JTextField profits
             ) {
        
         if(iniciar){
             estantesDisponibles = estantesIniciales;
             carritosDisponibles = carritosIniciales;
             nroClientesEnColaParaEntrar = 0;
             clientesEnColaParaEntrar = new ArrayList<Cliente>();
             clientesEnColaParaPagar = new ArrayList<Cliente>();
             mostradores = new ArrayList<Mostrador>();
             empleados = new Empleado[estantesIniciales];
            /*
                Vamos a crear unos cuantos clientes, ve a Clientes para saber
                sobre los hilos y cómo usarlos.
            */
            gama = new Mercado();
            
            supervisor = new Supervisor();
            supervisor.start();
            
            int id = 1;

            //Empleado[] empleados = new Empleado[estantesIniciales];

            for (int i = 0; i < estantesIniciales; i++) {

                gama.getEstantes().add(new Estante(i));
                String auxShelves = Integer.toString(gama.getEstantes().size());
                shelves.setText(auxShelves);
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
            
            
            CajaRegistradora[] cajaRegistradoras = new CajaRegistradora[cajasRegistradorasIniciales];
            
            for (int i = 0; i < cajasRegistradorasIniciales; i++) {
                cajaRegistradoras[i] = new CajaRegistradora(
                    i          // Su ID
                );
                cajaRegistradoras[i].start();
            }
            
            while (true) {
                try {
                    if(sCarrito.tryAcquire()){
                        nroClientesEnColaParaEntrar = App.clientesEnColaParaEntrar.size();
                        nroClientesEnSistema = nroClientesEnSistema + 1;
                        //System.out.println("Adquiriendo Carrito el cliente #" + id);
                        App.carritosDisponibles = sCarrito.availablePermits();
                        Thread.sleep(2000);
                        if(App.clientesEnColaParaEntrar.size() > 0) {
                            System.out.println("Adquiriendo Carrito el cliente #" + (id - 1) + " quedan " + App.carritosDisponibles + " carritos disponibles");
                            App.clientesEnColaParaEntrar.remove(0).start();
                        } else {
                            System.out.println("Adquiriendo Carrito el cliente #" + id + " quedan " + App.carritosDisponibles + " carritos disponibles");
                            Cliente cliente = new Cliente(
                            id, this.sCarrito, this.sEstante);
                            id++;
                            cliente.start();
                        }
                        String auxWait = Integer.toString(nroClientesEnColaParaEntrar);
                        waitingPeople.setText(auxWait);
                        clientSist.setText( Integer.toString( nroClientesEnSistema ) );
                    }else{
                        /*
                            Un cliente entra cada X tiempo
                        */
                        nroClientesEnColaParaEntrar = App.clientesEnColaParaEntrar.size();
                        Thread.sleep(1000);
                        System.out.println("El cliente #" + id + " está esperando a ser atendido");
                        App.clientesEnColaParaEntrar.add(new Cliente(id, this.sCarrito, this.sEstante));
                        id++;
                        String auxWait = Integer.toString(nroClientesEnColaParaEntrar);
                        waitingPeople.setText(auxWait);
                    };
                    String aux = Integer.toString(carritosDisponibles);
                    shoppingCart.setText(aux);
                }catch(InterruptedException e) {
                    System.out.println("Error");
                }
//                Cliente cliente = new Cliente(
//                id, this.sCarrito, this.sEstante, this.sCajaRegistradora);
//                id++;
//                cliente.start();
                //String b = Integer.toString(id);
                //a.setText(b);
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

            if ((estantesIniciales > maxCantidadDeEstantes) || estantesIniciales <= 0 || maxCantidadDeEstantes <= 2 || maxCantidadDeProductosPorEstantes < 1) {
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
