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
public class Cartas {
    
    String palo; 
    int valor;
    
    public Cartas() {
        this.palo = "";
        this.valor=0;
    }
    
    public String obtenerPalo(){
        return palo;
    }
    
    public void establecerPalo(String palo){
        this.palo = palo;
    }
    
    public int obtenerValor(){
        return valor;
    }
    
    public void establecerValor(int val){
        this.valor = val;
    }
    
}
