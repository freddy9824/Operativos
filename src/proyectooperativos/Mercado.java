/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectooperativos;


/**
 *
 * @author Felix Castillo
 */
public class Mercado {
    private Producto[] estante; // puede ser una lista no se
    private int carrito; // semaforo
    private int cajaRegistradora; //semaforo
    private Producto producto; // dudo de esto
    // Si lleva numero maximo ha que colocarlo

    public Producto[] getEstante() {
        return estante;
    }

    public int getCajaRegistradora() {
        return cajaRegistradora;
    }


    public Producto getProducto() {
        return producto;
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
