/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectooperativos;

import java.util.List;
import java.util.stream.Collectors;
/**
 *
 * @author Felix Castillo
 */
public class CajaRegistradora extends Thread{
    private int id;
    private int producto;
    private int varGlobal;
    private int tiempo;
    
    public CajaRegistradora(int id){
        this.id = id;
    }

    public void setProducto(int producto) {
        this.producto = producto;
    }

    public void setVarGlobal(int varGlobal) {
        this.varGlobal = varGlobal;
    }

    public int getVarGlobal() {
        return varGlobal;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }
    
    
    
    @Override
    public void run() {
        while(true){
            atender();
        }
        //leerProducto(producto);
        //varGlobal++;
    }
    
    private void atender() {
        try {
            Thread.sleep(3000);
            System.out.println("El cajero #" + this.id + " quiere cobrarle a alguien" );
            System.out.println("Cola actual " + App.clientesEnColaParaPagar.size() + " personas según Cajero #" + this.id );
            App.nroClientesEnColaParaPagar = App.clientesEnColaParaPagar.size();
            if(App.clientesEnColaParaPagar.size() > 0){
                int ganancias = 0;
                Cliente cliente = App.clientesEnColaParaPagar.remove(0);
                if(cliente != null){
                     if(!cliente.atendido){
                       int idCliente = cliente.id;
                       System.out.println("El cajero #" + this.id + " está atendiendo a cliente #" + idCliente );
                       cliente.atendido = true;
                       for(int i = 0; i < cliente.productos.size(); i++){
                           try {
                                Thread.sleep(App.duracionDeHora/60*1);
                                ganancias = ganancias + cliente.productos.get(i).getPrecio();
                                System.out.println("El cajero #" + this.id + " pasó el producto #" + cliente.productos.get(i).getId() + " del cliente #" + idCliente );
                            } catch(InterruptedException e) {
                                System.out.println("Error");
                            }
                       }
                       cliente.pago = true;
                       
                       Thread.sleep(App.duracionDeHora/60*(int) 0.5); //0.5 min;
                       System.out.println("Agregadas " + ganancias + " a las ganancias totales");
                       App.gananciasTotales = App.gananciasTotales + ganancias;
                       //break;
                   }
                }
                //for (int i = 0; i < App.clientesEnColaParaPagar.size(); i++) {
//                    if(!App.clientesEnColaParaPagar.get(i).atendido){
//                       int idCliente = App.clientesEnColaParaPagar.get(i).id;
//                       System.out.println("El cajero #" + this.id + " está atendiendo a cliente #" + idCliente );
//                       App.clientesEnColaParaPagar.get(i).atendido = true;
//                       App.clientesEnColaParaPagar.get(i).productos.forEach( (producto) -> {
//                           try {
//                                Thread.sleep(1000);
//                                System.out.println("El cajero #" + this.id + " pasó el producto #" + producto.getId() + " del cliente #" + idCliente );
//                            } catch(InterruptedException e) {
//                                System.out.println("Error");
//                            }
//                       });
//                       App.clientesEnColaParaPagar.get(i).pago = true;
//                       //break;
//                   }
                //}

            }
        } catch(InterruptedException e) {
               System.out.println("Error");
        }
//        for (int i = 0; i < producto; i++) {
//            try {
//                sleep(tiempo * 60 / 1000); // 1 minuto
//            } catch(InterruptedException e) {
//                System.out.println("Error");
//            }
//        }
    }
    
    private void leerProducto(int producto) {
        for (int i = 0; i < producto; i++) {
            try {
                sleep(App.duracionDeHora/60*1); // 1 minuto
            } catch(InterruptedException e) {
                System.out.println("Error");
            }
        }
    }
}
