/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deadly21;

import static deadly21.InterfazMenuDeadly21.mazo;

/**
 *
 * @author Agustín
 */
public class Participante {
    
    String nombre;
    Cartas[] mano = new Cartas[5];
    int decision;
    Participante sigParticipantes,pareja;
    
    public Participante(){
        this.nombre="";
        this.decision=0;
        this.sigParticipantes=null;
        this.pareja=null;
    }
    
    public void establecerNombre(String nom){
        this.nombre = nom;
    }
    
    public String obtenerNombre(){
        return this.nombre;
    }
    
    public void establecerSiguiente(Participante par){
        this.sigParticipantes = par;
    }
    
    public Participante obtenerSiguiente(){
        return this.sigParticipantes;
    }
    
    public void establecerPareja(Participante par){
        this.pareja = pareja;
    }
    
    public Participante obtenerPareja(){
        return this.pareja;
    }
    
    public boolean esBlackjack(){
        return this.sumMano()==21;
    }
    
    public boolean sePaso(){
        return this.sumMano()>21;
    }

    public void pedirCarta(){
        this.mano[mazo.tope]= mazo.desapilar();
    }
    
    public int sumMano(){
        int sum=0;
        for(int i=0; i<=4;i++){
            if (this.mano[i].obtenerValor()>10){
                sum=sum+10;
            }else if (this.mano[i].obtenerValor()==1){
                sum=sum+11;
            }else{
                sum = sum + this.mano[i].obtenerValor();
            }
        }
        
        if (sum>21){
            for(int i=0; i<=4;i++){
                if (this.mano[i].obtenerValor()==1){ 
                   sum=sum-10;
                }
                if (sum<21){
                    break;
                }
            }
        }
        return sum;
    }
    
    public void decision(){
        switch(decision){
            case 1:
                break;
            
            case 2:
                pedirCarta();
                break;
        }
    }
}
