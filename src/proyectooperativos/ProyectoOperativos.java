/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectooperativos;

import Interfaz.Actualizador;
import Interfaz.Gama;

/**
 *
 * @author Felix Castillo
 */
public class ProyectoOperativos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        App app = new App();
        Gama gama = new Gama(app); 
        app.iniciar(gama.estantes, gama.clientesEnSistema, gama.cajasRegistradoras, gama.carritosDisponibles, gama.personasEnEspera, gama.horasRealizadas, gama.gananciasDia);
    }}
