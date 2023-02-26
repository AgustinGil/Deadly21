/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deadly21;

import static deadly21.InterfazMenuDeadly21.ubicacion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;


/**
 *
 * @author Agustín
 */
public class InterfazPartidaDeadly21 extends javax.swing.JFrame {
    
    static MazoDeCartas mazo= new MazoDeCartas();
    static ListaParticipantes lista = new ListaParticipantes();
    static ListaParticipantes listaInicial = new ListaParticipantes();
    static ListaParticipantes listaSemis = new ListaParticipantes();
    static ListaParticipantes listaFinal = new ListaParticipantes();
    static Scanner scan = new Scanner(System.in);
    static int turno;
    static boolean finRonda=false;

    static int contador = 0;
    static Participante Jugador;
    static Participante Rival;
    
    /**
     * Creates new form InterfazPartidaDeadly21
     */
    public InterfazPartidaDeadly21() {
        initComponents();
        setLocationRelativeTo(null);
        setVisible(true);
        Jugador = lista.obtenerParticipante(0);
        Rival = lista.obtenerParejaParticipante(0); 
        
        Jugador.pedirCarta();
        Rival.pedirCarta();
        Jugador.pedirCarta();
        Rival.pedirCarta();
        
        barridoCartas();
        
        turno = ThreadLocalRandom.current().nextInt(1,3);
        barridoLuces();
        
        if (turno==2){
            Rival.decision = Rival.decidirMaquina();
            Rival.decidir();
            barridoCartas();
            
            turno=1;
            barridoLuces();
        }
        
    }
   
    public static void cargarParticipantes(){
        int numParticipantes=0;
        
        try {
            BufferedReader lector = new BufferedReader(new FileReader(ubicacion + "jugadores.in.txt"));
            
            while (numParticipantes<7){
                lista.ingresarAlPrincipio(lector.readLine(),lector.readLine());
                System.out.println(lector.readLine());
                
                numParticipantes++;
            }            
            lector.close();  
        } catch (IOException e) { 
           
        }
    }
    
    public void barridoCartas(){
        JLabel aux = null;
        
        for (int i=0;i<=Jugador.tope;i++){
            switch (i){
                case 0:
                    aux=cartaJugador1;
                    break;
                case 1:
                    aux=cartaJugador2;
                    break;
                case 2:
                    aux=cartaJugador3;
                    break;
                case 3:
                    aux=cartaJugador4;
                    break;
                case 4:
                    aux=cartaJugador5;
                    break;
            }
            aux.setIcon(new javax.swing.ImageIcon(getClass().getResource(Jugador.mano[i].imagen)));
        }
        
        for (int i=0;i<=Rival.tope;i++){
            switch (i){
                case 0:
                    aux=cartaRival1;
                    break;
                case 1:
                    aux=cartaRival2;
                    break;
                case 2:
                    aux=cartaRival3;
                    break;
                case 3:
                    aux=cartaRival4;
                    break;
                case 4:
                    aux=cartaRival5;
                    break;
            }
            aux.setIcon(new javax.swing.ImageIcon(getClass().getResource(Rival.mano[i].imagen)));
        }
    }
    
    public void barridoLuces(){
        if (turno==1){
            linternaRival.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/BombilloTurno.png")));
            linternaJugador.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/BombilloTurno2.png")));
        }else if(turno==2){
            linternaRival.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/BombilloTurno2.png")));
            linternaJugador.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/BombilloTurno.png")));
        }
    }
    
