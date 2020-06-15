/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectooperativos;

import static proyectooperativos.App.duracionDeHora;

/**
 *
 * @author Felix Castillo
 */
class Supervisor extends Thread{
    private int hora;
    
    public Supervisor(){
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    public Supervisor(int hora) {
        this.hora = hora;
    }

    public int getHora() {
        return hora;
    }
    
    
    @Override
    public void run() {
        System.out.println("El Supervisor está corriendo y les desea una feliz jornada laboral a los empleados");
        while(true){
            try {
                sleep(App.duracionDeHora/60*5); // 1 hora
                marcarHora();
            } catch (InterruptedException e) {
                System.out.println("Error");
            }
        }
    }
    
    public void marcarHora() {
        App.horasAbierto = App.horasAbierto + 1;
        if(App.horasAbierto < 8){
            System.out.println("El Supervisor dice que ha pasado 1 hora, dando un total de " + App.horasAbierto);
        } else {
            System.out.println("El Supervisor dice que ya han pasado 8 horas, se procederán a resetear contadores de ganancia y horas");
            System.out.println("GANANCIAS TOTALES: " + App.gananciasTotales + " CA CHING!, 'más cerca de tener el yate' susurra el Supervisor");
            App.horasAbierto = 0;
            App.gananciasTotales = 0;
        }
    }
}
