/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deadly21;

/**
 *
 * @author Agustín
 */
public class ParticipanteMaquina extends Participante {
    
    String actitud;
    
    public ParticipanteMaquina() {
        super();
        this.actitud="";
    }
    
    public void establecerActitud(String act){
        this.actitud = act;
    }
    
    
    public void decidirMaquina(){
        switch (this.actitud){
            case "Reservado":
                if (this.sumMano()<15){
                    decision=1;
                }else{
                    decision=2;
                }
                break;
            case "Arriesgado":
                if (this.sumMano()<18){
                    decision=1;
                }else{
                    decision=2;
                }
                break;
        }
        
    }
    
}
