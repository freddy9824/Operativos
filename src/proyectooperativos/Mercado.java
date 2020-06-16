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
    
}