    public void Partida(int i,int decision){
        turno=1;
        barridoLuces();
        if (Jugador.manoCharlie() || Rival.manoCharlie()){
            finRonda=true;
        }else if(Rival.sePaso() || Jugador.sePaso()){
            finRonda=true;
        }else if(decision==1 || Jugador.esBlackjack()){
            botPedir.setEnabled(false);
            botPlantar.setEnabled(false);
            if (Rival.decision==1 || Rival.esBlackjack()){
                finRonda=true;
            }
        }else if(decision==2){
            if (Jugador.tope!=4){
               Jugador.pedirCarta(); 
            }
            barridoCartas();
        }
        
        if(Jugador.esBlackjack() || Jugador.sePaso()){
            decision=1;
        }
        
        if (finRonda==false && Rival.decision!=1){
            turno=2;
            barridoLuces();
            
            if (Jugador.manoCharlie() || Rival.manoCharlie()){
                finRonda=true;
            }else if(Rival.sePaso() || Jugador.sePaso()){
                finRonda=true;
            }else if(decision==1 || Jugador.esBlackjack()){
                while (Rival.decision!=1 || Rival.manoCharlie() || !Rival.esBlackjack() || !Rival.sePaso()){
                    Rival.decision = Rival.decidirMaquina();
                    Rival.decidir();
                    barridoCartas();  
                }
                finRonda=true;
            }else{
                Rival.decision = Rival.decidirMaquina();
                Rival.decidir();
                barridoCartas();
                
                if (Rival.decision==1 && decision==1){
                    finRonda=true;
                }
                
            }
        }
        turno=1;
        barridoLuces();
        if(Rival.esBlackjack() || Rival.sePaso()){
            Rival.decision=1;
        }
        
        if (finRonda==true){
            if(Jugador.manoCharlie()){
                Jugador.rondasGanadas++;
                System.out.println("gANO POR MANO CHARLIE");
            }else if(Rival.manoCharlie()){
                Rival.rondasGanadas++;
                System.out.println("gANO POR MANO CHARLIE");
            }else if(decision==1 && Rival.decision==1){
                if (Jugador.sumMano()==Rival.sumMano()){
                    Jugador.rondasGanadas++;
                    Rival.rondasGanadas++;
                    System.out.println("EMPATEE");
                }else if (Jugador.sumMano()>Rival.sumMano() && !Jugador.sePaso() || Rival.sePaso() && !Jugador.sePaso()){
                    Jugador.rondasGanadas++;
                    System.out.println("gANO JUGADOR");
                }else if (Jugador.sumMano()<Rival.sumMano() && !Rival.sePaso() || Jugador.sePaso() && !Rival.sePaso()){
                    Rival.rondasGanadas++;
                    System.out.println("gANO RIVAL");
                }
            }
            
            Jugador.reiniciarValores();
            Rival.reiniciarValores(); 
        }
    }
    
    
    public static void igualar(int indice, ListaParticipantes lis){
        for(int i = 0; i<indice; i++){
            lis.ingresarAlFinal(lista.competidor(i+1).nombre, lista.competidor(i+1).actitud);
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

        fondoColor = new javax.swing.JPanel();
        uiRival = new javax.swing.JLabel();
        uiJugador = new javax.swing.JLabel();
        botPlantar = new javax.swing.JButton();
        botPedir = new javax.swing.JButton();
        cartasMesa = new javax.swing.JLabel();
        cartaJugador5 = new javax.swing.JLabel();
        cartaJugador4 = new javax.swing.JLabel();
        cartaJugador3 = new javax.swing.JLabel();
        cartaJugador2 = new javax.swing.JLabel();
        cartaJugador1 = new javax.swing.JLabel();
        cartaRival1 = new javax.swing.JLabel();
        cartaRival2 = new javax.swing.JLabel();
        cartaRival3 = new javax.swing.JLabel();
        cartaRival4 = new javax.swing.JLabel();
        cartaRival5 = new javax.swing.JLabel();
        linternaRival = new javax.swing.JLabel();
        linternaJugador = new javax.swing.JLabel();
        fondoMesa = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        fondoColor.setBackground(new java.awt.Color(153, 153, 153));
        fondoColor.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        uiRival.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/MarcoPerfil.png"))); // NOI18N
        fondoColor.add(uiRival, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 360, 180));

        uiJugador.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/MarcoPerfil.png"))); // NOI18N
        fondoColor.add(uiJugador, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 570, 360, 180));

        botPlantar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/BotonPlantarse.png"))); // NOI18N
        botPlantar.setText("  ");
        botPlantar.setBorder(null);
        botPlantar.setBorderPainted(false);
        botPlantar.setContentAreaFilled(false);
        botPlantar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botPlantarActionPerformed(evt);
            }
        });
        fondoColor.add(botPlantar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 460, 258, 240));

        botPedir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/BotonPedir.png"))); // NOI18N
        botPedir.setText("  ");
        botPedir.setBorder(null);
        botPedir.setBorderPainted(false);
        botPedir.setContentAreaFilled(false);
        botPedir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botPedirActionPerformed(evt);
            }
        });
        fondoColor.add(botPedir, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 460, 258, 240));

        cartasMesa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/Cartas/back_black_basic_white.png"))); // NOI18N
        fondoColor.add(cartasMesa, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 260, 120, 170));
        fondoColor.add(cartaJugador5, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 580, 120, 170));
        fondoColor.add(cartaJugador4, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 580, 120, 170));
        fondoColor.add(cartaJugador3, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 580, 120, 170));
        fondoColor.add(cartaJugador2, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 580, 120, 170));
        fondoColor.add(cartaJugador1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 580, 120, 170));
        fondoColor.add(cartaRival1, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 10, 120, 170));
        fondoColor.add(cartaRival2, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 10, 120, 170));
        fondoColor.add(cartaRival3, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 10, 120, 170));
        fondoColor.add(cartaRival4, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 10, 120, 170));
        fondoColor.add(cartaRival5, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 10, 120, 170));

        linternaRival.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/BombilloTurno.png"))); // NOI18N
        fondoColor.add(linternaRival, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 250, -1, -1));

        linternaJugador.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/BombilloTurno.png"))); // NOI18N
        fondoColor.add(linternaJugador, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 410, -1, -1));

        fondoMesa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/FondoMesa.png"))); // NOI18N
        fondoMesa.setToolTipText("");
        fondoColor.add(fondoMesa, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 800));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fondoColor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fondoColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botPlantarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botPlantarActionPerformed
        // TODO add your handling code here:
        Partida(0,1);
    }//GEN-LAST:event_botPlantarActionPerformed

    private void botPedirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botPedirActionPerformed
        // TODO add your handling code here:
        Partida(0,2);
    }//GEN-LAST:event_botPedirActionPerformed
    
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
            new InterfazPartidaDeadly21().setVisible(true);
        });
        
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botPedir;
    private javax.swing.JButton botPlantar;
    private javax.swing.JLabel cartaJugador1;
    private javax.swing.JLabel cartaJugador2;
    private javax.swing.JLabel cartaJugador3;
    private javax.swing.JLabel cartaJugador4;
    private javax.swing.JLabel cartaJugador5;
    private javax.swing.JLabel cartaRival1;
    private javax.swing.JLabel cartaRival2;
    private javax.swing.JLabel cartaRival3;
    private javax.swing.JLabel cartaRival4;
    private javax.swing.JLabel cartaRival5;
    private javax.swing.JLabel cartasMesa;
    private javax.swing.JPanel fondoColor;
    private javax.swing.JLabel fondoMesa;
    private javax.swing.JLabel linternaJugador;
    private javax.swing.JLabel linternaRival;
    private javax.swing.JLabel uiJugador;
    private javax.swing.JLabel uiRival;
    // End of variables declaration//GEN-END:variables
}
