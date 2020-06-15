/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;
import javax.swing.*;
/**
 *
 * @author Felix Castillo
 */
public class Actualizador extends Thread{
    volatile int auxEstante;
    volatile int auxClientesEnSist;
    volatile int auxCajaRegistradora;
    volatile int auxCarritosDisponibles;
    volatile int auxPersonasEnEspera;
    volatile int auxHorasLaborales;
    volatile int auxGananciasDia;
    String appEstante;
    String appClientesEnSist;
    String appCajaRegistradora;
    String appCarritosDisponibles;
    String appPersonasEnEspera;
    String appHorasLaborales;
    String appGananciasDia;
    JTextField estante;
    JTextField clientesEnSist;
    JTextField cajasRegistradoras;
    JTextField carritosDisponibles;
    JTextField personasEnEspera;
    JTextField horasLaborales;
    JTextField gananciasDia;

    public Actualizador(int auxEstante, int auxClientesEnSist, int auxCajaRegistradora, int auxCarritosDisponibles ,int auxPersonasEnEspera, int auxHorasLaborales, int auxGananciasDia, JTextField estante, JTextField clientesEnSist, JTextField cajasRegistradoras, JTextField carritosDisponibles, JTextField personasEnEspera, JTextField horasLaborales, JTextField gananciasDia) {
        this.auxEstante = auxEstante;
        this.auxClientesEnSist = auxClientesEnSist;
        this.auxCajaRegistradora = auxCajaRegistradora;
        this.auxCarritosDisponibles = auxCarritosDisponibles;
        this.auxPersonasEnEspera = auxPersonasEnEspera;
        this.auxHorasLaborales = auxHorasLaborales;
        this.auxGananciasDia = auxGananciasDia;
        
        this.estante = estante;
        this.clientesEnSist = clientesEnSist;
        this.cajasRegistradoras = cajasRegistradoras;
        this.carritosDisponibles = carritosDisponibles;
        this.personasEnEspera = personasEnEspera;
        this.horasLaborales = horasLaborales;
        this.gananciasDia = gananciasDia;
    }



    
    
    @Override
    public void run() {
        while  (true) {
            appEstante = Integer.toString(auxEstante);
            appClientesEnSist = Integer.toString(auxClientesEnSist);
            appCajaRegistradora = Integer.toString(auxCajaRegistradora);
            appCarritosDisponibles = Integer.toString(auxCarritosDisponibles);
            appPersonasEnEspera = Integer.toString(auxPersonasEnEspera);
            appHorasLaborales = Integer.toString(auxHorasLaborales);
            appGananciasDia = Integer.toString(auxGananciasDia);
            
            
            estante.setText(appEstante);
            clientesEnSist.setText(appClientesEnSist);
            cajasRegistradoras.setText(appCajaRegistradora);
            carritosDisponibles.setText(appCarritosDisponibles);
            personasEnEspera.setText(appPersonasEnEspera);
            horasLaborales.setText(appHorasLaborales);
            gananciasDia.setText(appGananciasDia);
        }
    }
    
    
}
