/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deadly21;

import static deadly21.InterfazDeadly21.mazo;

/**
 *
 * @author Agustín
 */
public class Participantes {
    
    String nombre;
    Cartas[] mano = new Cartas[5];
    int tope,decision;
    
    public Participantes(){
        this.nombre="";
        this.decision=0;
        this.tope=-1;
    }
    
    public String obtenerNombre(){
        return nombre;
    }

    public void pedirCarta(){
        this.tope++;
        this.mano[this.tope]= mazo.desapilar();
    }
    
    public int sumMano(){
        int sum=0;
        for(int i=0; i<=4;i++){
            if (this.mano[i].obtenerValor()>10){
                sum=sum+10;
            }else if (this.mano[i].obtenerValor()==1){
                sum=sum+1;
            }else{
                sum = sum + this.mano[i].obtenerValor();
            }
        }
        
        if (sum>21){
            for(int i=0; i<=4;i++){
                if (this.mano[i].obtenerValor()==1){ 
                   sum=sum-9;
                }
                
                if (sum<21){
                    break;
                }
            }
        }
        return sum;
    }
    
    public boolean esBlackjack(){
        return this.sumMano()==21;
    }
    
    public boolean sePaso(){
        return this.sumMano()>21;
    }
}
