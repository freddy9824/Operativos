/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectooperativos;

import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 *
 * @author Felix Castillo
 */
public class Mercado {
    public volatile CopyOnWriteArrayList<Estante> estantes = new CopyOnWriteArrayList<Estante>();
    public volatile CopyOnWriteArrayList<Mostrador> mostradores = new CopyOnWriteArrayList<Mostrador>();
    private int carrito; // semaforo
    private int cajaRegistradora; //semaforo
    // Si lleva numero maximo ha que colocarlo

    public CopyOnWriteArrayList<Estante> getEstantes() {
        return estantes;
    }

    public CopyOnWriteArrayList<Mostrador> getMostradores() {
        return mostradores;
    }

    public void crearCarrito(int a) {
        if (this.carrito + a <= 20) {
            this.carrito= this.carrito + a;
            System.out.println("Ya los carritos fueron colocados en la entrada");
        }
        else{
            System.out.println("No se puede colocar dicha cantdad, Maximo 20");
        }
    }
    
    public void eliminarCarrito(int a){
        if (this.carrito - a >= 10) {
            System.out.println("Error, deben haber 10 carritos en cola");
        }
        else{
            this.carrito= this.carrito-a;
            System.out.println("Los carritos fueron retirados de la cola");
        }
    }
    
    public void crearCajaRegistradora() {
        if (this.cajaRegistradora + 1 == 5) {
             System.out.println("Imposible crear caja registradora");
        }
        else {
            System.out.println("Caja registradora abierta");
        }
    }
    
    public void eliminarCajaRegistradora(){
        if (this.cajaRegistradora - 1 == 0) {
            System.out.println("Imposible cerrar caja registradora");
        }
        else {
            System.out.println("Caja registradora cerrada");
        }
    }
    
    
}
