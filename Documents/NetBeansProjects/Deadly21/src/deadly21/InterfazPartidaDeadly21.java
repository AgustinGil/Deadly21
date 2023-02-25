/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deadly21;

import static deadly21.InterfazMenuDeadly21.ubicacion;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author Agustín
 */
public class InterfazPartidaDeadly21 extends javax.swing.JFrame {

    /**
     * Creates new form InterfazPartidaDeadly21
     */
    public InterfazPartidaDeadly21() {
        initComponents();
        setLocationRelativeTo(null);
    }
    
    static MazoDeCartas mazo= new MazoDeCartas();
    static ListaParticipantes lista = new ListaParticipantes();
    static ListaParticipantes listaInicial = new ListaParticipantes();
    static ListaParticipantes listaSemis = new ListaParticipantes();
    static ListaParticipantes listaFinal = new ListaParticipantes();
    static Scanner scan = new Scanner(System.in);
    static int turno;
    
    public String conseguirCarta(Cartas car){
        String palo = car.obtenerPalo();
        String valor = String.valueOf(car.obtenerValor());
        String imagen;
        
        switch(valor){
            case "1":
                valor="ace";
                break;
            case "11":
                valor="jack";
                break;
            case "12":
                valor="queen";
                break;
            case "13":
                valor="king";
                break;
        }
        
        switch(palo){
            case "Corazon":
                palo="hearts";
                break;
            case "Diamante":
                palo="diamonds";
                break;
            case "Trebol":
                palo="clubs";
                break;
            case "Pica":
                palo="spades";
                break;
        }
        
        imagen="/imagen/Cartas/"+valor+"_"+palo+"_white.png";
        return imagen;
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
            
            System.out.println("Ingrese su nombre");
            lista.ingresarAlPrincipio(scan.nextLine(), null);
            
            
        } catch (IOException e) { 
           
        }
    }
    
    public void establecerCartas(int i){
        Participante Jugador = lista.obtenerParticipante(i);
        Participante Rival = lista.obtenerParejaParticipante(i);
        JLabel aux=null;
        String ubicacion;
        
        for (int j=0; i<=Jugador.tope;j++) {
            switch (j){
                case 1:
                    aux=cartaJugador1;
                    break;
                case 2:
                    aux=cartaJugador2;
                    break;
                case 3:
                    aux=cartaJugador3;
                    break;
                case 4:
                    aux=cartaJugador4;
                    break;
                case 5:
                    aux=cartaJugador5;
                    break;
            }
            ubicacion = conseguirCarta(Jugador.mano[j]);
            System.out.println(ubicacion);
            aux.setIcon(new javax.swing.ImageIcon(getClass().getResource(ubicacion)));
        }
        
    }
    
    public void Partida(int i){
        Participante Jugador = lista.obtenerParticipante(i);
        Participante Rival = lista.obtenerParejaParticipante(i);
        boolean finalRonda=false;
           
        while(Jugador.rondasGanadas<1 || Rival.rondasGanadas<1){
           turno = ThreadLocalRandom.current().nextInt(1,3);
        
            Jugador.pedirCarta();
            Jugador.pedirCarta();

            Rival.pedirCarta();
            Rival.pedirCarta();
            establecerCartas(0);
            while(finalRonda==false){
                if (turno==1 && Rival.decision!=1){
                    turno=2;
                }else if (turno==2 && Jugador.decision!=1){
                    turno=1;
                }

                if (turno==1){
                    if (Jugador.esBlackjack()==false){
                       System.out.println("1.Quedarte 2.Pedir");
                        Jugador.decision = scan.nextInt();
                        Jugador.decidir(); 
                    } 
                    if (Jugador.esBlackjack()==true || Jugador.sePaso()==true){
                        finalRonda=true;
                    }
                }else{
                    Rival.decision = Rival.decidirMaquina();
                    Rival.decidir();
                    if (Rival.esBlackjack()==true || Rival.sePaso()==true){
                        finalRonda=true;
                    }
                }
                if (Jugador.decision==1 && Rival.decision==1){
                    finalRonda=true;
                }
            }
                
            finalRonda=false;
            
            if (Jugador.sumMano()==Rival.sumMano()){
                Jugador.rondasGanadas++;
                Rival.rondasGanadas++;
                System.out.println("Empate");
            }else if (Jugador.sumMano()>Rival.sumMano() && !Jugador.sePaso() || Rival.sePaso() && !Jugador.sePaso()){
                Jugador.rondasGanadas++;
                System.out.println("Gano Jugador");
            }else if (Jugador.sumMano()<Rival.sumMano() && !Rival.sePaso() || Jugador.sePaso() && !Rival.sePaso()){
                Rival.rondasGanadas++;
                System.out.println("Gano Rival");
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
        fondoColor.add(cartasMesa, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 300, 120, 170));
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
    }//GEN-LAST:event_botPlantarActionPerformed

    private void botPedirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botPedirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botPedirActionPerformed

    /**
     * @param args the command line arguments
     */


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
    private javax.swing.JLabel uiJugador;
    private javax.swing.JLabel uiRival;
    // End of variables declaration//GEN-END:variables
}
