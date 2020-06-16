/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectooperativos;

import java.util.List;
import java.util.stream.Collectors;
import java.util.Iterator;
/**
 *
 * @author Felix Castillo
 */
public class CajaRegistradora extends Thread{
    private int id;
    private int producto;
    private int varGlobal;
    private int tiempo;
    public volatile boolean despedido = false;
    
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
        while(!despedido){
            atender();
        }
    }
    
    private void atender() {
        try {
            if(App.gama.mostradores.get(this.id).ocupado == true && !this.despedido){
                App.gama.mostradores.get(this.id).ocupado = true;
                       int ganancias = 0;
                       int idCliente = App.gama.mostradores.get(this.id).cliente;
                       System.out.println("El cajero #" + this.id + " está atendiendo a cliente #" + idCliente );
                       for(int i = 0; i < App.gama.mostradores.get(this.id).productos.size(); i++){
                                System.out.println("El cajero #" + this.id + " pasó el producto #" + App.gama.mostradores.get(this.id).productos.get(i).getId() + " del cliente #" + idCliente );
                                Thread.sleep( (long) ( ( (1f/60f) *App.duracionDeHora) * 1000 ) );
                                ganancias = ganancias + App.gama.mostradores.get(this.id).productos.get(i).getPrecio();
                       }
                       
                      Thread.sleep( (long) ( ( ((1f/2f)/60f) *App.duracionDeHora) ) * 1000 ); //0.5 min;
                       System.out.println("Agregadas " + ganancias + " a las ganancias totales");
                       App.gananciasTotales = App.gananciasTotales + ganancias;
                       App.gama.mostradores.get(this.id).clear();
                       //App.gama.mostradores.get(this.id).cliente.pago = true;
                //}
            }
        } catch(InterruptedException e) {
               System.out.println("Error");
        }
    }
    
    private void leerProducto(int producto) {
        for (int i = 0; i < producto; i++) {
            try {
                Thread.sleep( (1/60*App.duracionDeHora) * 1000 ); // 1 minuto
            } catch(InterruptedException e) {
                System.out.println("Error");
            }
        }
    }
}
