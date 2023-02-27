/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deadly21;

import static deadly21.InterfazPartidaDeadly21.lista;
import static deadly21.InterfazPartidaDeadly21.listaFinal;
import static deadly21.InterfazPartidaDeadly21.listaInicial;
import static deadly21.InterfazPartidaDeadly21.listaSemis;
import static deadly21.InterfazPartidaDeadly21.ganador;
import static deadly21.InterfazMenuDeadly21.interfazPartida;
import java.awt.Color;

/**
 *
 * @author Agustín
 */
public class InterfazDuelos extends javax.swing.JFrame {
    public void comienzo(){
        labelOctavos1.setText(listaInicial.obtenerNombreParticipante(0));
        labelOctavos5.setText(listaInicial.obtenerNombreParticipante(1));
        labelOctavos6.setText(listaInicial.obtenerNombreParticipante(2));
        labelOctavos7.setText(listaInicial.obtenerNombreParticipante(3));
        labelOctavos.setText(listaInicial.obtenerNombreParticipante(4));
        labelOctavos2.setText(listaInicial.obtenerNombreParticipante(5));
        labelOctavos3.setText(listaInicial.obtenerNombreParticipante(6));
        labelOctavos4.setText(listaInicial.obtenerNombreParticipante(7));
     }
     
    public void semis(){
         comienzo();
        labelSemis.setText(listaSemis.obtenerNombreParticipante(0));
        labelSemis1.setText(listaSemis.obtenerNombreParticipante(1));
        labelSemis2.setText(listaSemis.obtenerNombreParticipante(2));
        labelSemis3.setText(listaSemis.obtenerNombreParticipante(3));
     }
     
     public void finals(){
         semis();
        labelFinal.setText(listaFinal.obtenerNombreParticipante(0));
        labelFinal1.setText(listaFinal.obtenerNombreParticipante(1));
         
     }
     
     public void ganador(){
         finals();
         labelGanador.setText(ganador.obtenerNombre());
     }
    /**
     * Creates new form interfazDuelos
     */
    public InterfazDuelos() {
        initComponents();
        setBackground(new Color(1.0f,1.0f,1.0f,0.0f));
        setLocationRelativeTo(null);
        if(lista.largo == 8){
            comienzo();
        }
        else if(lista.largo == 4){
            semis();
        }
         else if(lista.largo == 2){
            finals();
        }
         else if(lista.largo == 1 || lista.largo == 0){
             ganador();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelOctavos = new javax.swing.JLabel();
        labelOctavos1 = new javax.swing.JLabel();
        labelOctavos2 = new javax.swing.JLabel();
        labelOctavos3 = new javax.swing.JLabel();
        labelOctavos4 = new javax.swing.JLabel();
        labelOctavos5 = new javax.swing.JLabel();
        labelOctavos6 = new javax.swing.JLabel();
        labelOctavos7 = new javax.swing.JLabel();
        labelSemis = new javax.swing.JLabel();
        labelSemis1 = new javax.swing.JLabel();
        labelSemis2 = new javax.swing.JLabel();
        labelSemis3 = new javax.swing.JLabel();
        labelFinal = new javax.swing.JLabel();
        labelFinal1 = new javax.swing.JLabel();
        labelGanador = new javax.swing.JLabel();
        flechaCont = new javax.swing.JButton();
        papelDuelos = new javax.swing.JLabel();
        cartelDuelos = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelOctavos.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        labelOctavos.setForeground(new java.awt.Color(0, 0, 0));
        labelOctavos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(labelOctavos, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 330, 60, 20));

        labelOctavos1.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        labelOctavos1.setForeground(new java.awt.Color(0, 0, 0));
        labelOctavos1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(labelOctavos1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 330, 60, 20));

