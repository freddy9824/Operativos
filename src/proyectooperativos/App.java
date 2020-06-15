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
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Semaphore;
import javax.swing.JOptionPane;
import javax.*;

/**
 *
 * @author Sagasjan
 */
public class App {
    Semaphore sCarrito;
    Semaphore sEstante;
    Semaphore sCajero;
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
    public static volatile Mercado gama;
    javax.swing.JTextField estantes;
    javax.swing.JTextField cajeros;
    javax.swing.JTextField carritos;
    File archivoConfig = new File("archivoConfig.txt"); 
    public static volatile boolean iniciar = false;
    public static volatile CopyOnWriteArrayList<Cliente> clientesEnColaParaEntrar;
    public static volatile CopyOnWriteArrayList<Cliente> clientesEnColaParaPagar;
    public static volatile ArrayList<CajaRegistradora> cajaRegistradora;
    public static volatile CopyOnWriteArrayList<Mostrador> mostradores;
    public static Empleado[] empleados;
    public static Supervisor supervisor;
    
     public App() {
        LeerArchivo();
        /*
            Creación de semáforos
        */
        this.sCarrito = new Semaphore(App.carritosIniciales);
        this.sEstante = new Semaphore(App.estantesIniciales);
        this.sCajero = new Semaphore(App.cajasRegistradorasIniciales);
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
        return 0;
    }

    public void setCantCajaRegistradora(int cantCajRegistradora) {
        //this.cantCajaRegistradora = cantCajRegistradora;
    }

    


     
     public void iniciar(
             javax.swing.JTextField shelves,
             javax.swing.JTextField clientInSist,
             javax.swing.JTextField cashRegisters,
             javax.swing.JTextField shoppingCart,
             javax.swing.JTextField waitingPeople,
             javax.swing.JTextField workingHours,
             javax.swing.JTextField profits
             ) {
        
         if(iniciar){
            /*
                Agarramos los valores iniciales para poner a funcionar el Mercado
            */
             estantesDisponibles = estantesIniciales;
             carritosDisponibles = carritosIniciales;
             nroClientesEnColaParaEntrar = 0;
             clientesEnColaParaEntrar = new CopyOnWriteArrayList<Cliente>();
             clientesEnColaParaPagar = new CopyOnWriteArrayList<Cliente>();
             mostradores = new CopyOnWriteArrayList<Mostrador>();
             empleados = new Empleado[estantesIniciales];
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
            String auxCart = Integer.toString(carritosDisponibles);
            shoppingCart.setText(auxCart);
            String auxProfits = Integer.toString(gananciasTotales);
            String auxHours = Integer.toString(horasAbierto);
            profits.setText(auxProfits);
            workingHours.setText(auxHours);
            String auxCashRegisters = Integer.toString(cajasRegistradorasIniciales);
            cashRegisters.setText(auxCashRegisters);
            clientInSist.setText( Integer.toString( nroClientesEnSistema ) );
            String auxWait = Integer.toString(nroClientesEnColaParaEntrar);
            waitingPeople.setText(auxWait);
            
            CajaRegistradora[] cajaRegistradoras = new CajaRegistradora[cajasRegistradorasIniciales];
            
            for (int i = 0; i < cajasRegistradorasIniciales; i++) {
                gama.getMostradores().add(new Mostrador(i));
                cajaRegistradoras[i] = new CajaRegistradora(
                    i          // Su ID
                );
                cajaRegistradoras[i].start();
            }
            
            while (true) {
                try {
                    /*
                        El cliente llega y toma inmediatamente un carrito disponible
                    */
                    if(sCarrito.tryAcquire()){
                        nroClientesEnColaParaEntrar = App.clientesEnColaParaEntrar.size();
                        nroClientesEnSistema = nroClientesEnSistema + 1;
                        //System.out.println("Adquiriendo Carrito el cliente #" + id);
                        App.carritosDisponibles = sCarrito.availablePermits();
                        //Thread.sleep(duracionDeHora/60*2);
                        if(App.clientesEnColaParaEntrar.size() > 0) {
                            System.out.println("Adquiriendo Carrito el cliente #" + (id - 1) + " quedan " + App.carritosDisponibles + " carritos disponibles");
                            App.clientesEnColaParaEntrar.remove(0).start();
                        } else {
                            System.out.println("Adquiriendo Carrito el cliente #" + id + " quedan " + App.carritosDisponibles + " carritos disponibles");
                            Cliente cliente = new Cliente(
                            id, this.sCarrito, this.sEstante, this.sCajero);
                            id++;
                            cliente.start();
                        }
                        auxWait = Integer.toString(nroClientesEnColaParaEntrar);
                        waitingPeople.setText(auxWait);
                    }else{
                        /*
                            Un cliente entra cada X tiempo
                        */
                        Thread.sleep( ( (5/60)*App.duracionDeHora) * 1000 );
                        nroClientesEnColaParaEntrar = App.clientesEnColaParaEntrar.size();
                        //System.out.println("El cliente #" + id + " está esperando a ser atendido");
                        App.clientesEnColaParaEntrar.add(new Cliente(id, this.sCarrito, this.sEstante, this.sCajero));
                        id++;
                        auxWait = Integer.toString(nroClientesEnColaParaEntrar);
                        waitingPeople.setText(auxWait);
                    };
                    auxCart = Integer.toString(carritosDisponibles);
                    shoppingCart.setText(auxCart);
                    auxProfits = Integer.toString(gananciasTotales);
                    auxHours = Integer.toString(horasAbierto);
                    profits.setText(auxProfits);
                    workingHours.setText(auxHours);
                    auxCashRegisters = Integer.toString(cajasRegistradorasIniciales);
                    cashRegisters.setText(auxCashRegisters);
                    clientInSist.setText( Integer.toString( nroClientesEnSistema ) );
                    
                }catch(InterruptedException e) {
                    System.out.println("Error");
                }
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
            duracionDeHora = Integer.parseInt(arrayAux[1]);
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
