/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import proyectooperativos.App;

/**
 *
 * @author Felix Castillo
 */
public class Gama extends javax.swing.JFrame {

    /**
     * Creates new form Gama
     * @param app
     */
    public App app;
    
    public Gama(App app) {
        initComponents();
        setLocationRelativeTo(this);
        setResizable(false);
        jPanel2.setVisible(false);
        jPanel1.setVisible(true);
        cerrar.setVisible(false);
        setVisible(true);
        this.app = app;
    }
    //App app = new App();
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        cajasRegistradoras = new javax.swing.JTextField();
        carritosDisponibles = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        personasEnEspera = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        horasRealizadas = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        gananciasDia = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        estantes = new javax.swing.JTextField();
        clientesEnSistema = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        cerrar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        numeroDeCarros = new javax.swing.JTextField();
        agregarCarritos = new javax.swing.JButton();
        agregarEstante = new javax.swing.JButton();
        agregarCajaAdministradora = new javax.swing.JButton();
        eliminarCarritos = new javax.swing.JButton();
        eliminarCajaRegistradora = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        cajasRegistradoras.setEditable(false);
        cajasRegistradoras.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        cajasRegistradoras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cajasRegistradorasActionPerformed(evt);
            }
        });

        carritosDisponibles.setEditable(false);
        carritosDisponibles.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        carritosDisponibles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                carritosDisponiblesActionPerformed(evt);
            }
        });

        jLabel2.setText("Estantes");

        personasEnEspera.setEditable(false);
        personasEnEspera.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel3.setText("Clientes en Sistema");

        horasRealizadas.setEditable(false);
        horasRealizadas.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        horasRealizadas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                horasRealizadasActionPerformed(evt);
            }
        });

        jLabel4.setText("Cajas Registradoras");

        gananciasDia.setEditable(false);
        gananciasDia.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel5.setText("Carritos Disponibles");

        jLabel6.setText("Personas en Espera");

        jLabel7.setText("Horas Laborales Realizadas");

        jLabel8.setText("Ganancias del Día");

        estantes.setEditable(false);
        estantes.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        estantes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                estantesActionPerformed(evt);
            }
        });
        estantes.addVetoableChangeListener(new java.beans.VetoableChangeListener() {
            public void vetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {
                estantesVetoableChange(evt);
            }
        });

        clientesEnSistema.setEditable(false);
        clientesEnSistema.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jButton1.setText("Mostrar Agregar y Eliminar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        cerrar.setText("Ocultar");
        cerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cerrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 40, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2)
                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(40, 40, 40))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(gananciasDia, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
                    .addComponent(estantes)
                    .addComponent(clientesEnSistema)
                    .addComponent(cajasRegistradoras)
                    .addComponent(carritosDisponibles)
                    .addComponent(personasEnEspera)
                    .addComponent(horasRealizadas))
                .addGap(40, 40, 40))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(154, 154, 154)
                        .addComponent(cerrar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(104, 104, 104)
                        .addComponent(jButton1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(estantes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(clientesEnSistema, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cajasRegistradoras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(carritosDisponibles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(personasEnEspera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(horasRealizadas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(gananciasDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cerrar))
        );

        numeroDeCarros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numeroDeCarrosActionPerformed(evt);
            }
        });

        agregarCarritos.setText("Agregar Carritos");
        agregarCarritos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarCarritosActionPerformed(evt);
            }
        });

        agregarEstante.setText("Agregar Estante");
        agregarEstante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarEstanteActionPerformed(evt);
            }
        });

        agregarCajaAdministradora.setText("Contratar Cajero");
        agregarCajaAdministradora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarCajaAdministradoraActionPerformed(evt);
            }
        });

        eliminarCarritos.setText("Eliminar Carritos");
        eliminarCarritos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarCarritosActionPerformed(evt);
            }
        });

        eliminarCajaRegistradora.setText("Despedir Cajero");
        eliminarCajaRegistradora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarCajaRegistradoraActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(numeroDeCarros, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(agregarCarritos))
                    .addComponent(agregarCajaAdministradora, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(eliminarCarritos, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
                    .addComponent(eliminarCajaRegistradora, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(agregarEstante, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(numeroDeCarros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(agregarCarritos)
                    .addComponent(eliminarCarritos))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(agregarCajaAdministradora)
                    .addComponent(eliminarCajaRegistradora))
                .addGap(18, 18, 18)
                .addComponent(agregarEstante)
                .addContainerGap(52, Short.MAX_VALUE))
        );

        jButton2.setText("Terminar Simulación");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setText("Gama Express");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(358, 358, 358)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(289, 289, 289)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addComponent(jButton2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void carritosDisponiblesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_carritosDisponiblesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_carritosDisponiblesActionPerformed

    private void horasRealizadasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_horasRealizadasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_horasRealizadasActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        jPanel2.setVisible(true);
        jButton1.setVisible(false);
        cerrar.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void agregarCarritosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarCarritosActionPerformed
        // TODO add your handling code here:
       int a = Integer.parseInt(numeroDeCarros.getText());
       app.setCantCarritos(a + app.getCantCarritos());
        System.out.println(a + " Carritos Agregados, ahora el la cant de carros son: " + app.getCantCarritos());
       numeroDeCarros.setText("");
       String aux = Integer.toString(app.getCantCarritos());
       carritosDisponibles.setText(aux);
    }//GEN-LAST:event_agregarCarritosActionPerformed

    private void agregarEstanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarEstanteActionPerformed
        // TODO add your handling code here:
        app.setCantEstantes(app.getCantEstantes() + 1);
        System.out.println("El estante numero " + app.getCantEstantes() + " Empezo a funcionar");
        String aux = Integer.toString(app.getCantEstantes());
        estantes.setText(aux);
    }//GEN-LAST:event_agregarEstanteActionPerformed

    private void agregarCajaAdministradoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarCajaAdministradoraActionPerformed
        // TODO add your handling code here:
        app.setCantCajaRegistradora(app.getCantCajaRegistradora()+1);
        System.out.println("Se contrato al cajero en la caja numero " + app.getCantCajaRegistradora());
        String aux = Integer.toString(app.getCantCajaRegistradora());
        cajasRegistradoras.setText(aux);
    }//GEN-LAST:event_agregarCajaAdministradoraActionPerformed

    private void cerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cerrarActionPerformed
        // TODO add your handling code here:
        jPanel2.setVisible(false);
        jPanel1.setVisible(true);
        jButton1.setVisible(true);
        cerrar.setVisible(false);
    }//GEN-LAST:event_cerrarActionPerformed

    private void eliminarCarritosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarCarritosActionPerformed
        // TODO add your handling code here:
        int a = Integer.parseInt(numeroDeCarros.getText());
        if (app.getCantCarritos()- a > 0) {
            app.setCantCarritos(app.getCantCarritos()- a);
            System.out.println(a + " Carritos Removidos, ahora el la cant de carros son: " + app.getCantCarritos());
        }
        else {
            System.out.println("No se pude remover mas carros de los que hay");
        }
       numeroDeCarros.setText("");
       String aux = Integer.toString(app.getCantCarritos());
       carritosDisponibles.setText(aux);
    }//GEN-LAST:event_eliminarCarritosActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void numeroDeCarrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_numeroDeCarrosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_numeroDeCarrosActionPerformed

    private void eliminarCajaRegistradoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarCajaRegistradoraActionPerformed
        // TODO add your handling code here:
        if (app.getCantCajaRegistradora()-1 > 0) {
            app.setCantCajaRegistradora(app.getCantCajaRegistradora()-1);
            System.out.println("Se retiro al cajero en la caja numero " + app.getCantCajaRegistradora());
            String aux = Integer.toString(app.getCantCajaRegistradora());
            cajasRegistradoras.setText(aux);
        }
        else {
            System.out.println("No se puede retirar al cajero en caja 1");
        }
    }//GEN-LAST:event_eliminarCajaRegistradoraActionPerformed

    private void estantesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_estantesActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_estantesActionPerformed

    private void estantesVetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {//GEN-FIRST:event_estantesVetoableChange
        // TODO add your handling code here:
        String a = Integer.toString(app.getCantEstantes());
        estantes.setText(a);
    }//GEN-LAST:event_estantesVetoableChange

    private void cajasRegistradorasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cajasRegistradorasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cajasRegistradorasActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Gama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Gama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Gama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Gama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton agregarCajaAdministradora;
    private javax.swing.JButton agregarCarritos;
    private javax.swing.JButton agregarEstante;
    public volatile javax.swing.JTextField cajasRegistradoras;
    public volatile javax.swing.JTextField carritosDisponibles;
    private javax.swing.JButton cerrar;
    public volatile javax.swing.JTextField clientesEnSistema;
    private javax.swing.JButton eliminarCajaRegistradora;
    private javax.swing.JButton eliminarCarritos;
    public volatile javax.swing.JTextField estantes;
    public volatile javax.swing.JTextField gananciasDia;
    public volatile javax.swing.JTextField horasRealizadas;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField numeroDeCarros;
    public volatile javax.swing.JTextField personasEnEspera;
    // End of variables declaration//GEN-END:variables
}
