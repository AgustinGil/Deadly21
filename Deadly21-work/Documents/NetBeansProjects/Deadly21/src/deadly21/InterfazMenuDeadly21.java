/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deadly21;

import static deadly21.InterfazPartidaDeadly21.lista;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Agustín
 */
public class InterfazMenuDeadly21 extends javax.swing.JFrame {

    /**
     * Creates new form interfazDeadly21
     */
    static File fichero = new File("archivos");
    static String barra = File.separator;
    static String ubicacion = System.getProperty("user.dir") + barra + "archivos" + barra;

    public InterfazMenuDeadly21() {
        initComponents();
        setLocationRelativeTo(null);
        campoNombre.setBackground(new java.awt.Color(0, 0, 0, 1));
        campoNombre.setEditable(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fondoColor = new javax.swing.JPanel();
        flechaCont = new javax.swing.JButton();
        campoNombre = new javax.swing.JTextField();
        cartel = new javax.swing.JLabel();
        TituloMenu = new javax.swing.JLabel();
        botComoJugar = new javax.swing.JButton();
        botNuevaPartida = new javax.swing.JButton();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        fondoColor.setBackground(new java.awt.Color(102, 102, 102));
        fondoColor.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        flechaCont.setBorder(null);
        flechaCont.setBorderPainted(false);
        flechaCont.setContentAreaFilled(false);
        flechaCont.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                flechaContMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                flechaContMouseExited(evt);
            }
        });
        flechaCont.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                flechaContActionPerformed(evt);
            }
        });
        fondoColor.add(flechaCont, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 590, 300, 110));

        campoNombre.setBackground(new java.awt.Color(255, 255, 255));
        campoNombre.setFont(new java.awt.Font("Chiller", 0, 64)); // NOI18N
        campoNombre.setForeground(new java.awt.Color(102, 0, 0));
        campoNombre.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        campoNombre.setBorder(null);
        campoNombre.setCaretColor(java.awt.Color.black);
        campoNombre.setOpaque(false);
        campoNombre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                campoNombreMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                campoNombreMouseExited(evt);
            }
        });
        campoNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoNombreActionPerformed(evt);
            }
        });
        fondoColor.add(campoNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 410, 520, 300));

        cartel.setDisabledIcon(null);
        fondoColor.add(cartel, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 230, -1, 500));

        TituloMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/Titulo.png"))); // NOI18N
        fondoColor.add(TituloMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 40, -1, -1));

        botComoJugar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/ComoJugar.png"))); // NOI18N
        botComoJugar.setBorder(null);
        botComoJugar.setBorderPainted(false);
        botComoJugar.setContentAreaFilled(false);
        botComoJugar.setFocusPainted(false);
        botComoJugar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                botComoJugarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                botComoJugarMouseExited(evt);
            }
        });
        botComoJugar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botComoJugarActionPerformed(evt);
            }
        });
        fondoColor.add(botComoJugar, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 510, -1, -1));

        botNuevaPartida.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/NuevaPartida.png"))); // NOI18N
        botNuevaPartida.setBorder(null);
        botNuevaPartida.setBorderPainted(false);
        botNuevaPartida.setContentAreaFilled(false);
        botNuevaPartida.setFocusPainted(false);
        botNuevaPartida.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                botNuevaPartidaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                botNuevaPartidaMouseExited(evt);
            }
        });
        botNuevaPartida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botNuevaPartidaActionPerformed(evt);
            }
        });
        fondoColor.add(botNuevaPartida, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 300, -1, -1));

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/Fondo.png"))); // NOI18N
        fondo.setToolTipText("");
        fondoColor.add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 800));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fondoColor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fondoColor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botNuevaPartidaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botNuevaPartidaMouseEntered
        // TODO add your handling code here:
        botNuevaPartida.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/NuevaPartida2.png")));
    }//GEN-LAST:event_botNuevaPartidaMouseEntered

    private void botNuevaPartidaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botNuevaPartidaMouseExited
        // TODO add your handling code here:
        botNuevaPartida.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/NuevaPartida.png")));
    }//GEN-LAST:event_botNuevaPartidaMouseExited

    private void botComoJugarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botComoJugarActionPerformed
        // TODO add your handling code here:
        InterfazDuelos interfazDue = new InterfazDuelos();
        interfazDue.setVisible(true);
    }//GEN-LAST:event_botComoJugarActionPerformed

    private void botComoJugarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botComoJugarMouseEntered
        // TODO add your handling code here:
        botComoJugar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/ComoJugar2.png")));
    }//GEN-LAST:event_botComoJugarMouseEntered

    private void botComoJugarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botComoJugarMouseExited
        // TODO add your handling code here:
        botComoJugar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/ComoJugar.png")));
    }//GEN-LAST:event_botComoJugarMouseExited

    private void botNuevaPartidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botNuevaPartidaActionPerformed
        // TODO add your handling code here:
        campoNombre.setText("Ingrese su nombre");
        campoNombre.setEditable(true);
        cartel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/Cartel.png")));
        flechaCont.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/Flecha.png")));
    }//GEN-LAST:event_botNuevaPartidaActionPerformed

    private void campoNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoNombreActionPerformed

    private void campoNombreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_campoNombreMouseClicked
        // TODO add your handling code here:
        campoNombre.setText("");
    }//GEN-LAST:event_campoNombreMouseClicked

    private void campoNombreMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_campoNombreMouseExited
        // TODO add your handling code here:
        if (cartel.getIcon() != null) {
            String aux = campoNombre.getText();
            if (aux.matches("[ ]*")) {
                campoNombre.setText("Ingrese su nombre");
            }
        }
    }//GEN-LAST:event_campoNombreMouseExited

    private void flechaContActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_flechaContActionPerformed
        // TODO add your handling code here:
        String aux = campoNombre.getText();

        if (!"Ingrese su nombre".equals(aux)) {
            if (aux.matches("[a-zA-Z]{1,10}")) {
                InterfazPartidaDeadly21.cargarParticipantes();
                setVisible(false);
                lista.ingresarAlPrincipio(aux, null);
                
                InterfazPartidaDeadly21.mazo.generarMazo();
                InterfazPartidaDeadly21.mazo.barajearMazo();
                InterfazPartidaDeadly21.lista.emparejar();

                InterfazPartidaDeadly21 interfazPartida = new InterfazPartidaDeadly21();
                InterfazDuelos interfazDuelos = new InterfazDuelos();
                interfazDuelos.setVisible(true);

                for (int i = 0; i < InterfazPartidaDeadly21.lista.largo; i++) {
                    System.out.println("\n " + "[" + i + "] " + InterfazPartidaDeadly21.lista.obtenerNombreParticipante(i) + " C, " + InterfazPartidaDeadly21.lista.obtenerParticipante(i).obtenerActitud() + InterfazPartidaDeadly21.lista.obtenerParejaParticipante(i).obtenerNombre());
                }

            }// NOMBRE INVALIDOS
        }//MENSAJE DE ERROR : TA VACIO

    }//GEN-LAST:event_flechaContActionPerformed

    private void flechaContMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_flechaContMouseEntered
        // TODO add your handling code here:
        if (cartel.getIcon() != null) {
            flechaCont.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/Flecha2.png")));
        }
    }//GEN-LAST:event_flechaContMouseEntered

    private void flechaContMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_flechaContMouseExited
        // TODO add your handling code here:
        if (cartel.getIcon() != null) {
            flechaCont.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/Flecha.png")));
        }
    }//GEN-LAST:event_flechaContMouseExited

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
            java.util.logging.Logger.getLogger(InterfazMenuDeadly21.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterfazMenuDeadly21.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterfazMenuDeadly21.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterfazMenuDeadly21.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new InterfazMenuDeadly21().setVisible(true);
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel TituloMenu;
    private javax.swing.JButton botComoJugar;
    private javax.swing.JButton botNuevaPartida;
    private javax.swing.JTextField campoNombre;
    private javax.swing.JLabel cartel;
    private javax.swing.JButton flechaCont;
    private javax.swing.JLabel fondo;
    private javax.swing.JPanel fondoColor;
    // End of variables declaration//GEN-END:variables
}
