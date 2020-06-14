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
    int auxEstante;
    int auxClientesEnSist;
    int auxCajaRegistradora;
    int auxCarritosDisponibles;
    int auxPersonasEnEspera;
    int auxHorasLaborales;
    int auxGananciasDia;
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
            this.appEstante = Integer.toString(this.auxEstante);
            this.appClientesEnSist = Integer.toString(this.auxClientesEnSist);
            this.appCajaRegistradora = Integer.toString(this.auxCajaRegistradora);
            this.appCarritosDisponibles = Integer.toString(this.auxCarritosDisponibles);
            this.appPersonasEnEspera = Integer.toString(this.auxPersonasEnEspera);
            this.appHorasLaborales = Integer.toString(this.auxHorasLaborales);
            this.appGananciasDia = Integer.toString(this.auxGananciasDia);
            this.estante.setText(appEstante);
            this.clientesEnSist.setText(appClientesEnSist);
            this.cajasRegistradoras.setText(appCajaRegistradora);
            this.carritosDisponibles.setText(appCarritosDisponibles);
            this.personasEnEspera.setText(appPersonasEnEspera);
            this.horasLaborales.setText(appHorasLaborales);
            this.gananciasDia.setText(appGananciasDia);
        }
    }
    
    
}
