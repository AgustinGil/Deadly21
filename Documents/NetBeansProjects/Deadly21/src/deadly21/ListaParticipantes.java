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
public class ListaParticipantes {
    
    Participante primero;
    int largo;
    
    ListaParticipantes(){
        primero = null;
        largo=0;
    }
    
    //Metodo para verificar si la lista esta vacia
    public boolean estaVacia(){
        if (primero==null){
            return true;
        }else{
            return false;
        }
    }

    //Ingresa un valor al inicio de la lista
    public void ingresarAlPrincipio (String nombre, String actitud){
        if (actitud!=null){
            ParticipanteMaquina nuevo = new ParticipanteMaquina();
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
    

    //Metodo que permite insertar un nodo dado un indice
    public void insertarEnIndice(int indice,String nom, String act){
        
        
        if (indice == 0 ) {
            ingresarAlPrincipio(nom,act);
        }else if (indice==largo){
            ingresarAlFinal(nom,act);
        }else{
            Participante aux = primero;
            for (int i=0; i< indice-1;i++){
                aux = aux.obtenerSiguiente();
            }
            
            Participante sigCreado = aux.obtenerSiguiente();
            if(act!=null){
                ParticipanteMaquina nuevo = new ParticipanteMaquina();
                nuevo.establecerNombre(nom);
                nuevo.establecerActitud(act);
                
                aux.establecerSiguiente(nuevo);
                nuevo.establecerSiguiente(sigCreado);
            }else{
                Participante nuevo = new Participante();
                nuevo.establecerNombre(nom);
                aux.establecerSiguiente(nuevo);
                nuevo.establecerSiguiente(sigCreado);
            }
        }
        largo++;
    }
    
    //Metodo para eliminar un nodo
    public void eliminar(int indice){
        if (indice ==0 ) {
            primero = primero.obtenerSiguiente();
        }else {
            Participante aux = primero;
            
            for (int i=0; i< indice-1;i++){
                aux = aux.obtenerSiguiente();
            }
        
            Participante sigEliminado = aux.obtenerSiguiente();
            aux.establecerSiguiente(sigEliminado.obtenerSiguiente());
        }
        largo--;
    }
    
    public void emparejar(){
        Participante aux = primero;
        Participante aux2 = null;
        aux.establecerPareja(aux.obtenerSiguiente());
    }
    
}
