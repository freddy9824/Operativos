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
class Supervisor extends Thread{
    private int hora;

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
        marcarHora(hora);
        try {
            sleep(1500); // 1.5 Min
            System.out.println("Han pasado: " + hora);
        } catch (InterruptedException e) {
            System.out.println("Error");
        }
    }
    
    int marcarHora(int a) {
        a = a+1;
        return a;
    }
}
