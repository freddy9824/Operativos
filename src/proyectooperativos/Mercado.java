/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectooperativos;

import java.util.ArrayList;

/**
 *
 * @author Felix Castillo
 */
public class Mercado {
    public static volatile ArrayList<Estante> estantes = new ArrayList<Estante>(); // puede ser una lista no se
    private int carrito; // semaforo
    private int cajaRegistradora; //semaforo
    // Si lleva numero maximo ha que colocarlo

    public ArrayList<Estante> getEstantes() {
        return estantes;
    }

    public int getCajaRegistradora() {
        return cajaRegistradora;
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