        labelOctavos2.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        labelOctavos2.setForeground(new java.awt.Color(0, 0, 0));
        labelOctavos2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(labelOctavos2, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 420, 60, 10));

        labelOctavos3.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        labelOctavos3.setForeground(new java.awt.Color(0, 0, 0));
        labelOctavos3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(labelOctavos3, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 520, 60, -1));

        labelOctavos4.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        labelOctavos4.setForeground(new java.awt.Color(0, 0, 0));
        labelOctavos4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(labelOctavos4, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 600, 60, -1));

        labelOctavos5.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        labelOctavos5.setForeground(new java.awt.Color(0, 0, 0));
        labelOctavos5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(labelOctavos5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 420, 60, -1));

        labelOctavos6.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        labelOctavos6.setForeground(new java.awt.Color(0, 0, 0));
        labelOctavos6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(labelOctavos6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 510, 80, 30));

        labelOctavos7.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        labelOctavos7.setForeground(new java.awt.Color(0, 0, 0));
        labelOctavos7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(labelOctavos7, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 600, 60, -1));

        labelSemis.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        labelSemis.setForeground(new java.awt.Color(0, 0, 0));
        labelSemis.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(labelSemis, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 424, 60, 20));

        labelSemis1.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        labelSemis1.setForeground(new java.awt.Color(0, 0, 0));
        labelSemis1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(labelSemis1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 510, 60, -1));

        labelSemis2.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        labelSemis2.setForeground(new java.awt.Color(0, 0, 0));
        labelSemis2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(labelSemis2, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 427, 60, -1));

        labelSemis3.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        labelSemis3.setForeground(new java.awt.Color(0, 0, 0));
        labelSemis3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(labelSemis3, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 510, 60, -1));

        labelFinal.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        labelFinal.setForeground(new java.awt.Color(0, 0, 0));
        labelFinal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(labelFinal, new org.netbeans.lib.awtextra.AbsoluteConstraints(286, 470, 60, -1));

        labelFinal1.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        labelFinal1.setForeground(new java.awt.Color(0, 0, 0));
        labelFinal1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(labelFinal1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 470, 70, -1));

        labelGanador.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        labelGanador.setForeground(new java.awt.Color(0, 0, 0));
        labelGanador.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(labelGanador, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 560, 60, -1));

        flechaCont.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/Flecha.png"))); // NOI18N
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
        getContentPane().add(flechaCont, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 300, 320, 90));

        papelDuelos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/Duelos.png"))); // NOI18N
        getContentPane().add(papelDuelos, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 270, -1, -1));

        cartelDuelos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/CartelG.png"))); // NOI18N
        getContentPane().add(cartelDuelos, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 820, 690));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void flechaContMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_flechaContMouseEntered
        // TODO add your handling code here:

            flechaCont.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/Flecha2.png")));
        
    }//GEN-LAST:event_flechaContMouseEntered

    private void flechaContMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_flechaContMouseExited
        // TODO add your handling code here:
   
            flechaCont.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/Flecha.png")));
        
    }//GEN-LAST:event_flechaContMouseExited

    private void flechaContActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_flechaContActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        if (ganador.obtenerNombre()!=""){
            System.exit(0);
        }else{
            interfazPartida.setVisible(true);
            interfazPartida.setEnabled(true);
        }
       
       
    }//GEN-LAST:event_flechaContActionPerformed

    /**
     * @param args the command line arguments
     */

 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel cartelDuelos;
    private javax.swing.JButton flechaCont;
    private javax.swing.JLabel labelFinal;
    private javax.swing.JLabel labelFinal1;
    private javax.swing.JLabel labelGanador;
    private javax.swing.JLabel labelOctavos;
    private javax.swing.JLabel labelOctavos1;
    private javax.swing.JLabel labelOctavos2;
    private javax.swing.JLabel labelOctavos3;
    private javax.swing.JLabel labelOctavos4;
    private javax.swing.JLabel labelOctavos5;
    private javax.swing.JLabel labelOctavos6;
    private javax.swing.JLabel labelOctavos7;
    private javax.swing.JLabel labelSemis;
    private javax.swing.JLabel labelSemis1;
    private javax.swing.JLabel labelSemis2;
    private javax.swing.JLabel labelSemis3;
    private javax.swing.JLabel papelDuelos;
    // End of variables declaration//GEN-END:variables
}
