/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deadly21;

import static java.lang.Math.random;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author Agustín
 */
public class ListaParticipantes {
    
    Participante primero;
    int largo;
    
    ListaParticipantes(){
        primero = null;
        
        largo=0;
    }
    
    //Metodo para verificar si la lista esta vacia
    public boolean estaVacia(){
        return primero==null;
    }

    //Ingresa un valor al inicio de la lista
    public void ingresarAlPrincipio(String nombre, String actitud){
        if (actitud!=null){
            Participante nuevo = new Participante();
            nuevo.establecerNombre(nombre);  
            nuevo.establecerActitud(actitud);
            
            if (estaVacia()){
                primero = nuevo;
            }else{
                nuevo.establecerSiguiente(primero);
                primero=nuevo;
            }
        }else{
            Participante nuevo = new Participante();  
            nuevo.establecerNombre(nombre);   
            
            if (estaVacia()){
                primero = nuevo;
            }else{
                nuevo.establecerSiguiente(primero);
                primero=nuevo;
            }
        }
        largo++;
    }
    //Ingresa un valor al final de la lista
    public void ingresarAlFinal (String nombre, String actitud){
        Participante aux = primero;
        
        if (actitud!=null){
            ParticipanteMaquina nuevo = new ParticipanteMaquina();
            nuevo.establecerNombre(nombre);  
            nuevo.establecerActitud(actitud);
            
            if (estaVacia()){
                primero = nuevo;
            }else{
                while (aux.obtenerSiguiente()!=null){
                    aux = aux.obtenerSiguiente();
                }
                aux.establecerSiguiente(nuevo);
            }
        }else{
            Participante nuevo = new Participante();  
            nuevo.establecerNombre(nombre);   
            
            if (estaVacia()){
                primero = nuevo;
            }else{
                while (aux.obtenerSiguiente()!=null){
                    aux = aux.obtenerSiguiente();
                }
                aux.establecerSiguiente(nuevo);
            }
        }
        largo++;
    }
    
    //Metodo que devuelve el numero que almacena un nodo dado su indice
    public String obtenerNombreParticipante(int indice){
        Participante aux = primero;
        
        for (int i=0; i<indice;i++){
            aux = aux.obtenerSiguiente();
        }
        return aux.obtenerNombre();
    }
    
    public String obtenerParejaParticipante(int indice){
        Participante aux = primero;
        
        for (int i=0; i<indice;i++){
            aux = aux.obtenerSiguiente();
        }
        return String.valueOf(aux.obtenerPareja());
    }
    
    public Participante parejaJugador()
    {
        Participante aux = primero;
        return aux.obtenerPareja();
    }
    
    
    
    public void emparejar(){
        Participante aux = primero;
        Participante aux2;
        while(aux != null)
        {
            aux2 =aux.obtenerSiguiente();
            aux.establecerPareja(aux2);
            aux2.establecerPareja(aux);
            aux = aux.obtenerSiguiente().obtenerSiguiente();
        }
    }
    
    public void imprimirLista(){
        Participante aux = primero;
        while(aux != null)
        {
            System.out.println(aux.nombre);
            aux = aux.obtenerSiguiente();
        }
    }
    
    public int total(){
        return largo;
    }
    
    public Participante competidor(int indice){
         Participante aux = primero;
         for (int i=0; i< indice-1;i++){
                aux = aux.obtenerSiguiente();
            }
         return aux;
    }
    
    public void duelos(){
        Participante aux = primero;
        Participante aux2;
        while(aux != null)
        {
            aux2 =aux.obtenerSiguiente();
            System.out.println(aux2.pareja.nombre+"     "+aux.pareja.nombre);
            if(aux2 != null)
            {
                aux = aux.obtenerSiguiente().obtenerSiguiente();
            }
            
        }
    }
    //Metodo para eliminar un nodo
    public void eliminar(int indice){
        Participante sigEliminado;
        if (indice ==0 ) {
            sigEliminado = primero;
            primero = sigEliminado.obtenerSiguiente();
        }else {
            Participante aux = primero;
            
            for (int i=0; i< indice-1;i++){
                aux = aux.obtenerSiguiente();
            }
        
            sigEliminado = aux.obtenerSiguiente();
            aux.establecerSiguiente(sigEliminado.obtenerSiguiente());
            
        }
        largo--;
    }
    public void ko(int i)
    {
            int valor = (int) Math.round(Math.random());
            if(valor == 1){
                eliminar(i);
            }
            else{
                eliminar(i+1);
            }
    }
    
    
}
